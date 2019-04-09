/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import map.mapprocessor.InvalidMapException;
import map.mapprocessor.MapParser;
import models.GameBoard;
import models.GameMap;
import models.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import resources.Constants;

/**
 * All tests are performed on nancy.map It is assumed that 2 players are playing
 *
 * @author daksh
 */
public class ReinforcementPhaseControllerTest {

    Player player;
    GameBoard gameBoard;
    ReinforcementPhaseController rpc;

    String location;

    /**
     * Constructor used to initialize ReinforcementPhaseController object
     */
    public ReinforcementPhaseControllerTest() {
        rpc = new ReinforcementPhaseController();

        File currentDirectory = new File(new File(".").getAbsolutePath());
        String projectDirectory = currentDirectory.getAbsolutePath();
        location = projectDirectory + "\\Test Maps\\";
    }

    /**
     * Initialize Player, GameBoard, Map objects and sets them.
     *
     * @throws InvalidMapException if map is invalid
     */
    @Before
    public void setUp() throws InvalidMapException {
        player = new Player();
        gameBoard = new GameBoard();
        GameMap map = MapParser.parseMap(location + "valid_maps\\nancy.map");
        gameBoard.setMap(map);
        player.setGameBoard(gameBoard);
        rpc.setPlayer(player);
        rpc.setGameBoard(gameBoard);
    }

    /**
     * Test of doMove method, of ReinforcementPhaseController class Checks
     * whether country is reinforced or not Reinforcing INDIA with 5 more armies
     */
    @Test
    public void testDoMove() {
        System.out.println("doMove");

        HashMap<String, Integer> countryArmyInfo = new HashMap<String, Integer>();
        countryArmyInfo.put("INDIA", 2);
        countryArmyInfo.put("ENGLAND", 5);
        player.setCountryArmyInfo(countryArmyInfo);

        String countryName = "INDIA";
        int moveNumber = 5;

        rpc.reinforcement = 10;
        rpc.doMove(countryName, moveNumber);

        //After move army in INDIA should increase to 7
        HashMap<String, Integer> expCountryArmyInfo = new HashMap<String, Integer>();
        expCountryArmyInfo.put("INDIA", 7);
        expCountryArmyInfo.put("ENGLAND", 5);

        int expReinforcement = 5;
        assertEquals(expCountryArmyInfo, player.getCountryArmyInfo());
        assertEquals(expReinforcement, rpc.reinforcement);

    }

    /**
     * Test of doCompulsoryTradeIn method, of class
     * ReinforcementPhaseController. Doing trading of 1 artillery, 1 cavalry,
     * and 1 infantry card
     */
    @Test
    public void testDoCompulsoryTradeIn_intArr_1() {
        System.out.println("doCompulsoryTradeIn");

        HashMap<Constants.RISKCARD, Integer> cardsInfo = new HashMap<>();

        cardsInfo.put(Constants.RISKCARD.ARTILLERY, 2);
        cardsInfo.put(Constants.RISKCARD.CAVALRY, 2);
        cardsInfo.put(Constants.RISKCARD.INFANTRY, 2);

        player.setCardsInfoInitial(cardsInfo);

        int[] choice = {1, 1, 1};

        rpc.doCompulsoryTradeIn(choice);

        HashMap<Constants.RISKCARD, Integer> expCardsInfo = new HashMap<>();

        expCardsInfo.put(Constants.RISKCARD.ARTILLERY, 1);
        expCardsInfo.put(Constants.RISKCARD.CAVALRY, 1);
        expCardsInfo.put(Constants.RISKCARD.INFANTRY, 1);

        assertEquals(expCardsInfo, player.cardsInfo);

    }

    /**
     * Test of doCompulsoryTradeIn method, of class
     * ReinforcementPhaseController. Doing trading of 3 artillery, 0 cavalry,
     * and 0 infantry card
     */
    @Test
    public void testDoCompulsoryTradeIn_intArr_2() {
        System.out.println("doCompulsoryTradeIn");

        HashMap<Constants.RISKCARD, Integer> cardsInfo = new HashMap<>();

        cardsInfo.put(Constants.RISKCARD.ARTILLERY, 3);
        cardsInfo.put(Constants.RISKCARD.CAVALRY, 2);
        cardsInfo.put(Constants.RISKCARD.INFANTRY, 1);

        player.setCardsInfoInitial(cardsInfo);

        int[] choice = {3, 0, 0};

        rpc.doCompulsoryTradeIn(choice);

        HashMap<Constants.RISKCARD, Integer> expCardsInfo = new HashMap<>();

        expCardsInfo.put(Constants.RISKCARD.ARTILLERY, 0);
        expCardsInfo.put(Constants.RISKCARD.CAVALRY, 2);
        expCardsInfo.put(Constants.RISKCARD.INFANTRY, 1);

        assertEquals(expCardsInfo, player.cardsInfo);

    }

    /**
     * Test of calculateReinforcementFromContinents method, of class
     * ReinforcementPhaseController.
     */
    @Test
    public void testCalculateReinforcementFromContinents_1() {
        System.out.println("calculateReinforcementFromContinents");

        ArrayList<String> nameOfContinents = new ArrayList<>();
        nameOfContinents.add("ASIA");
        player.setNameOfContinents(nameOfContinents);

        player.setNumberOfContinents(1);

        int expResult = 1;
        int result = rpc.calculateReinforcementFromContinents();
        assertEquals(expResult, result);

    }

    /**
     * Test of calculateReinforcementFromContinents method, of class
     * ReinforcementPhaseController.
     */
    @Test
    public void testCalculateReinforcementFromContinents_2() {
        System.out.println("calculateReinforcementFromContinents");

        ArrayList<String> nameOfContinents = new ArrayList<>();
        nameOfContinents.add("ASIA");
        nameOfContinents.add("EUROPE");

        player.setNameOfContinents(nameOfContinents);

        player.setNumberOfContinents(2);
        int expResult = 3;
        int result = rpc.calculateReinforcementFromContinents();
        assertEquals(expResult, result);

    }

    /**
     * Test of calculateReinforcementFromCountry method, of class
     * ReinforcementPhaseController.
     */
    @Test
    public void testCalculateReinforcementFromCountry_1() {
        System.out.println("calculateReinforcementFromCountry");

        player.setNumberOfCountries(5);
        int expResult = 3;
        int result = rpc.calculateReinforcementFromCountry();
        assertEquals(expResult, result);

    }

    /**
     * Test of calculateReinforcementFromCountry method, of class
     * ReinforcementPhaseController.
     */
    @Test
    public void testCalculateReinforcementFromCountry_2() {
        System.out.println("calculateReinforcementFromCountry");

        player.setNumberOfCountries(14);
        int expResult = 4;
        int result = rpc.calculateReinforcementFromCountry();
        assertEquals(expResult, result);

    }

    /**
     * Test of calculateReinforcementFromCountry method, of class
     * ReinforcementPhaseController.
     */
    @Test
    public void testCalculateReinforcementFromCountry_3() {
        System.out.println("calculateReinforcementFromCountry");

        player.setNumberOfCountries(2);
        int expResult = 3;
        int result = rpc.calculateReinforcementFromCountry();
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidMoveNumber method, of class ReinforcementPhaseController
     */
    @Test
    public void testIsValidMoveNumber_1() {
        System.out.println("isValidMoveNumber");

        rpc.setReinforcement(10);
        boolean result = rpc.isValidMoveNumber(5);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidMoveNumber method, of class ReinforcementPhaseController
     */
    @Test
    public void testIsValidMoveNumber_2() {
        System.out.println("isValidMoveNumber");

        rpc.setReinforcement(10);
        boolean result = rpc.isValidMoveNumber(15);
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidChoice method, of class ReinforcementPhaseController.
     */
    @Test
    public void testIsValidChoice() {
        System.out.println("isValidChoice");

        int[] choice = {1, 1, 1};
        boolean expResult = true;
        boolean result = rpc.isValidChoice(choice);
        assertEquals(expResult, result);

        int[] choice2 = {3, 0, 0};
        boolean expResult2 = true;
        boolean result2 = rpc.isValidChoice(choice2);
        assertEquals(expResult2, result2);

        int[] choice3 = {0, 3, 0};
        boolean expResult3 = true;
        boolean result3 = rpc.isValidChoice(choice3);
        assertEquals(expResult3, result3);

        int[] choice4 = {0, 0, 3};
        boolean expResult4 = true;
        boolean result4 = rpc.isValidChoice(choice4);
        assertEquals(expResult4, result4);

        int[] choice5 = {3, 3, 3};
        boolean expResult5 = false;
        boolean result5 = rpc.isValidChoice(choice5);
        assertEquals(expResult5, result5);

        int[] choice6 = {6, 5, 4};
        boolean expResult6 = false;
        boolean result6 = rpc.isValidChoice(choice6);
        assertEquals(expResult6, result6);
    }

    /**
     *
     * Test of checkTradeInPossible method, of class
     * ReinforcementPhaseController.
     */
    @Test
    public void testCheckTradeInPossible_1() {
        System.out.println("checkTradeInPossible");

        HashMap<Constants.RISKCARD, Integer> cardsInfo = new HashMap<>();

        cardsInfo.put(Constants.RISKCARD.ARTILLERY, 1);
        cardsInfo.put(Constants.RISKCARD.CAVALRY, 1);
        cardsInfo.put(Constants.RISKCARD.INFANTRY, 1);

        player.setCardsInfoInitial(cardsInfo);

        int[] choice = {1, 1, 1};
        boolean expResult = true;
        boolean result = rpc.checkTradeInPossible(choice);
        assertEquals(expResult, result);

    }

    /**
     * Test of checkTradeInPossible method, of class
     * ReinforcementPhaseController.
     */
    @Test
    public void testCheckTradeInPossible_2() {
        System.out.println("checkTradeInPossible");

        HashMap<Constants.RISKCARD, Integer> cardsInfo = new HashMap<>();

        cardsInfo.put(Constants.RISKCARD.ARTILLERY, 2);
        cardsInfo.put(Constants.RISKCARD.CAVALRY, 2);
        cardsInfo.put(Constants.RISKCARD.INFANTRY, 2);

        player.setCardsInfoInitial(cardsInfo);

        int[] choice = {3, 0, 0};
        boolean expResult = false;
        boolean result = rpc.checkTradeInPossible(choice);
        assertEquals(expResult, result);

    }

    /**
     * Test of checkEligilibityForTradeIn method, of class
     * ReinforcementPhaseController.
     */
    @Test
    public void testCheckEligilibityForTradeIn_1() {
        System.out.println("checkEligilibityForTradeIn");

        HashMap<Constants.RISKCARD, Integer> cardsInfo = new HashMap<>();

        cardsInfo.put(Constants.RISKCARD.ARTILLERY, 2);
        cardsInfo.put(Constants.RISKCARD.CAVALRY, 2);
        cardsInfo.put(Constants.RISKCARD.INFANTRY, 2);

        player.setCardsInfoInitial(cardsInfo);

        boolean expResult = true;
        boolean result = rpc.checkEligilibityForTradeIn();
        assertEquals(expResult, result);

    }

    /**
     * Test of checkEligilibityForTradeIn method, of class
     * ReinforcementPhaseController.
     */
    @Test
    public void testCheckEligilibityForTradeIn_2() {
        System.out.println("checkEligilibityForTradeIn");

        HashMap<Constants.RISKCARD, Integer> cardsInfo = new HashMap<>();

        cardsInfo.put(Constants.RISKCARD.ARTILLERY, 0);
        cardsInfo.put(Constants.RISKCARD.CAVALRY, 3);
        cardsInfo.put(Constants.RISKCARD.INFANTRY, 0);

        player.setCardsInfoInitial(cardsInfo);

        boolean expResult = true;
        boolean result = rpc.checkEligilibityForTradeIn();
        assertEquals(expResult, result);

    }

    /**
     * Test of checkEligilibityForTradeIn method, of class
     * ReinforcementPhaseController.
     */
    @Test
    public void testCheckEligilibityForTradeIn_3() {
        System.out.println("checkEligilibityForTradeIn");

        HashMap<Constants.RISKCARD, Integer> cardsInfo = new HashMap<>();

        cardsInfo.put(Constants.RISKCARD.ARTILLERY, 0);
        cardsInfo.put(Constants.RISKCARD.CAVALRY, 2);
        cardsInfo.put(Constants.RISKCARD.INFANTRY, 2);

        player.setCardsInfoInitial(cardsInfo);

        boolean expResult = false;
        boolean result = rpc.checkEligilibityForTradeIn();
        assertEquals(expResult, result);

    }

    /**
     * Test of isValidCountryName method, of class ReinforcementPhaseController.
     */
    @Test
    public void testIsValidCountryName() {
        System.out.println("isValidCountryName");
        String countryName = "India";

        Player p = new Player();
        ArrayList<String> nameOfCountries = new ArrayList<>();
        nameOfCountries.add("INDIA");
        nameOfCountries.add("AUSTRALIA");
        nameOfCountries.add("CHINA");
        nameOfCountries.add("AMERICA");
        p.setNameOfCountries(nameOfCountries);

        ReinforcementPhaseController instance = new ReinforcementPhaseController();
        instance.setPlayer(p);

        countryName = "India";
        boolean expResult = true;
        boolean result = instance.isValidCountryName(countryName);
        assertEquals(expResult, result);

        countryName = "America";
        boolean expResult2 = true;
        boolean result2 = instance.isValidCountryName(countryName);
        assertEquals(expResult2, result2);

        countryName = "Africa";
        boolean expResult3 = false;
        boolean result3 = instance.isValidCountryName(countryName);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of validTradeInChoice method, of class ReinforcementPhaseController.
     */
    @Test
    public void testValidTradeInChoice() {
        System.out.println("validTradeInChoice");
        ReinforcementPhaseController instance = new ReinforcementPhaseController();

        int tradeInChoice = 0;
        boolean expResult = false;
        boolean result = instance.validTradeInChoice(tradeInChoice);
        assertEquals(expResult, result);

        tradeInChoice = 1;
        boolean expResult2 = true;
        boolean result2 = instance.validTradeInChoice(tradeInChoice);
        assertEquals(expResult2, result2);

        tradeInChoice = 2;
        boolean expResult3 = true;
        boolean result3 = instance.validTradeInChoice(tradeInChoice);
        assertEquals(expResult3, result3);

    }

}
