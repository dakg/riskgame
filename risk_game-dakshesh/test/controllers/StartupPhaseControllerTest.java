/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import game_engine.GameDriver;
import game_engine.GameSetup;
import java.io.File;
import java.util.HashMap;
import java.util.List;
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
 * All Tests runs on nancy map with two players.
 *
 * @author daksh
 */
public class StartupPhaseControllerTest {

    Player player[];
    GameBoard gameBoard;
    StartupPhaseController spc;
    GameMap map;

    String location;

    public StartupPhaseControllerTest() {
        spc = new StartupPhaseController();

        File currentDirectory = new File(new File(".").getAbsolutePath());
        String projectDirectory = currentDirectory.getAbsolutePath();
        location = projectDirectory + "\\Test Maps\\";
    }

    @Before
    public void setUp() throws InvalidMapException {
        player = new Player[2];
        player[0] = new Player();
        player[1] = new Player();

        map = MapParser.parseMap(location + "valid_maps\\nancy.map");
        gameBoard = new GameBoard(map, 2);

        GameSetup.initializePlayers(gameBoard, player, map);
        GameSetup.initializeGameBoard(gameBoard, player, map);

        player[0].setGameBoard(gameBoard);
        player[1].setGameBoard(gameBoard);

        spc.setGameBoard(gameBoard);
        spc.setPlayer(player);

    }

    /**
     * Test of putArmy method, of class StartupPhaseController.
     */
    @Test
    public void testPutArmy() {
        boolean thrown = false;
        try {
            System.out.println("putArmy");
            int currentPlayer = 0;
            String countryName = "INDIA";
            int expResult = 1;
            int result = spc.putArmy(currentPlayer, countryName);
            assertEquals(expResult, result);

            String expCountryOwner = gameBoard.getCountryDetails(countryName).getPlayerName();

            assertEquals(expCountryOwner, player[0].getPlayerName());

        } catch (Exception e) {
            thrown = false;
            fail(e.toString());
        }

    }

    /**
     * Test of isAllCountriesAssigned method, of class StartupPhaseController.
     * All countries are assigned.
     */
    @Test
    public void testIsAllCountriesAssigned_1() {
        System.out.println("isAllCountriesAssigned");

        HashMap<String, HashMap<String, Integer>> playerCountryArmy = new HashMap();

        HashMap<String, Integer> countryArmyInfo1 = new HashMap<>();
        countryArmyInfo1.put("INDIA", 3);
        countryArmyInfo1.put("ENGLAND", 2);

        HashMap<String, Integer> countryArmyInfo2 = new HashMap<>();
        countryArmyInfo2.put("PARIS", 3);

        playerCountryArmy.put(player[0].getPlayerName(), countryArmyInfo1);
        playerCountryArmy.put(player[1].getPlayerName(), countryArmyInfo2);

        gameBoard.setPlayerCountries(playerCountryArmy);

        boolean expResult = true;
        boolean result = spc.isAllCountriesAssigned(gameBoard, player);
        assertEquals(expResult, result);

    }
    
    /**
     * Test of isAllCountriesAssigned method, of class StartupPhaseController.
     * All Countries are not assigned. So it returns false
     */
    @Test
    public void testIsAllCountriesAssigned_2() {
        System.out.println("isAllCountriesAssigned");

        HashMap<String, HashMap<String, Integer>> playerCountryArmy = new HashMap();

        HashMap<String, Integer> countryArmyInfo1 = new HashMap<>();
        countryArmyInfo1.put("INDIA", 3);
        countryArmyInfo1.put("ENGLAND", 2);

        HashMap<String, Integer> countryArmyInfo2 = new HashMap<>();

        playerCountryArmy.put(player[0].getPlayerName(), countryArmyInfo1);
        playerCountryArmy.put(player[1].getPlayerName(), countryArmyInfo2);

        gameBoard.setPlayerCountries(playerCountryArmy);

        boolean expResult = false;
        boolean result = spc.isAllCountriesAssigned(gameBoard, player);
        assertEquals(expResult, result);

    }
}
