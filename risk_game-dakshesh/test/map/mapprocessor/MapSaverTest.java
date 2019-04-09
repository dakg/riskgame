/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map.mapprocessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import models.GameMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daksh
 */
public class MapSaverTest {

    HashMap<String, String> worldMap = new HashMap();
    HashMap<String, Integer> continentValue = new HashMap();

    @Before
    public void setUp() {
        worldMap.put("ENGLAND", "ENGLAND,0,0,EUROPE,PARIS,INDIA");
        worldMap.put("PARIS", "PARIS,0,0,EUROPE,ENGLAND,INDIA");
        worldMap.put("INDIA", "INDIA,0,0,ASIA,ENGLAND,PARIS");

        continentValue.put("EUROPE", 2);
        continentValue.put("ASIA", 1);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of writeMapToFileStorage method, of class MapSaver. Procedure: I had
     * generated two HashMaps in setup Then use them to to create a file Then
     * parse the file back into HashMap And then compare both types of HashMaps
     */
    @Test
    public void testWriteMapToFileStorage() throws FileNotFoundException, IOException, InvalidMapException {
        System.out.println("writeMapToFileStorage");

        String name = "test_save_map";

        File currentDirectory = new File(new File(".").getAbsolutePath());
        String projectDirectory = currentDirectory.getAbsolutePath();
       // System.out.println(projectDirectory);
        String location = projectDirectory + "\\Test Maps\\test_generated_maps\\" + name + ".map";
        System.out.println(location);
        boolean saveResult = MapSaver.writeMapToFileStorage(worldMap, continentValue, location);

        HashMap<String, String> actualWorldMap;
        HashMap<String, Integer> actualContinentValue;

        if (saveResult == true) {
            GameMap map = MapParser.parseMap(location);
            actualWorldMap = map.getWorldMap();
            actualContinentValue = map.getContinentValue();

            assertEquals(worldMap, actualWorldMap);
            assertEquals(continentValue, actualContinentValue);
            System.out.println("Passed!!");
        } else {
            fail("Save was not done");
        }
    }

    /** 
     * There's no garuantee that this test case can pass.Because there is no order 
     * while iterating through keySet()
     * Test of convertData method, of class MapSaver.
     */
    //@Test
    public void testConvertData() {
        System.out.println("Test for String generated from worldMap and continentValue");

        String expResult = "[CONTINENTS]\r\n"
                + "\r\n"
                + "EUROPE=2\r\n"
                + "ASIA=1\r\n"
                + "\r\n"
                + "[TERRITORIES]\r\n"
                + "\r\n"
                + "ENGLAND,0,0,EUROPE,PARIS,INDIA\r\n"
                + "PARIS,0,0,EUROPE,ENGLAND,INDIA\r\n"
                + "INDIA,0,0,ASIA,ENGLAND,PARIS\r\n"
                +"\r\n";

        String result = MapSaver.convertData(continentValue, worldMap);
   
        assertEquals(expResult, result);

        System.out.println("Passed!!");

    }

}


