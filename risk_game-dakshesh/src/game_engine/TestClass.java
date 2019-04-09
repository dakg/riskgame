/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_engine;

import java.util.Collections;
import java.util.LinkedList;
import resources.Constants;
import resources.Constants.RISKCARD;

/**
 *
 * @author daksh
 */
public class TestClass {

    public static void main(String[] args) {
        LinkedList<RISKCARD> riskCards = new LinkedList();
        int maxPileSize = 42;

        for (int i = 0; i < maxPileSize / 3; i++) {
            riskCards.add(Constants.RISKCARD.CAVALRY);
            riskCards.add(Constants.RISKCARD.ARTILLERY);
            riskCards.add(Constants.RISKCARD.INFANTRY);
        }
        System.out.println(riskCards);
        Collections.shuffle(riskCards);
        System.out.println(riskCards);
       // gameBoard.setRiskCards(riskCards);
    }

}
