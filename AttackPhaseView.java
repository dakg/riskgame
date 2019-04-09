/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Strategies.StrategyContext;
import controllers.AttackPhaseController;
import java.util.Scanner;

/**
 *
 * @author daksh
 */
public class AttackPhaseView {

    AttackPhaseController apc;

    public void showView(AttackPhaseController apc) {
        this.apc = apc;
        System.out.println("----------------Attack Phase started-----------");

    }

    /**
     * Gets the signal(choice) for the Fortification
     *
     * @return signal(choice)
     */
    public int getAttackChoice() {
        int choice = new StrategyContext(apc.getPlayer().getStrategy()).getAttackChoice();
        System.out.println(choice);
        return choice;
    }

    public int getAttackMode() {
        System.out.println("Please select any : ");
        System.out.println("1). Attack once ");
        System.out.println("2). Anhiliate ");
        System.out.println("3). Close this attack");
        int choice = new StrategyContext(apc.getPlayer().getStrategy()).getAttackMode();
        return choice;
    }

    public String getSourceCountry() {
        System.out.println("Please enter Source Country : ");
        String choice = new StrategyContext(apc.getPlayer().getStrategy()).getAttackingCountry(apc.getGameBoard(), apc.getPlayer());
        return choice;
    }
    
    public String getTargetCountry(String sourceCountry) {
        System.out.println("Please enter Target Country : ");
        String choice = new StrategyContext(apc.getPlayer().getStrategy()).getTargetCountry(apc.getGameBoard(), sourceCountry);
        return choice;
    }

}
