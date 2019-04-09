/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_engine.Game;

import java.io.Serializable;
import models.GameBoard;
import models.Player;

/**
 *
 * @author daksh
 */
public class GameObjectsWrapper implements Serializable {

    public GameBoard gameBoard;
    public Player player[];
    int currentTurn;
    int gameMode;
    int drawTurn;
    int turnCounter;
    String gameResult;

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Player[] getPlayer() {
        return player;
    }

    public void setPlayer(Player[] player) {
        this.player = player;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    public int getGameMode() {
        return gameMode;
    }

    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }

    public int getDrawTurn() {
        return drawTurn;
    }

    public void setDrawTurn(int drawTurn) {
        this.drawTurn = drawTurn;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    public GameObjectsWrapper(GameBoard gameBoard, Player player[], int currentTurn) {
        this.gameBoard = gameBoard;
        this.player = player;
        this.currentTurn = currentTurn;
    }

    public GameObjectsWrapper(GameBoard gameBoard, Player[] player, int currentTurn, int gameMode, int drawTurn, int turnCounter, String gameResult) {
        this.gameBoard = gameBoard;
        this.player = player;
        this.currentTurn = currentTurn;
        this.gameMode = gameMode;
        this.drawTurn = drawTurn;
        this.turnCounter = turnCounter;
        this.gameResult = gameResult;
    }
}
