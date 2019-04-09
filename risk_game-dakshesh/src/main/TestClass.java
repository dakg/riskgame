/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author daksh
 */
public class TestClass {

    public static void main(String[] args) {
        String s[][] = new String[3][];
        Scanner sc = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("1");
                    break;
                }
                case 2: {
                    System.out.println("2");
                    loop = false;
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
}
