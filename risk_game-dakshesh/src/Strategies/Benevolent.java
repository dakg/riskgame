/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategies;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import static java.util.Map.Entry.comparingByValue;
import java.util.Set;
import static java.util.stream.Collectors.toMap;
import models.GameBoard;
import models.Player;
import services.RandomGenerator;
import static services.RandomGenerator.randomNumberGenerator;

/**
 *
 * @author daksh
 */
public class Benevolent implements Strategy {

    public Benevolent() {

    }

    public void initReinforce(GameBoard gameBoard, Player player) {
    }

    public void initAttack(GameBoard gameBoard, Player player) {
    }

    public void initFortify(GameBoard gameBoard, Player player) {
    }

    @Override
    public String getReinforcementCountry(Player player) {
        HashMap<String, Integer> countryArmyInfo = player.getCountryArmyInfo();
        Entry<String, Integer> entry = Collections.min(countryArmyInfo.entrySet(),
                Comparator.comparing(Entry::getValue));
        String key = entry.getKey();
        return key;
    }

    @Override
    public int getReinforcementMoveNumber(Player player) {
        return 1; // It will always reinforce country 1 by 1
    }

    /**
     * Gets the Trade-In choice of the player
     *
     * @return Choice of the player
     */
    @Override
    public int getTradeInChoice() {
        while (true) {
            int c = RandomGenerator.randomNumberGenerator(1, 2);
            System.out.println(c);
            return c;
        }
    }

    /**
     * Gets the Card Choice of the player
     *
     * @return card
     */
    @Override
    public int[] getCardChoice() {
        int c[] = new int[3];
        c = RandomGenerator.getCardChoice();
        System.out.println(" " + c[0] + " " + c[1] + " " + c[2]);
        return c;
    }

    /**
     *
     * Gets the Attack or Exit Choice
     *
     * @return 2 Exits the Attack
     *
     */
    @Override

    public int getAttackChoice() {

        return 2; //2 means he will not attack.

    }

    /**
     *
     * Gets the attack mode
     *
     * @return 3 close the attack
     *
     */
    @Override

    public int getAttackMode() {

//         attackOnce = 1;
//         attackAllOut = 2;
//         closeAttack = 3;
        return 3; //3 means he will close the attack but it wont reach here.Because benevolent player always chooses not to attack

    }

    /**
     *
     * Gets the source country
     *
     * @param gameboard Object of the GameBoard {@link models.GameBoard}
     *
     * @param player Object of the current player {@link models.Player}
     *
     *
     * @return Benevolent player never attacks : null
     *
     */
    @Override

    public String getAttackingCountry(GameBoard gameboard, Player player) {
        return null;
    }

    /**
     *
     * Gets the target country
     *
     *
     * @param gameboard Object of the GameBoard {@link models.GameBoard}
     *
     * @param sourceCountry source country
     *
     * @return null as there is no attack Phase for Benevolent Player
     *
     */
    @Override

    public String getTargetCountry(GameBoard gameboard, String sourceCountry) {
        return null;
    }

    /**
     *
     * Gets the Number of Dice Rolled by the Attacker
     *
     * @return 1 as there will not be any attack phase for Benevolent Player
     *
     */
    @Override
    public int getAttackerDiceRolls() {
        return 1;
    }

    /**
     *
     * Gets the Army to be moved from source country to destination country
     *
     *
     * @param lowerBound Number of Dice Rolled by the attacker
     *
     * @param upperBound Maximum number of Dice Rolls that can be rolled by the
     * attacker
     *
     *
     * @return 1 as there will be no attack and there will be no such scenario
     * for Benevolent player
     *
     */
    @Override

    public int getArmyToMove(int lowerBound, int upperBound) {
        return 1;
    }

    @Override
    public int getFortifyChoice() {
        int fortifyChoice = 1;
        return fortifyChoice;
    }

    @Override
    public String getFortifySourceCountry(Player player) {
        HashMap<String, Integer> countryArmyInfo = player.getCountryArmyInfo();

        Map<String, Integer> sorted = countryArmyInfo
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                                LinkedHashMap::new));

        int halfSize = sorted.size() / 2;
        Iterator it = sorted.entrySet().iterator();
        Map.Entry<String, Integer> pair = null;
        for (int i = 0; i < sorted.size(); i++) {
            if (i < halfSize) {
                it.next();
            } else {
                pair = (HashMap.Entry<String, Integer>) it.next();
                if (pair.getValue() > 1) {
                    break;
                }
            }
        }

        String sourceCountry = pair.getKey();
        return sourceCountry;

    }

    @Override
    public String getFortifyDestiationCountry(Player player, String sourceCountry) {
        HashMap<String, Integer> countryArmyInfo = player.getCountryArmyInfo();

        Map<String, Integer> sorted = countryArmyInfo
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                                LinkedHashMap::new));

        sorted.remove(sourceCountry);

        Entry<String, Integer> entry = Collections.min(sorted.entrySet(),
                Comparator.comparing(Entry::getValue));

        String destinationCountry = entry.getKey();
        return destinationCountry;

    }

    @Override
    public int getFortifyMoveNumber(Player player, String sourceCountry) {
        int armyNumber = player.getCountryArmyInfo().get(sourceCountry) - 1;
        int moveNumber = armyNumber > 2 ? (armyNumber - 1) / 2 : 1;
        return moveNumber;
    }

}
