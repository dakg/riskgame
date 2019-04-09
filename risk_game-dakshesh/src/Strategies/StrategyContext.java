/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategies;

import models.GameBoard;
import models.Player;

/**
 *
 * @author daksh
 */
public class StrategyContext {

    Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public void initReinforce(GameBoard gameBoard, Player player) {
        this.strategy.initReinforce(gameBoard, player);
    }

    public void initAttack(GameBoard gameBoard, Player player) {
        this.strategy.initAttack(gameBoard, player);
    }

    public void initFortify(GameBoard gameBoard, Player player) {
        this.strategy.initFortify(gameBoard, player);
    }

    //All Reinforcement Options
    public String getReinforcementCountry(Player player) {
        return this.strategy.getReinforcementCountry(player);
    }

    public int getReinforcementMoveNumber(Player player) {
        return this.strategy.getReinforcementMoveNumber(player);
    }

    public int getTradeInChoice() {
        return this.strategy.getTradeInChoice();
    }

    public int[] getCardChoice() {
        return this.strategy.getCardChoice();
    }

    //All Attack Options
    public int getAttackChoice() {
        return this.strategy.getAttackChoice();
    }

    public int getAttackMode() {
        return this.strategy.getAttackMode();
    }

    public String getAttackingCountry(GameBoard gameBoard, Player player) {
        return this.strategy.getAttackingCountry(gameBoard, player);
    }

    public String getTargetCountry(GameBoard gameBoard, String sourceCountry) {
        return this.strategy.getTargetCountry(gameBoard, sourceCountry);
    }

    public int getAttackerDiceRolls() {
        return this.strategy.getAttackerDiceRolls();
    }

    public int getArmyToMove(int attackRolls, int upperBound) {
        return this.strategy.getArmyToMove(attackRolls, upperBound);
    }

    //All fortify Options
    public int getFortifyChoice() {
        return this.strategy.getFortifyChoice();
    }

    public String getFortifySourceCountry(Player player) {
        return this.strategy.getFortifySourceCountry(player);
    }

    public String getFortifyDestiationCountry(Player player, String sourceCountry) {
        return this.strategy.getFortifyDestiationCountry(player, sourceCountry);
    }

    public int getFortifyMoveNumber(Player player, String sourceCountry) {
        return this.strategy.getFortifyMoveNumber(player, sourceCountry);
    }

}
