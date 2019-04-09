/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_engine.Game;

import game_engine.GameDriver;

/**
 *
 * @author daksh
 */
public class GameExecutor implements Runnable {

    public GameDriver gameDriver;

    public GameExecutor(GameDriver gameDriver) {
        this.gameDriver = gameDriver;
    }

    @Override
    public void run() {
        System.out.println("-----------------------------------------------------------------------------------" + gameDriver);
        gameDriver.startGame();
    }
}
