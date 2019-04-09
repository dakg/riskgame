/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author daksh
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({map.mapprocessor.MapValidatorTest.class, map.mapprocessor.MapSaverTest.class, map.mapprocessor.MapParserTest.class, map.maprules.MapValidatorRulesTest.class})
public class MapTestSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
