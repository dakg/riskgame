/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategies;

import java.util.ArrayList;
import models.GameBoard;
import models.Player;

/**
 *
 * @author daksh
 */
public interface Strategy {

    public void initReinforce(GameBoard gameBoard, Player player);

    public void initAttack(GameBoard gameBoard, Player player);

    public void initFortify(GameBoard gameBoard, Player player);

    //All Reinforcement Options
    public String getReinforcementCountry(Player player);

    public int getReinforcementMoveNumber(Player player);

    public int getTradeInChoice();

    public int[] getCardChoice();

    //All Attack Options
    public int getAttackChoice();

    public int getAttackMode();

    public String getAttackingCountry(GameBoard gameBoard, Player player);

    public String getTargetCountry(GameBoard gameBoard, String sourceCountry);

    public int getAttackerDiceRolls();

    public int getArmyToMove(int attackRolls, int upperBound);

    //All fortify Options
    public int getFortifyChoice();

    public String getFortifySourceCountry(Player player);

    public String getFortifyDestiationCountry(Player player, String sourceCountry);

    public int getFortifyMoveNumber(Player player, String sourceCountry);
}
