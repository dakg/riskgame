/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author daksh
 */
public class TestClass {

    public static void main(String[] args) {

        Random random = new Random();

        int n = random.nextInt(100);
        System.out.println(n);
        List g = new ArrayList<String>();
        g.add("1");
        g.add("4");
        List g2 = new ArrayList<String>();
        g2.add("1");
        g2.add("2");
        g2.add("3");

        if (g2.containsAll(g)) {
            System.out.println("All present");
            System.out.println(g);
            System.out.println(g2);
        } else {

            System.out.println("not present");
            System.out.println(g);
            System.out.println(g2);
        }
        LinkedList l = new LinkedList();
        l.add("1");
        l.add("2");
        System.out.println(l);
        l.remove();
        l.add("3");
        System.out.println(l);
        
        System.out.println("Here");
        System.out.println("");
        System.out.println(g);
        List g3 = new ArrayList(g);
        System.out.println(g3);
        g3.remove(0);
        System.out.println(g);
        System.out.println(g3);
        
        List g4 = new ArrayList();
        
        System.out.println(g4.toString());
    }
}
