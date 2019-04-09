/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map.mapprocessor;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.GameMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daksh
 */
public class MapValidatorTest {

    String location;

    public MapValidatorTest() {
        File currentDirectory = new File(new File(".").getAbsolutePath());
        String projectDirectory = currentDirectory.getAbsolutePath();
        location = projectDirectory + "\\Test Maps\\";
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of verifyMap method, of class MapValidator. Asia map is tested. It
     * is valid map
     */
    @Test
    public void testVerifyMapAsia() {
        try {
            System.out.println("verifyMap : Asia Map ");
            String mapPath = location + "valid_maps\\" + "Asia.map";
            GameMap map = MapParser.parseMap(mapPath);
            boolean expResult = true;
            boolean result = MapValidator.verifyMap(map);

            assertEquals(expResult, result);
            System.out.println("Verified!!");
        } catch (InvalidMapException ex) {
            fail("Test failed!!");
        }
    }

    /**
     * Belgie Map is verified here. It is valid map
     */
    @Test
    public void testVerifyMapBelgie() {
        try {
            System.out.println("verifyMap : Belgie Map ");
            String mapPath = location + "valid_maps\\" + "Belgie.map";
            GameMap map = MapParser.parseMap(mapPath);
            boolean expResult = true;
            boolean result = MapValidator.verifyMap(map);

            assertEquals(expResult, result);
            System.out.println("Verified!!");
        } catch (InvalidMapException ex) {
            fail("Test failed!!");
        }
    }

    /**
     * Cobra map is verified here It is valid map
     */
    @Test
    public void testVerifyMapCobra() {
        try {
            System.out.println("verifyMap : Cobra Map ");
            String mapPath = location + "valid_maps\\" + "Cobra.map";
            GameMap map = MapParser.parseMap(mapPath);
            boolean expResult = true;
            boolean result = MapValidator.verifyMap(map);

            assertEquals(expResult, result);
            System.out.println("Verified!!");
        } catch (InvalidMapException ex) {
            fail("Test failed!!");
        }
    }

    /**
     * Diplomacy Map is verified here It is valid map
     */
    @Test
    public void testVerifyMapDiplomacy() {
        try {
            System.out.println("verifyMap : Diplomacy Map ");
            String mapPath = location + "valid_maps\\" + "Diplomacy.map";
            GameMap map = MapParser.parseMap(mapPath);
            boolean expResult = true;
            boolean result = MapValidator.verifyMap(map);

            assertEquals(expResult, result);
            System.out.println("Verified!!");
        } catch (InvalidMapException ex) {
            fail("Test failed!!");
        }
    }

    /**
     * Test of map which has isolated continent Diplomacy Map is verified here
     * It is valid map
     */
    @Test
    public void testVerifyMapIsolatedContinent() {
        try {
            System.out.println("verifyMap : Isolated Continent Map ");
            String mapPath = location + "invalid_maps\\" + "isolated_continent.map";
            GameMap map = MapParser.parseMap(mapPath);
            boolean expResult = false;
            boolean result = MapValidator.verifyMap(map);

            assertEquals(expResult, result);
            System.out.println("Verified!! It is invalid map");
        } catch (InvalidMapException ex) {
            fail("Test failed!! It is invalid map still the result is valid map");
        }
    }

    /**
     * Test of a map in which continent are connected but countries inside that
     * continent are not connected. World is connected but countries inside 1
     * continent are not connected. So it is invalid map
     */
    @Test
    public void testVerifyMapIsContinentConnectedSubGraph() {
        try {
            System.out.println("verifyMap : Countries inside continents form connected subgraph : No");
            String mapPath = location + "invalid_maps\\" + "continent_not_subConnectedGraph.map";
            GameMap map = MapParser.parseMap(mapPath);
            boolean expResult = false;
            boolean result = MapValidator.verifyMap(map);

            assertEquals(expResult, result);
            System.out.println("Verified!! It is invalid map ");
        } catch (InvalidMapException ex) {
            fail("Test failed!! It is invalid map still the result is valid map");
        }
    }
    
    /**
     * Verifying the above map after making it connected 
     */
    @Test
    public void testVerifyMapIsContinentConnectedSubGraph2(){
        try {
            System.out.println("verifyMap : Countries inside continents form connected subgraph : yes");
            String mapPath = location + "invalid_maps\\" + "continent_form_subConnectedGraph.map";
            GameMap map = MapParser.parseMap(mapPath);
            boolean expResult = true;
            boolean result = MapValidator.verifyMap(map);

            assertEquals(expResult, result);
            System.out.println("Verified!! It is Valid map");
        } catch (InvalidMapException ex) {
            fail("Test failed!!");
        }
    }
    
    
    @Test
    public void testInvalidMap1(){
        try {
         //   System.out.println("verifyMap : Countries inside continents form connected subgraph : yes");
            String mapPath = location + "invalid_maps\\" + "no_continent_consistency.map";
            GameMap map = MapParser.parseMap(mapPath);
            boolean expResult = false;
            boolean result = MapValidator.verifyMap(map);

            assertEquals(expResult, result);
            System.out.println("Verified!! It is Valid map");
        } catch (InvalidMapException ex) {
            fail("Test failed!!");
        }
    }
    
    @Test
    public void testInvalidMap2(){
        boolean thrown = false;
        try {
         //   System.out.println("verifyMap : Countries inside continents form connected subgraph : yes");
            String mapPath = location + "invalid_maps\\" + "no_continent_consistency-1.map";
            GameMap map = MapParser.parseMap(mapPath);
           
        } catch (InvalidMapException ex) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}

