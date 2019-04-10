/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_engine.Game;

import Strategies.Human;
import java.io.File;
import models.GameBoard;
import models.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daksh
 */
public class LoadGameTest {

    /**
     * {@link game_engine.Game.GameObjectsWrapper}
     */
    GameObjectsWrapper gow;
    /**
     * Location of the file
     */
    String location;

    public LoadGameTest() {
       
    }

    
    @Before
    public void setUp() {
        File currentDirectory = new File(new File(".").getAbsolutePath());
        String projectDirectory = currentDirectory.getAbsolutePath();
        location = projectDirectory + "//Saved Game//";

        GameBoard gameBoard = new GameBoard();
        Player[] player = new Player[4];
        for (int i = 0; i < player.length; i++) {
            player[i] = new Player(new Human());
        }
        int currentTurn = 6;
        int gameMode = 0;
        int drawTurn = 30;
        int turnCounter = 5;
        String gameResult = null;

        gow = new GameObjectsWrapper(gameBoard, player, currentTurn, gameMode, drawTurn, turnCounter, gameResult);

    }

    /**
     * Test of loadGame method, of class LoadGame.
     */
    @Test
    public void testLoadGame() throws Exception {
        System.out.println("loadGame");
        LoadGame instance = new LoadGame(location + "Test_save1.game");
        
        GameObjectsWrapper expResult = gow;
        GameObjectsWrapper result = instance.loadGame();
        
        assertEquals(expResult.currentTurn,result.currentTurn);
        assertEquals(expResult.drawTurn,result.drawTurn);
        assertEquals(expResult.gameMode,result.gameMode);
        assertEquals(expResult.gameResult,result.gameResult);
        assertEquals(expResult.turnCounter,result.turnCounter);
        
        
    }

}
