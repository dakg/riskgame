/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author daksh
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({controllers.ReinforcementPhaseControllerTest.class, controllers.FortificationPhaseControllerTest.class, controllers.AttackPhaseControllerTest.class, controllers.StartupPhaseControllerTest.class})
public class ControllersTestSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
