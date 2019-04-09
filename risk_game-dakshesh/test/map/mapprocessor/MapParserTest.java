/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map.mapprocessor;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import models.GameMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daksh
 */
public class MapParserTest {

    String location = "";

    public MapParserTest() {
        File currentDirectory = new File(new File(".").getAbsolutePath());
        String projectDirectory = currentDirectory.getAbsolutePath();
        location = projectDirectory + "\\Test Maps\\map_parsing\\";
    }

    /**
     * Test of parseMap method, of class MapParser. It tests the proper parsing
     * of map. ie. generation of worldMap and continentValue Information about
     * Map : Map is in proper format Sample file [Continents]
     *
     * europe=2 asia=1
     *
     * [Territories]
     *
     * england,0,0,europe,paris,india paris,0,0,europe,england,india
     * india,0,0,asia,england,paris
     *
     * @throws map.mapprocessor.InvalidMapException
     */
    @Test
    public void testParseMap() throws InvalidMapException {
        System.out.println("MapParser : Proper Format");
        //   String filePath = "C:\\Users\\daksh\\Documents\\NetBeansProjects\\risk_game_28my\\risk_game-dakshesh\\Test Maps\\map_parsing\\nancy.map";
        String filePath = location + "nancy.map";
        HashMap<String, String> expectedWorldMap = new HashMap();
        expectedWorldMap.put("ENGLAND", "ENGLAND,0,0,EUROPE,PARIS,INDIA");
        expectedWorldMap.put("PARIS", "PARIS,0,0,EUROPE,ENGLAND,INDIA");
        expectedWorldMap.put("INDIA", "INDIA,0,0,ASIA,ENGLAND,PARIS");

        HashMap<String, Integer> expectedContinentValue = new HashMap();
        expectedContinentValue.put("EUROPE", 2);
        expectedContinentValue.put("ASIA", 1);

        GameMap result = MapParser.parseMap(filePath);
        HashMap<String, String> actualWorldMap = result.getWorldMap();
        HashMap<String, Integer> actualContinentValue = result.getContinentValue();

        assertEquals(expectedWorldMap, actualWorldMap);
        assertEquals(expectedContinentValue, actualContinentValue);
        System.out.println("Test of MapParser - if the map is in proper format : PASSED!!");
    }

    /**
     * Map file contains lines which are indented and there are many blank
     * lines. nancy map is modified with spaces and indentations
     *
     * @throws Exception
     */
    @Test
    public void testMapParserProperFormat1() throws Exception {
        System.out.println("MapParser  : Not proper format : Method 1");
        //    String filePath = "C:\\Users\\daksh\\Documents\\NetBeansProjects\\risk_game_28my\\risk_game-dakshesh\\Test Maps\\map_parsing\\nancy-1.map";
        String filePath = location + "nancy-1.map";

        HashMap<String, String> expectedWorldMap = new HashMap();
        expectedWorldMap.put("ENGLAND", "ENGLAND,0,0,EUROPE,PARIS,INDIA");
        expectedWorldMap.put("PARIS", "PARIS,0,0,EUROPE,ENGLAND,INDIA");
        expectedWorldMap.put("INDIA", "INDIA,0,0,ASIA,ENGLAND,PARIS");

        HashMap<String, Integer> expectedContinentValue = new HashMap();
        expectedContinentValue.put("EUROPE", 2);
        expectedContinentValue.put("ASIA", 1);

        GameMap result = MapParser.parseMap(filePath);
        HashMap<String, String> actualWorldMap = result.getWorldMap();
        HashMap<String, Integer> actualContinentValue = result.getContinentValue();

        assertEquals(expectedWorldMap, actualWorldMap);
        assertEquals(expectedContinentValue, actualContinentValue);

        System.out.println("Test of MapParser - if lines are indented with spaces and blank lines : PASSED!! ");
    }

    /**
     * Test for map if it is contains something above [Continent] tag
     *
     * @throws Exception
     */
    @Test
    public void testMapParserProperFormat2() throws Exception {
        System.out.println("MapParser  : Not proper format : Method 2");
        //    String filePath = "C:\\Users\\daksh\\Documents\\NetBeansProjects\\risk_game_28my\\risk_game-dakshesh\\Test Maps\\map_parsing\\nancy-3.map";
        String filePath = location + "nancy-3.map";

        HashMap<String, String> expectedWorldMap = new HashMap();
        expectedWorldMap.put("ENGLAND", "ENGLAND,0,0,EUROPE,PARIS,INDIA");
        expectedWorldMap.put("PARIS", "PARIS,0,0,EUROPE,ENGLAND,INDIA");
        expectedWorldMap.put("INDIA", "INDIA,0,0,ASIA,ENGLAND,PARIS");

        HashMap<String, Integer> expectedContinentValue = new HashMap();
        expectedContinentValue.put("EUROPE", 2);
        expectedContinentValue.put("ASIA", 1);

        GameMap result = MapParser.parseMap(filePath);
        HashMap<String, String> actualWorldMap = result.getWorldMap();
        HashMap<String, Integer> actualContinentValue = result.getContinentValue();

        assertEquals(expectedWorldMap, actualWorldMap);
        assertEquals(expectedContinentValue, actualContinentValue);

        System.out.println("Test of MapParser - if lines are indented with spaces and blank lines : PASSED!! ");
    }

    /**
     * Test for Map. If map contains invalid characters or missing necessary
     * character such as "=" in map file in continent value lines Information :
     * There is no "=" sign in continent value in the nancy-2 map
     *
     * @throws map.mapprocessor.InvalidMapException
     */
    @Test(expected = InvalidMapException.class)
    public void testInvalidMap1() throws InvalidMapException {
        System.out.println("MapParser : Invalid Map that is compulsory charater left or invalid character inserted");
        //    String filePath = "C:\\Users\\daksh\\Documents\\NetBeansProjects\\risk_game_28my\\risk_game-dakshesh\\Test Maps\\map_parsing\\nancy-2.map";
        String filePath = location + "nancy-2.map";

        GameMap result = MapParser.parseMap(filePath);

    }

    /**
     * Test to check that = sign between continent name and continent value is
     * valid that they are in one line
     */
    @Test
    public void testInvalidMap2() {
        boolean thrown1 = false;
        boolean thrown2 = false;

        System.out.println("MapParser : Invalid Map that is compulsory charater left or invalid character inserted");
        //  String filePath1 = "C:\\Users\\daksh\\Documents\\NetBeansProjects\\risk_game_28my\\risk_game-dakshesh\\Test Maps\\map_parsing\\nancy-4.map";
        //  String filePath2 = "C:\\Users\\daksh\\Documents\\NetBeansProjects\\risk_game_28my\\risk_game-dakshesh\\Test Maps\\map_parsing\\nancy-5.map";
        String filePath1 = location + "nancy-4.map";
        String filePath2 = location + "nancy-5.map";

        try {
            GameMap result = MapParser.parseMap(filePath1);
        } catch (InvalidMapException ine) {
            thrown1 = true;
        }
        try {
            GameMap result = MapParser.parseMap(filePath2);
        } catch (InvalidMapException ine) {
            thrown2 = true;
        }

        boolean result = thrown1 && thrown2;

        assertTrue(result);
        System.out.println("Invalid Map 2 : Passed");
    }

    /**
     * Test of getContinentValue method, of class MapParser.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetContinentValue() throws Exception {
        System.out.println("getContinentValue");

        //    String filePath = "C:\\Users\\daksh\\Documents\\NetBeansProjects\\risk_game_28my\\risk_game-dakshesh\\Test Maps\\map_parsing\\nancy.map";
        String filePath = location + "nancy.map";

        HashMap<String, Integer> expectedContinentValue = new HashMap();
        expectedContinentValue.put("EUROPE", 2);
        expectedContinentValue.put("ASIA", 1);

        HashMap<String, Integer> actualContinentValue = MapParser.getContinentValue(filePath);
        assertEquals(expectedContinentValue, actualContinentValue);
        System.out.println("Passed");
    }

    /**
     * Test of getWorldMap method, of class MapParser.
     */
    @Test
    public void testGetWorldMap() throws InvalidMapException {
        System.out.println("getWorldMap");
        //  String filePath = "C:\\Users\\daksh\\Documents\\NetBeansProjects\\risk_game_28my\\risk_game-dakshesh\\Test Maps\\map_parsing\\nancy.map";
        String filePath = location + "nancy.map";

        HashMap<String, String> expectedWorldMap = new HashMap();
        expectedWorldMap.put("ENGLAND", "ENGLAND,0,0,EUROPE,PARIS,INDIA");
        expectedWorldMap.put("PARIS", "PARIS,0,0,EUROPE,ENGLAND,INDIA");
        expectedWorldMap.put("INDIA", "INDIA,0,0,ASIA,ENGLAND,PARIS");

        HashMap<String, String> actualWorldMap = MapParser.getWorldMap(filePath);
        assertEquals(expectedWorldMap, actualWorldMap);

    }

}
