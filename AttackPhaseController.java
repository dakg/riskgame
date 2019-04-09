/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import models.GameBoard;
import models.Player;
import view.AttackPhaseView;

/**
 *
 * @author daksh
 */
public class AttackPhaseController {

    GameBoard gameBoard;
    Player player;
    AttackPhaseView apv;

    public AttackPhaseController() {
        this.gameBoard = gameBoard;
        this.player = player;
    }

    public void startAttack(GameBoard gameBoard, Player player) {
        this.gameBoard = gameBoard;
        this.player = player;

        apv = new AttackPhaseView();
        boolean loop = true;
        while (canAttack(gameBoard, player) && loop) {
            System.out.println("Choose one Option : ");
            System.out.println("1) Attack : ");
            System.out.println("2) Exit : ");
            int choice = apv.getAttackChoice();
            switch (choice) {
                case 1: {
                    doAttack();
                    break;
                }
                case 2: {
                    System.out.println("Attack Phase Exited!!!");
                    loop = false;
                }
            }
        }
    }

    public void doAttack() {
        boolean loop = true;
        System.out.println(player.getCountryArmyInfo());
        String sourceCountry;
        String targetCountry;
        while (true) {
            sourceCountry = apv.getSourceCountry();
            if (isValidSourceCountry(sourceCountry)) {
                break;
            }
        }

        while (true) {
            targetCountry = apv.getTargetCountry(sourceCountry);
            if (isValidTargetCountry(sourceCountry, targetCountry)) {
                break;
            }
        }
        
        while (canAttack(gameBoard, player) && loop) {
            int attackMode = apv.getAttackMode();
            switch (attackMode) {
                case 1: {
                    //manualAttack();
                    break;
                }
                case 2: {
                    autoAttack(sourceCountry,targetCountry);
                    break;
                }
                case 3: {
                    loop = false;
                    break;
                }
            }
        }
    }

    /**
     * Checks whether the player can attack or not
     *
     * @return true if the player can attack and false if he cannot
     */
    public boolean canAttack(GameBoard gameBoard, Player player) {
        HashMap<String, Integer> countryArmyInfo = player.getCountryArmyInfo();
        if (countryArmyInfo == null || countryArmyInfo.size() == 0) {
            return false;
        } else {
            int flag = 0;
            //Iterate to set the flag
            for (String countryName : countryArmyInfo.keySet()) {
                int army = countryArmyInfo.get(countryName) == null ? 0 : countryArmyInfo.get(countryName);
                if (army > 1) {
                    ArrayList<String> neighbours = gameBoard.getMap().getCountryAndNeighbourCountries().get(countryName);
                    for (int i = 0; i < neighbours.size(); i++) {
                        if (!gameBoard.getCountryDetails(neighbours.get(i)).getPlayerName().equals(player.getPlayerName())) {
                            flag = 1;
                        }
                    }
                }
            }

            if (checkWinnerOfWholeMap()) {
                return false;
            } else if (flag == 1) {
                return true;
            } else if (flag == 0) {
                return false;
            } else {
                return false;
            }
        }
    }

    /**
     * Checks whether the attacker owns the countries in the whole world or not
     *
     * @return true if the player owns the whole world and false if not
     */
    public boolean checkWinnerOfWholeMap() {
        boolean status = false;
        int ownercountries = player.getNumberOfCountries();
        int worldcountries = gameBoard.getMap().getNumberOfCountries();
        if (ownercountries == worldcountries) {
            status = true;
        }
        return status;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    private boolean isValidSourceCountry(String sourceCountry) {
        int army = gameBoard.getCountryArmy(sourceCountry);
        if (army > 1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidTargetCountry(String sourceCountry, String targetCountry) {
        String sourceOwner = gameBoard.getCountryDetails(sourceCountry).getPlayerName();
        String targetOwner = gameBoard.getCountryDetails(targetCountry).getPlayerName();

        ArrayList<String> neighbours = gameBoard.getMap().getCountryAndNeighbourCountries().get(sourceCountry);
        if (neighbours.contains(targetCountry)) {
            if (targetOwner.equalsIgnoreCase(sourceOwner)) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    private void autoAttack(String sourceCountry, String targetCountry) {
       
        
    }

}
