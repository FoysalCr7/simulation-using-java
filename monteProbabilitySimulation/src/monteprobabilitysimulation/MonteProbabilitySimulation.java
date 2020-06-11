/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monteprobabilitysimulation;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author USER
 */
public class MonteProbabilitySimulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner input=new Scanner(System.in);
System.out.println("enter your number for simulate: ");
        int simulation =input.nextInt(); // number of games to simulate
        int wins = 0;
        for (int i = 0; i < simulation; i++) {
            if (playerwins()) {
                wins++;
            }
        }

        // Calculate result and construct output strings.
        String s1 = String.format("Win rate: %,d/%,d", wins, simulation);
        
        double winPercent = (double) wins / simulation * 100;
        String s2 = String.format("Winning percentage: %.3f%%", winPercent);
        
        String output = s1 + "\n" + s2;
        System.out.println(output);
    }

    /**
     * Simulates the game of Craps.
     *
     * @return true if player wins, false otherwise
     */
    public static boolean playerwins() {
        final int firstSum = rollDice();

        if (firstSum == 7 || firstSum == 11) {
            return true;
        }
        else if (firstSum == 2 || firstSum == 3 || firstSum == 12) {
            return false;
        }else{

        int newSum =rollDice();
        while (newSum != firstSum && newSum != 7) {
            newSum = rollDice();
        }
        return newSum == firstSum;
    }
    }

    /**
     * Simulates rolling a pair of dice.
     *
     * @return the sum of numbers rolled
     */
    public static int rollDice() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int die1 = 1 + random.nextInt(6);
        int die2 = 1 + random.nextInt(6);
        return die1 + die2;
    }
    }
    

