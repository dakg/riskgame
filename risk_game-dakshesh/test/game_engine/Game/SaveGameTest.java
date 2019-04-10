/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_engine.Game;

import Strategies.Human;
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
public class SaveGameTest {

    /**
     * {@link game_engine.Game.GameObjectsWrapper}
     */
    GameObjectsWrapper gow;

    public SaveGameTest(){
        
    }
    @Before
    public void setUp() {
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
     * Test of saveGame method, of class SaveGame.
     */
    @Test
    public void testSaveGame() throws Exception {
        System.out.println("saveGame");
        String fileName = "Test_save1";
        SaveGame instance = new SaveGame(gow);
        int result = instance.saveGame(fileName);
        int expResult = 1;

        assertEquals(result, expResult);
    }

}
