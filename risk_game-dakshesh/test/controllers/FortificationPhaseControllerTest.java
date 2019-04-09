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

/**
 * All tests are performed on nancy.map . It is assumed that 2 players are
 * playing
 *
 * @author daksh
 */
public class FortificationPhaseControllerTest {

    Player player;
    GameBoard gameBoard;
    FortificationPhaseController instance;

    String location;

    public FortificationPhaseControllerTest() {
        instance = new FortificationPhaseController();

        File currentDirectory = new File(new File(".").getAbsolutePath());
        String projectDirectory = currentDirectory.getAbsolutePath();
        location = projectDirectory + "\\Test Maps\\";
    }

    @Before
    public void setUp() throws InvalidMapException {
        player = new Player();
        gameBoard = new GameBoard();
        GameMap map = MapParser.parseMap(location + "valid_maps\\nancy.map");
        gameBoard.setMap(map);
        player.setGameBoard(gameBoard);
        instance.setPlayer(player);
        instance.setGameBoard(gameBoard);
    }

    /**
     * Test of isValidSourceCountry method, of class
     * FortificationPhaseController. This test satisfies condition for
     * validSourceCountry. Because player owns it the country has more than 1
     * army
     */
    @Test
    public void testIsValidSourceCountry_1() {
        System.out.println("isValidSourceCountry");

        HashMap<String, Integer> countryArmyInfo = new HashMap<String, Integer>();
        countryArmyInfo.put("INDIA", 3);
        countryArmyInfo.put("ENGLAND", 4);
        player.setCountryArmyInfo(countryArmyInfo);

        ArrayList<String> nameOfCountries = new ArrayList<String>();
        nameOfCountries.add("INDIA");
        nameOfCountries.add("ENGLAND");
        player.setNameOfCountries(nameOfCountries);

        String sourceCountry = "INDIA";
        boolean expResult = true;
        boolean result = instance.isValidSourceCountry(sourceCountry);
        assertEquals(expResult, result);

    }

    /**
     * Test of isValidSourceCountry method, of class
     * FortificationPhaseController. This test does not satisfies condition for
     * validSourceCountry. Because player has 1 army in sourceCountry.
     */
    @Test
    public void testIsValidSourceCountry_2() {
        System.out.println("isValidSourceCountry");

        HashMap<String, Integer> countryArmyInfo = new HashMap<String, Integer>();
        countryArmyInfo.put("INDIA", 1);
        countryArmyInfo.put("ENGLAND", 4);
        player.setCountryArmyInfo(countryArmyInfo);

        ArrayList<String> nameOfCountries = new ArrayList<String>();
        nameOfCountries.add("INDIA");
        nameOfCountries.add("ENGLAND");
        player.setNameOfCountries(nameOfCountries);

        String sourceCountry = "INDIA";
        boolean expResult = false;
        boolean result = instance.isValidSourceCountry(sourceCountry);
        assertEquals(expResult, result);

    }

    /**
     * Test of isValidSourceCountry method, of class
     * FortificationPhaseController. This test does not satisfies condition for
     * validSourceCountry. Because player does not own it.
     */
    @Test
    public void testIsValidSourceCountry_3() {
        System.out.println("isValidSourceCountry");

        HashMap<String, Integer> countryArmyInfo = new HashMap<String, Integer>();
        countryArmyInfo.put("INDIA", 1);
        countryArmyInfo.put("ENGLAND", 4);
        player.setCountryArmyInfo(countryArmyInfo);

        ArrayList<String> nameOfCountries = new ArrayList<String>();
        nameOfCountries.add("INDIA");
        nameOfCountries.add("ENGLAND");
        player.setNameOfCountries(nameOfCountries);

        String sourceCountry = "PARIS";
        boolean expResult = false;
        boolean result = instance.isValidSourceCountry(sourceCountry);
        assertEquals(expResult, result);

    }

    /**
     * Test of isValidDestinationCountry method, of class
     * FortificationPhaseController. This test satisfies validDestinationCountry
     * conditions
     */
    @Test
    public void testIsValidDestinationCountry_1() {
        System.out.println("isValidDestinationCountry");

        HashMap<String, Integer> countryArmyInfo = new HashMap<String, Integer>();
        countryArmyInfo.put("INDIA", 3);
        countryArmyInfo.put("ENGLAND", 4);
        player.setCountryArmyInfo(countryArmyInfo);

        ArrayList<String> nameOfCountries = new ArrayList<String>();
        nameOfCountries.add("INDIA");
        nameOfCountries.add("ENGLAND");
        player.setNameOfCountries(nameOfCountries);

        String sourceCountry = "INDIA";
        String destinationCountry = "ENGLAND";
        instance.setSourceCountry(sourceCountry);
        instance.setDestinationCountry(destinationCountry);
        boolean expResult = true;
        boolean result = instance.isValidDestinationCountry(destinationCountry);
        assertEquals(expResult, result);

    }

    /**
     * Test of isValidDestinationCountry method, of class
     * FortificationPhaseController. This test does not satisfies
     * validDestinationCountry conditions. Because sourceCountry and
     * destinationCountry are same
     */
    @Test
    public void testIsValidDestinationCountry_2() {
        System.out.println("isValidDestinationCountry");

        HashMap<String, Integer> countryArmyInfo = new HashMap<String, Integer>();
        countryArmyInfo.put("INDIA", 3);
        countryArmyInfo.put("ENGLAND", 4);
        player.setCountryArmyInfo(countryArmyInfo);

        ArrayList<String> nameOfCountries = new ArrayList<String>();
        nameOfCountries.add("INDIA");
        nameOfCountries.add("ENGLAND");
        player.setNameOfCountries(nameOfCountries);

        String sourceCountry = "INDIA";
        String destinationCountry = "INDIA";
        instance.setSourceCountry(sourceCountry);
        instance.setDestinationCountry(destinationCountry);
        boolean expResult = false;
        boolean result = instance.isValidDestinationCountry(destinationCountry);
        assertEquals(expResult, result);

    }

    /**
     * Test of isValidDestinationCountry method, of class
     * FortificationPhaseController. This test does not satisfies
     * validDestinationCountry conditions. Because player does not own
     * destination country
     */
    @Test
    public void testIsValidDestinationCountry_3() {
        System.out.println("isValidDestinationCountry");

        HashMap<String, Integer> countryArmyInfo = new HashMap<String, Integer>();
        countryArmyInfo.put("INDIA", 3);
        countryArmyInfo.put("ENGLAND", 4);
        player.setCountryArmyInfo(countryArmyInfo);

        ArrayList<String> nameOfCountries = new ArrayList<String>();
        nameOfCountries.add("INDIA");
        nameOfCountries.add("ENGLAND");
        player.setNameOfCountries(nameOfCountries);

        String sourceCountry = "INDIA";
        String destinationCountry = "PARIS";
        instance.setSourceCountry(sourceCountry);
        instance.setDestinationCountry(destinationCountry);
        boolean expResult = false;
        boolean result = instance.isValidDestinationCountry(destinationCountry);
        assertEquals(expResult, result);

    }

    /**
     * Test of isValidArmyNumber method, of class FortificationPhaseController.
     * Player has England with 4 armies.So valid army number can be between 1
     * and 3
     */
    @Test
    public void testIsValidArmyNumber() {
        System.out.println("isValidArmyNumber");

        HashMap<String, Integer> countryArmyInfo = new HashMap<String, Integer>();
        countryArmyInfo.put("INDIA", 1);
        countryArmyInfo.put("ENGLAND", 4);
        player.setCountryArmyInfo(countryArmyInfo);

        HashMap<String, HashMap<String, Integer>> playerCountryArmyInfo = new HashMap();
        playerCountryArmyInfo.put("player 0", countryArmyInfo);
        gameBoard.setPlayerCountries(playerCountryArmyInfo);
        //Testing upper bound
        instance.setSourceCountry("ENGLAND");
        int armyNumber = 3;
        boolean expResult = true;
        boolean result = instance.isValidArmyNumber(armyNumber);
        assertEquals(expResult, result);

        //Testing lower bound
        instance.setSourceCountry("ENGLAND");
        int armyNumber2 = 1;
        boolean expResult2 = true;
        boolean result2 = instance.isValidArmyNumber(armyNumber2);
        assertEquals(expResult2, result2);

        //Testing other values
        instance.setSourceCountry("ENGLAND");
        int armyNumber3 = 0;
        boolean expResult3 = false;
        boolean result3 = instance.isValidArmyNumber(armyNumber3);
        assertEquals(expResult3, result3);

        //Testing other values
        instance.setSourceCountry("ENGLAND");
        int armyNumber4 = 5;
        boolean expResult4 = false;
        boolean result4 = instance.isValidArmyNumber(armyNumber4);
        assertEquals(expResult4, result4);

        //Testing other values
        instance.setSourceCountry("ENGLAND");
        int armyNumber5 = -5;
        boolean expResult5 = false;
        boolean result5 = instance.isValidArmyNumber(armyNumber5);
        assertEquals(expResult5, result5);

    }

    /**
     * Test of validSignal method, of class FortificationPhaseController.
     */
    @Test
    public void testValidSignal() {
        System.out.println("validSignal");
        int signal;

        signal = 1;
        boolean expResult = true;
        boolean result = instance.validSignal(signal);
        assertEquals(expResult, result);

        signal = 2;
        boolean expResult2 = true;
        boolean result2 = instance.validSignal(signal);
        assertEquals(expResult2, result2);

        signal = 3;
        boolean expResult3 = false;
        boolean result3 = instance.validSignal(signal);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of canFortify method, of class FortificationPhaseController. This
     * test satisfies the condition to fortify. Because India has 2 armies
     */
    @Test
    public void testCanFortify_1() {
        System.out.println("canFortify");

        HashMap<String, Integer> countryArmyInfo = new HashMap<String, Integer>();
        countryArmyInfo.put("INDIA", 2);
        countryArmyInfo.put("ENGLAND", 1);
        player.setCountryArmyInfo(countryArmyInfo);

        boolean expResult = true;
        boolean result = instance.canFortify();
        assertEquals(expResult, result);

    }

    /**
     * Test of canFortify method, of class FortificationPhaseController. This
     * test does not satisfies the condition to fortify. Because both countries
     * have just 1 army
     */
    @Test
    public void testCanFortify_2() {
        System.out.println("canFortify");

        HashMap<String, Integer> countryArmyInfo = new HashMap<String, Integer>();
        countryArmyInfo.put("INDIA", 1);
        countryArmyInfo.put("ENGLAND", 1);
        player.setCountryArmyInfo(countryArmyInfo);

        boolean expResult = false;
        boolean result = instance.canFortify();
        assertEquals(expResult, result);
    }

    /**
     * Test of canFortify method, of class FortificationPhaseController. This
     * test does not satisfies the condition to fortify. Because player has just
     * 1 country
     */
    @Test
    public void testCanFortify_3() {
        System.out.println("canFortify");

        HashMap<String, Integer> countryArmyInfo = new HashMap<String, Integer>();
        countryArmyInfo.put("INDIA", 4);
        player.setCountryArmyInfo(countryArmyInfo);

        boolean expResult = false;
        boolean result = instance.canFortify();
        assertEquals(expResult, result);
    }

    /**
     * Test of canFortify method, of class FortificationPhaseController. This
     * test does not satisfies the condition to fortify. Because condition say
     * that game is over
     */
    @Test
    public void testCanFortify_4() {
        System.out.println("canFortify");
        HashMap<Player, String> activePlayer = new HashMap();
        activePlayer.put(player, "ON");
        activePlayer.put(new Player(), "OFF");
        gameBoard.setPlayerStatus(activePlayer);
        //Above data satisfies the condition for game to be over
        //Hence game is over So player cannot fortify

        HashMap<String, Integer> countryArmyInfo = new HashMap<String, Integer>();
        countryArmyInfo.put("INDIA", 1);
        countryArmyInfo.put("ENGLAND", 1);
        countryArmyInfo.put("PARIS", 2);
        player.setCountryArmyInfo(countryArmyInfo);

        boolean expResult = false;
        boolean result = instance.canFortify();
        assertEquals(expResult, result);
    }

}
