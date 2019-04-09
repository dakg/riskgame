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
import game_engine.Game.GameExecutor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import map.mapprocessor.InvalidMapException;
import map.mapprocessor.MapParser;
import map.mapprocessor.MapValidator;
import models.GameMap;

/**
 *
 * @author daksh
 */
public class TournamentDriver {

    GameMap maps[];
    int numberOfPlayers;
    int drawNumber;
    int numberOfGames;
    Strategy playerStrategies[];

    GameDriver gameDriver[][];
    int totalGames;

    public TournamentDriver(int numberOfGames, int drawTurn, int numberOfMaps, String[] mapPaths, int[] strategy) {

        this.numberOfGames = numberOfGames;
        this.drawNumber = drawTurn;

        this.maps = getMaps(numberOfMaps, mapPaths);

        this.playerStrategies = getStrategies(strategy);

        this.numberOfPlayers = playerStrategies.length;

        this.totalGames = numberOfGames * numberOfMaps;

        GameDriver gameDriver[][] = new GameDriver[numberOfMaps][numberOfGames];
        for (int i = 0; i < numberOfMaps; i++) {
            for (int j = 0; j < numberOfGames; j++) {
                int gameMode = 2;
                gameDriver[i][j] = new GameDriver(maps[i], this.numberOfPlayers, playerStrategies, gameMode, drawTurn);
                System.out.println(i);

            }
        }
        this.gameDriver = gameDriver;
    }

    public void startTournament() {
        GameExecutor gameExecutor[][] = new GameExecutor[maps.length][numberOfGames];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < numberOfGames; j++) {
                gameExecutor[i][j] = new GameExecutor(gameDriver[i][j]);
            }
        }

//        gameDriver[0][0].startGame();
//        gameDriver[0][1].startGame();
//        gameDriver[1][0].startGame();
//        gameDriver[1][1].startGame();
//        for (int i = 0; i < maps.length; i++) {
//            for (int j = 0; j < numberOfGames; j++) {
////                    gameExecutor[i][j].run();
//                gameDriver[i][j].startGame();
//            }
//        }
//        
        Runnable r = () -> {
            for (int i = 0; i < maps.length; i++) {
                for (int j = 0; j < numberOfGames; j++) {
//                    gameExecutor[i][j].run();
                    gameDriver[i][j].startGame();
                    System.out.println("gagagagagagagaagagagagagagagagagagagagagagagagagagaggaga " + " i " + i + " j " + j + "object : " + gameDriver[i][j]);
                }
            }
        };

        Thread t = new Thread(r);
        t.start();
    }

    private GameMap[] getMaps(int numberOfMaps, String[] mapPaths) {

        GameMap maps[] = new GameMap[numberOfMaps];
        for (int i = 0; i < numberOfMaps; i++) {
            try {
                GameMap tempMap = MapParser.parseMap(mapPaths[i]);
                maps[i] = tempMap;
            } catch (InvalidMapException ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "Map Invalid : " + i + 1);
            }
        }
        return maps;
    }

    private Strategy[] getStrategies(int[] strategy) {

        try {
            ArrayList<Strategy> strategies = new ArrayList();
            if (strategy[0] == 1) {
                strategies.add(new Aggresive());
            }
            if (strategy[1] == 1) {
                strategies.add(new Benevolent());
            }
            if (strategy[2] == 1) {
                strategies.add(new Cheating());
            }
            if (strategy[3] == 1) {
                strategies.add(new Random());
            }

            Strategy s[] = new Strategy[strategies.size()];
            for (int i = 0; i < strategies.size(); i++) {
                s[i] = strategies.get(i);
            }
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args) {

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
    }

}
