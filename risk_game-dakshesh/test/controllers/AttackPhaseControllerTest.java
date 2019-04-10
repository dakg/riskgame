/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import game_engine.GameSetup;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import map.mapprocessor.InvalidMapException;
import map.mapprocessor.MapParser;
import models.GameBoard;
import models.GameMap;
import models.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import resources.Constants;

/**
 * This is the Test Class for Attack Phase
 * @author shivam
 */
public class AttackPhaseControllerTest {

    GameMap map;
    GameBoard gb;
    Player player;
    String location;
    AttackPhaseController instance;

    /**
     *
     */
    public AttackPhaseControllerTest() {
        instance = new AttackPhaseController();

        File currentDirectory = new File(new File(".").getAbsolutePath());
        String projectDirectory = currentDirectory.getAbsolutePath();
        location = projectDirectory + "\\Test Maps\\";

    }

    /**
     *
     * @throws InvalidMapException
     */
    @Before
    public void setUp() throws InvalidMapException {
        map = MapParser.parseMap(location + "\\valid_maps\\nancy.map");
        gb = new GameBoard();
        gb.setMap(map);
        GameSetup.setRiskCards(gb);
        player = new Player();
        player.setPlayerName("player 0");
        player.setGameBoard(gb);
        HashMap<Constants.RISKCARD, Integer> cardsInfo = new HashMap<>();
        cardsInfo.put(Constants.RISKCARD.ARTILLERY, 2);
        cardsInfo.put(Constants.RISKCARD.CAVALRY, 2);
        cardsInfo.put(Constants.RISKCARD.INFANTRY, 2);

        player.setCardsInfoInitial(cardsInfo);

        instance.setGameBoard(gb);
        instance.setPlayer(player);
//        HashMap<>

    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of adjacentCountries method, of class AttackPhaseController. Checks
     * the correct adjacent countries of the source country
     * @throws map.mapprocessor.InvalidMapException
     */
    @org.junit.Test
    public void testAdjacentCountries_0() throws InvalidMapException {
        System.out.println("adjacentCountries");

        String countryName = "INDIA";
        ArrayList<String> expResult = new ArrayList();
        expResult.add("ENGLAND");
        expResult.add("PARIS");

        ArrayList<String> result = instance.adjacentCountries(countryName);
        assertEquals(expResult, result);

    }

    /**
     * Test of adjacentCountries method, of class AttackPhaseController. Checks
     * the non adjacent countries of the source country
     * @throws map.mapprocessor.InvalidMapException
     */
    @org.junit.Test
    public void testAdjacentCountries_1() throws InvalidMapException {
        System.out.println("adjacentCountries");

        String countryName = "INDIA";
        ArrayList<String> expResult = new ArrayList();
        expResult.add("ENGLAND");
        expResult.add("AMERICA");

        ArrayList<String> result = instance.adjacentCountries(countryName);
        assertNotSame(expResult, result);

    }

    /**
     * Test of isValidAttackerDiceRolls method, of class AttackPhaseController.
     * Checks Valid Number of Dice Rolls by the attacker
     */
    @org.junit.Test
    public void testIsValidAttackerDiceRolls_0() {
        System.out.println("isValidAttackerDiceRolls");
        int rolls = 3;
        int army = 5;
        boolean expResult = true;
        boolean result = instance.isValidAttackerDiceRolls(rolls, army);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidAttackerDiceRolls method, of class AttackPhaseController.
     * Checks InValid Number of Dice Rolls by the attacker
     */
    @org.junit.Test
    public void testIsValidAttackerDiceRolls_1() {
        System.out.println("isValidAttackerDiceRolls");
        int rolls = 3;
        int army = 3;
        boolean expResult = false;
        boolean result = instance.isValidAttackerDiceRolls(rolls, army);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidDefenderDiceRolls method, of class AttackPhaseController.
     * Checks Valid Number of Dice rolls by defender
     */
    @org.junit.Test
    public void testIsValidDefenderDiceRolls_0() {
        System.out.println("isValidDefenderDiceRolls");
        int rolls = 2;
        int army = 2;
        boolean expResult = true;
        boolean result = instance.isValidDefenderDiceRolls(rolls, army);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidDefenderDiceRolls method, of class AttackPhaseController.
     * Checks Invalid Number of rolls by defender
     */
    @org.junit.Test
    public void testIsValidDefenderDiceRolls_1() {
        System.out.println("isValidDefenderDiceRolls");
        int rolls = 3;
        int army = 2;
        boolean expResult = false;
        boolean result = instance.isValidDefenderDiceRolls(rolls, army);
        assertEquals(expResult, result);
    }

    /**
     * Test of diceRollsCompareResult method, of class AttackPhaseController.
     * Computes the Result of the attack through Dice Rolled (Here attacker wins)
     */
    @org.junit.Test
    public void testDiceRollsCompareResult_0() {
        System.out.println("diceRollsCompareResult");

        ArrayList<Integer> diceRollValue1 = new ArrayList<Integer>();
        ArrayList<Integer> diceRollValue2 = new ArrayList<Integer>();

        diceRollValue1.add(6);
        diceRollValue1.add(6);
        
        diceRollValue2.add(3);

        String sourceCountry = "INDIA";
        String targetCountry = "PARIS";
        
        Player player2 = new Player();
        player2.setPlayerName("player 1");
        player2.setGameBoard(gb);
        
        HashMap<Constants.RISKCARD, Integer> cardsInfo = new HashMap<>();
        cardsInfo.put(Constants.RISKCARD.ARTILLERY, 2);
        cardsInfo.put(Constants.RISKCARD.CAVALRY, 2);
        cardsInfo.put(Constants.RISKCARD.INFANTRY, 2);

        player2.setCardsInfoInitial(cardsInfo);


        HashMap<String, Integer> countryInfo = new HashMap();
        countryInfo.put("INDIA", 5);
        player.setCountryArmyInfo(countryInfo);

        HashMap<String, Integer> targetCountryInfo = new HashMap();
        targetCountryInfo.put("PARIS", 3);
        player2.setCountryArmyInfo(targetCountryInfo);

        HashMap<String, HashMap<String, Integer>> playerCountries = new HashMap();
        playerCountries.put("player 0", countryInfo);
        playerCountries.put("player 1", targetCountryInfo);
        gb.setPlayerCountries(playerCountries);

        HashMap<String, Player> playerNamePlayerObject = new HashMap();
        playerNamePlayerObject.put(player.getPlayerName(), player);
        playerNamePlayerObject.put(player2.getPlayerName(), player2);
        gb.setPlayerNamePlayerObject(playerNamePlayerObject);


        int expResult = 1;
        int result = instance.diceRollsCompareResult(diceRollValue1, diceRollValue2, sourceCountry, targetCountry);
        assertEquals(expResult, result);
        
        HashMap<String,Integer> expSourceCountryInfo = new HashMap();
        expSourceCountryInfo.put("INDIA", 5);
        
        HashMap<String,Integer> expTargetCountryInfo = new HashMap();
        expTargetCountryInfo.put("PARIS", 2);
       
        assertEquals(expTargetCountryInfo,player2.getCountryArmyInfo());
        
        
    }

    /**
     *Test of updateArmyInfoAttacker method, of class AttackPhaseController.
     * Checks the Updated Army of the Country after the Army has been moved.
     */
    @org.junit.Test
    public void testupdateArmyInfoAttacker_0() {
        System.out.println("isUpdateArmyInfoAttacker");
        String sourceCountry = "INDIA";
        String targetCountry = "PARIS";
        int numberOfArmyToMove = 2;

        Player player2 = new Player();
        player2.setPlayerName("player 1");
        player2.setGameBoard(gb);
        
        HashMap<Constants.RISKCARD, Integer> cardsInfo = new HashMap<>();
        cardsInfo.put(Constants.RISKCARD.ARTILLERY, 2);
        cardsInfo.put(Constants.RISKCARD.CAVALRY, 2);
        cardsInfo.put(Constants.RISKCARD.INFANTRY, 2);

        player2.setCardsInfoInitial(cardsInfo);


        HashMap<String, Integer> countryInfo = new HashMap();
        countryInfo.put("INDIA", 5);
        player.setCountryArmyInfo(countryInfo);

        HashMap<String, Integer> targetCountryInfo = new HashMap();
        targetCountryInfo.put("PARIS", 0);
        player2.setCountryArmyInfo(targetCountryInfo);

        HashMap<String, HashMap<String, Integer>> playerCountries = new HashMap();
        playerCountries.put("player 0", countryInfo);
        playerCountries.put("player 1", targetCountryInfo);
        gb.setPlayerCountries(playerCountries);

        HashMap<String, Player> playerNamePlayerObject = new HashMap();
        playerNamePlayerObject.put(player.getPlayerName(), player);
        playerNamePlayerObject.put(player2.getPlayerName(), player2);
        gb.setPlayerNamePlayerObject(playerNamePlayerObject);

        HashMap<String, Integer> expCountryInfo = new HashMap();
        expCountryInfo.put("INDIA", 3);
        expCountryInfo.put("PARIS", 2);

        instance.updateArmyInfoAttacker(numberOfArmyToMove, sourceCountry, targetCountry);

        assertEquals(expCountryInfo, countryInfo);

    }

    /**
     * Test of isValidNumberOfArmyMove method, of class AttackPhaseController.
     * Number of valid army to move
     */
    @org.junit.Test
    public void testIsValidNumberOfArmyMove_0() {
        System.out.println("isValidNumberOfArmyMove");

        String sourceCountry = "INDIA";
        HashMap<String, Integer> armyInfo = new HashMap();
        armyInfo.put("INDIA", 5);

        HashMap<String, HashMap<String, Integer>> playerCountries = new HashMap();
        playerCountries.put("player 0", armyInfo);

        gb.setPlayerCountries(playerCountries);

        int numberOfArmy = 3;
        int attackerRolls = 2;
        boolean expResult = true;
        boolean result = instance.isValidNumberOfArmyMove(sourceCountry, numberOfArmy, attackerRolls);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidNumberOfArmyMove method, of class AttackPhaseController.
     * Number of InValid army to move
     */
    @org.junit.Test
    public void testIsValidNumberOfArmyMove_1() {
        System.out.println("isValidNumberOfArmyMove");

        String sourceCountry = "INDIA";
        HashMap<String, Integer> armyInfo = new HashMap();
        armyInfo.put("INDIA", 5);

        HashMap<String, HashMap<String, Integer>> playerCountries = new HashMap();
        playerCountries.put("player 0", armyInfo);

        gb.setPlayerCountries(playerCountries);

        int numberOfArmy = 1;
        int attackerRolls = 2;
        boolean expResult = false;
        boolean result = instance.isValidNumberOfArmyMove(sourceCountry, numberOfArmy, attackerRolls);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkWinnerOfWholeMap method, of class AttackPhaseController.
     * Checks winner of whole map if he is not the owner of all the countries in
     * the world
     */
    @org.junit.Test
    public void testCheckWinnerOfWholeMap_0() {
        System.out.println("checkWinnerOfWholeMap");

        int numberOfCountries = 1;
        player.setNumberOfCountries(numberOfCountries);
        gb.getMap().setNumberOfCountries(3);

        boolean expResult = false;
        boolean result = instance.checkWinnerOfWholeMap();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkWinnerOfWholeMap method, of class AttackPhaseController.
     * Checks winner of whole map if he is the owner of all the countries in the
     * world
     */
    @org.junit.Test
    public void testCheckWinnerOfWholeMap_1() {
        System.out.println("checkWinnerOfWholeMap");

        int numberOfCountries = 3;
        player.setNumberOfCountries(numberOfCountries);
        gb.getMap().setNumberOfCountries(3);

        boolean expResult = true;
        boolean result = instance.checkWinnerOfWholeMap();
        assertEquals(expResult, result);
    }

    /**
     * Test of numberOfArmy method, of class AttackPhaseController. Invalid
     * number of army checked
     */
    @org.junit.Test
    public void testNumberOfArmy_0() {
        System.out.println("numberOfArmy");

        HashMap<String, Integer> armyInfo = new HashMap();
        armyInfo.put("INDIA", 5);

        HashMap<String, HashMap<String, Integer>> playerCountries = new HashMap();
        playerCountries.put("player 0", armyInfo);

        gb.setPlayerCountries(playerCountries);

        String country = "INDIA";
        int expResult = 1;
        int result = instance.numberOfArmy(country);
        assertNotSame(expResult, result);

    }

    /**
     * Test of numberOfArmy method, of class AttackPhaseController. Valid number
     * of army checked
     */
    @org.junit.Test
    public void testNumberOfArmy_1() {
        System.out.println("numberOfArmy");

        HashMap<String, Integer> armyInfo = new HashMap();
        armyInfo.put("INDIA", 5);

        HashMap<String, HashMap<String, Integer>> playerCountries = new HashMap();
        playerCountries.put("player 0", armyInfo);

        gb.setPlayerCountries(playerCountries);

        String country = "INDIA";
        int expResult = 5;
        int result = instance.numberOfArmy(country);
        assertEquals(expResult, result);

    }

    /**
     * Test of countryOwner method, of class AttackPhaseController. Legal Owner
     * of the country
     */
    @org.junit.Test
    public void testCountryOwner_0() {
        System.out.println("countryOwner");

        HashMap<String, Integer> armyInfo = new HashMap();
        armyInfo.put("INDIA", 5);

        HashMap<String, HashMap<String, Integer>> playerCountries = new HashMap();
        playerCountries.put("player 0", armyInfo);

        gb.setPlayerCountries(playerCountries);

        String country = "INDIA";

        String expResult = "player 0";
        String result = instance.countryOwner(country);
        assertEquals(expResult, result);
    }

    /**
     * Test of countryOwner method, of class AttackPhaseController. Illegal
     * Owner of the country
     */
    @org.junit.Test
    public void testCountryOwner_1() {
        System.out.println("countryOwner");

        HashMap<String, Integer> armyInfo = new HashMap();
        armyInfo.put("INDIA", 5);

        HashMap<String, HashMap<String, Integer>> playerCountries = new HashMap();
        playerCountries.put("player 0", armyInfo);

        gb.setPlayerCountries(playerCountries);

        String country = "INDIA";

        String expResult = "player 2";
        String result = instance.countryOwner(country);
        assertNotSame(expResult, result);
    }

    /**
     * Test of isValidSourceCountry method, of class AttackPhaseController.
     * Valid Source country Tested
     * @throws map.mapprocessor.InvalidMapException
     */
    @org.junit.Test
    public void testIsValidSourceCountry_0() throws InvalidMapException {

        ArrayList<String> countries = new ArrayList();
        countries.add("INDIA");
        countries.add("ENGLAND");
        countries.add("PARIS");

        ArrayList<String> continents = new ArrayList();
        continents.add("ASIA");
        continents.add("EUROPE");

        player.setNameOfCountries(countries);
        player.setNameOfContinents(continents);

        HashMap<String, Integer> armyInfo = new HashMap();
        armyInfo.put("INDIA", 5);
        HashMap<String, Integer> armyInfo1 = new HashMap();
        armyInfo1.put("ENGLAND", 5);
        armyInfo1.put("PARIS", 5);

        player.setCountryArmyInfo(armyInfo);

        HashMap<String, HashMap<String, Integer>> playerCountries = new HashMap();
        playerCountries.put("player 0", armyInfo);
        playerCountries.put("player 1", armyInfo1);

        gb.setPlayerCountries(playerCountries);
        player.setPlayerName("player 0");

        System.out.println("isValidSourceCountry");

        String country = "INDIA";

        boolean expResult = true;
        boolean result = instance.isValidSourceCountry(country);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidSourceCountry method, of class AttackPhaseController.
     * Invalid Source country given
     * @throws map.mapprocessor.InvalidMapException
     */
    @org.junit.Test
    public void testIsValidSourceCountry_1() throws InvalidMapException {

        ArrayList<String> countries = new ArrayList();
        countries.add("INDIA");
        countries.add("ENGLAND");
        countries.add("PARIS");

        ArrayList<String> continents = new ArrayList();
        continents.add("ASIA");
        continents.add("EUROPE");

        player.setNameOfCountries(countries);
        player.setNameOfContinents(continents);

        HashMap<String, Integer> armyInfo = new HashMap();
        armyInfo.put("INDIA", 5);
        HashMap<String, Integer> armyInfo1 = new HashMap();
        armyInfo1.put("ENGLAND", 5);
        armyInfo1.put("PARIS", 5);

        player.setCountryArmyInfo(armyInfo);

        HashMap<String, HashMap<String, Integer>> playerCountries = new HashMap();
        playerCountries.put("player 0", armyInfo);
        playerCountries.put("player 1", armyInfo1);

        gb.setPlayerCountries(playerCountries);
        player.setPlayerName("player 0");

        System.out.println("isValidSourceCountry");

        String country = "PARIS";

        boolean expResult = false;
        boolean result = instance.isValidSourceCountry(country);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidSourceCountry method, of class AttackPhaseController.
     * Invalid number of armies in the source country
     * @throws map.mapprocessor.InvalidMapException
     */
    @org.junit.Test
    public void testIsValidSourceCountry_2() throws InvalidMapException {

        ArrayList<String> countries = new ArrayList();
        countries.add("INDIA");
        countries.add("ENGLAND");
        countries.add("PARIS");

        ArrayList<String> continents = new ArrayList();
        continents.add("ASIA");
        continents.add("EUROPE");

        player.setNameOfCountries(countries);
        player.setNameOfContinents(continents);

        HashMap<String, Integer> armyInfo = new HashMap();
        armyInfo.put("INDIA", 1);
        HashMap<String, Integer> armyInfo1 = new HashMap();
        armyInfo1.put("ENGLAND", 5);
        armyInfo1.put("PARIS", 5);

        player.setCountryArmyInfo(armyInfo);

        HashMap<String, HashMap<String, Integer>> playerCountries = new HashMap();
        playerCountries.put("player 0", armyInfo);
        playerCountries.put("player 1", armyInfo1);

        gb.setPlayerCountries(playerCountries);
        player.setPlayerName("player 0");

        System.out.println("isValidSourceCountry");

        String country = "INDIA";

        boolean expResult = false;
        boolean result = instance.isValidSourceCountry(country);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidSourceCountry method, of class AttackPhaseController.
     * Valid Source country with no countries to other player
     * @throws map.mapprocessor.InvalidMapException
     */
    @org.junit.Test
    public void testIsValidSourceCountry_3() throws InvalidMapException {

        ArrayList<String> countries = new ArrayList();
        countries.add("INDIA");
        countries.add("ENGLAND");
        countries.add("PARIS");

        ArrayList<String> continents = new ArrayList();
        continents.add("ASIA");
        continents.add("EUROPE");

        player.setNameOfCountries(countries);
        player.setNameOfContinents(continents);

        HashMap<String, Integer> armyInfo = new HashMap();
        armyInfo.put("INDIA", 5);
        armyInfo.put("ENGLAND", 5);
        armyInfo.put("PARIS", 5);

        HashMap<String, Integer> armyInfo1 = new HashMap();

        player.setCountryArmyInfo(armyInfo);

        HashMap<String, HashMap<String, Integer>> playerCountries = new HashMap();
        playerCountries.put("player 0", armyInfo);
        playerCountries.put("player 1", armyInfo1);

        gb.setPlayerCountries(playerCountries);
        player.setPlayerName("player 0");

        System.out.println("isValidSourceCountry");

        String country = "INDIA";

        boolean expResult = false;
        boolean result = instance.isValidSourceCountry(country);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidTargetCountry method, of class AttackPhaseController.
     * Valid Target Country
     */
    @org.junit.Test
    public void testIsValidTargetCountry_0() {
        System.out.println("isValidTargetCountry");

        ArrayList<String> countries = new ArrayList();
        countries.add("INDIA");

        player.setNameOfCountries(countries);

        String targetCountry = "PARIS";
        boolean expResult = true;
        boolean result = instance.isValidTargetCountry(targetCountry);
        assertEquals(expResult, result);

    }

    /**
     * Test of isValidTargetCountry method, of class AttackPhaseController.
     * Invalid Target Country
     */
    @org.junit.Test
    public void testIsValidTargetCountry_1() {
        System.out.println("isValidTargetCountry");

        ArrayList<String> countries = new ArrayList();
        countries.add("INDIA");
        countries.add("PARIS");

        player.setNameOfCountries(countries);

        String targetCountry = "PARIS";
        boolean expResult = false;
        boolean result = instance.isValidTargetCountry(targetCountry);
        assertEquals(expResult, result);

    }

    /**
     * Test of canAttack method, of class AttackPhaseController. Player can
     * Attack
     */
    @org.junit.Test
    public void testCanAttack_0() {
        System.out.println("canAttack");

        HashMap<String, Integer> armyInfo = new HashMap();
        armyInfo.put("INDIA", 5);

        player.setCountryArmyInfo(armyInfo);

        HashMap<String, HashMap<String, Integer>> playerCountries = new HashMap();
        playerCountries.put("player 0", armyInfo);

        gb.setPlayerCountries(playerCountries);

        boolean expResult = true;
        boolean result = instance.canAttack();
        assertEquals(expResult, result);

    }

    /**
     * Test of canAttack method, of class AttackPhaseController. Player cannot
     * Attack
     */
    @org.junit.Test
    public void testCanAttack_1() {
        System.out.println("canAttack");

        HashMap<String, Integer> armyInfo = new HashMap();
        armyInfo.put("INDIA", 1);

        player.setCountryArmyInfo(armyInfo);

        HashMap<String, HashMap<String, Integer>> playerCountries = new HashMap();
        playerCountries.put("player 0", armyInfo);

        gb.setPlayerCountries(playerCountries);

        boolean expResult = false;
        boolean result = instance.canAttack();
        assertEquals(expResult, result);

    }

}
