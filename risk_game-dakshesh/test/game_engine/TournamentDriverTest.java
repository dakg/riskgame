/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_engine;

import Strategies.Aggresive;
import Strategies.Benevolent;
import Strategies.Cheating;
import Strategies.Random;
import Strategies.Strategy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daksh
 */
public class TournamentDriverTest {

    
    
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    public TournamentDriverTest(){
        
    }
    /**
     * Test of startTournament method, of class TournamentDriver.
     */
    @Test
    public void testStartTournament() throws Exception {
        System.out.println("startTournament");
        int numberOfGames = 2;
        int numberOfMaps = 1;
        int drawTurn = 30;
        String mapPaths[] = new String[2];
        mapPaths[0] = "C:\\Users\\daksh\\Desktop\\maps\\Diplomacy.map";
        mapPaths[1] = "C:\\Users\\daksh\\Desktop\\maps\\Belgie.map";

        Strategy s[] = new Strategy[4];
        s[0] = new Aggresive();
        s[1] = new Benevolent();
        s[2] = new Cheating();
        s[3] = new Random();

        int strategy[] = {1, 1, 1, 1};

        TournamentDriver td = new TournamentDriver(numberOfGames, drawTurn, mapPaths.length, mapPaths, strategy);
        td.startTournament();
        Thread.sleep(2000);
        
        int actualResult =0;
        for (int i = 0; i < numberOfMaps; i++) {
            for (int j = 0; j < numberOfGames; j++) {
               String result  = td.gameDriver[i][j].getGameResultStrategyType();
               if(result == null){
                   actualResult++;
               }
            }
        }
        int expResult = 0;
        assertEquals(actualResult,expResult);
    }

}
