/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map.maprules;

import java.io.File;
import java.util.HashMap;
import map.mapprocessor.InvalidMapException;
import map.mapprocessor.MapParser;
import models.GameMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daksh
 */
public class MapValidatorRulesTest {

    GameMap map;
    String location;

    public MapValidatorRulesTest() {
        File currentDirectory = new File(new File(".").getAbsolutePath());
        String projectDirectory = currentDirectory.getAbsolutePath();
        location = projectDirectory + "\\Test Maps\\";
    }

    @Before
    public void setUp() {
        map = new GameMap();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isWorldMapEmpty method, of class MapValidatorRules.
     */
    @Test
    public void testIsWorldMapEmpty() {
        System.out.println("isWorldMapEmpty");
        HashMap<String, String> worldMap = new HashMap<>();

        //Testing if worldMap is not a empty worldMap
        worldMap.put("INDIA", "INDIA,0,0,ASIA,ENGLAND");
        map.setWorldMap(worldMap);
        boolean expResult1 = true;
        boolean result1 = MapValidatorRules.isWorldMapEmpty(map);
        assertEquals(expResult1, result1);

        //Testing if worldMap empty
        worldMap = new HashMap<>();
        map.setWorldMap(worldMap);
        boolean expResult2 = false;
        boolean result2 = MapValidatorRules.isWorldMapEmpty(map);
        assertEquals(expResult2, result2);

    }

    /**
     * Test of isContinentValueEmpty method, of class MapValidatorRules.
     */
    @Test
    public void testIsContinentValueEmpty() {
        System.out.println("isContinentValueEmpty");

        HashMap<String, Integer> continentValue = new HashMap<>();

        //Testing if continentValue is not empty
        continentValue.put("ASIA", 2);
        map.setContinentValue(continentValue);
        boolean expResult1 = true;
        boolean result1 = MapValidatorRules.isContinentValueEmpty(map);
        assertEquals(expResult1, result1);

        //Testing if continentValue is empty
        continentValue = new HashMap();
        map.setContinentValue(continentValue);
        boolean expResult2 = false;
        boolean result2 = MapValidatorRules.isContinentValueEmpty(map);
        assertEquals(expResult2, result2);

    }

    /**
     * Test of isValidNumberOfConnectionsOfEachCountry method, of class
     * MapValidatorRules.
     */
    @Test
    public void testIsValidNumberOfConnectionsOfEachCountry() throws InvalidMapException {
        System.out.println("isValidNumberOfConnectionsOfEachCountry");

        //This map has valid number of connections
        map = MapParser.parseMap(location + "\\valid_maps\\Cobra.map");
        boolean expResult = true;
        boolean result = MapValidatorRules.isValidNumberOfConnectionsOfEachCountry(map);
        assertEquals(expResult, result);

    }

    /**
     * Test of isValidNumberOfCountries method, of class MapValidatorRules.
     */
    @Test
    public void testIsValidNumberOfCountries() {
        System.out.println("isValidNumberOfCountries");

        //Valid Number of countries
        map.setNumberOfContinents(2);
        map.setNumberOfCountries(30);
        boolean expResult = true;
        boolean result = MapValidatorRules.isValidNumberOfCountries(map);
        assertEquals(expResult, result);

        //Invalid Number of countries
        //Because numberOfContinents > numberOfCountries
        map.setNumberOfContinents(5);
        map.setNumberOfCountries(4);
        boolean expResult2 = false;
        boolean result2 = MapValidatorRules.isValidNumberOfCountries(map);
        assertEquals(expResult2, result2);

        //Invalid Number of Countries
        //Because number of countries > 256
        map.setNumberOfContinents(5);
        map.setNumberOfCountries(300);
        boolean expResult3 = false;
        boolean result3 = MapValidatorRules.isValidNumberOfCountries(map);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of isValidNumberOfContinents method, of class MapValidatorRules.
     */
    @Test
    public void testIsValidNumberOfContinents() {
        System.out.println("isValidNumberOfContinents");

        //Valid Number of Continents
        //numberOfContinents<=32
        map.setNumberOfContinents(5);
        boolean expResult = true;
        boolean result = MapValidatorRules.isValidNumberOfContinents(map);
        assertEquals(expResult, result);

        //Invalid Number of Continents
        //Because numberOfContinents > 32
        map.setNumberOfContinents(40);
        boolean expResult2 = false;
        boolean result2 = MapValidatorRules.isValidNumberOfContinents(map);
        assertEquals(expResult2, result2);

    }

    /**
     * Test of checkConnectionWithItself method, of class MapValidatorRules.
     */
    @Test
    public void testCheckConnectionWithItself() {
        System.out.println("checkConnectionWithItself");

        //It is connected with itself i.e a node is connected with itself .So it should return false
        int[][] worldAdjancencyMatrix = {
            {0, 1, 1},
            {1, 1, 0},
            {1, 0, 0}};
        boolean expResult = false;
        boolean result = MapValidatorRules.checkConnectionWithItself(worldAdjancencyMatrix);
        assertEquals(expResult, result);

        //It is not connected with itself. So it should return true
        int worldAdjancencyMatrix2[][] = {
            {0, 1, 1},
            {1, 0, 0},
            {1, 0, 0}};
        boolean expResult2 = true;
        boolean result2 = MapValidatorRules.checkConnectionWithItself(worldAdjancencyMatrix2);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of isGraphConnected method, of class MapValidatorRules.
     */
    @Test
    public void testIsGraphConnected() {
        System.out.println("isGraphConnected");

        //Adjancency Matrix is connected. So it should return true
        int[][] a = {
            {0, 1, 1},
            {1, 0, 0},
            {1, 0, 0}};
        boolean expResult = true;
        boolean result = MapValidatorRules.isGraphConnected(a);
        assertEquals(expResult, result);

        //Adjacency Matrix is not connected. So it should return false
        int[][] a2 = {
            {0, 1, 0},
            {1, 0, 0},
            {0, 0, 0}};
        boolean expResult2 = false;
        boolean result2 = MapValidatorRules.isGraphConnected(a2);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of isWorldConnected method, of class MapValidatorRules.
     */
    @Test
    public void testIsWorldConnected() {
        System.out.println("isWorldConnected");

        //Adjancency Matrix is connected. So it should return true
        int[][] a = {
            {0, 1, 1},
            {1, 0, 0},
            {1, 0, 0}};
        map.setWorldAdjacencyMatrix(a);
        boolean expResult = true;
        boolean result = MapValidatorRules.isWorldConnected(map);
        assertEquals(expResult, result);

        //Adjacency Matrix is not connected. So it should return false
        int[][] a2 = {
            {0, 1, 0},
            {1, 0, 0},
            {0, 0, 0}};
        map.setWorldAdjacencyMatrix(a2);
        boolean expResult2 = false;
        boolean result2 = MapValidatorRules.isWorldConnected(map);
        assertEquals(expResult2, result2);

    }

    /**
     * Test of isContinentsInterConnected method, of class MapValidatorRules.
     */
    @Test
    public void testIsContinentsInterConnected() throws InvalidMapException {
        System.out.println("isContinentsInterConnected");
        map = MapParser.parseMap(location + "\\valid_maps\\Belgie.map");
        boolean expResult = true;
        boolean result = MapValidatorRules.isContinentsInterConnected(map);
        assertEquals(expResult, result);

    }

    /**
     * Test of isContinentsInnerConnected method, of class MapValidatorRules.
     */
    @Test
    public void testIsContinentsInnerConnected() throws InvalidMapException {
        System.out.println("isContinentsInnerConnected");
        map = MapParser.parseMap(location + "\\valid_maps\\Belgie.map");
        boolean expResult = true;
        boolean result = MapValidatorRules.isContinentsInnerConnected(map);
        assertEquals(expResult, result);

    }

    /**
     * Test of isValidContinentIntigrity method, of class MapValidatorRules.
     */
    @Test
    public void testIsValidContinentIntegrity(){
        System.out.println("isAnyContinentEmpty");

        //There is one continent empty in this map
        try{
        map = MapParser.parseMap(location + "\\invalid_maps\\no_continent_consistency.map");
        boolean expResult = false;
        boolean result = MapValidatorRules.isValidContinentIntegrity(map);
        assertEquals(expResult, result);
        }
        catch(InvalidMapException ine){
            System.out.println("Invalid Map!!");
        }

        //There are no continent empty in this continent
        try{
        map = MapParser.parseMap(location + "\\valid_maps\\Asia.map");
        boolean expResult2 = true;
        boolean result2 = MapValidatorRules.isValidContinentIntegrity(map);
        assertEquals(expResult2, result2);
        }
        catch(InvalidMapException ine){
            System.out.println("Invalid Map!!");
        }

    }

}
