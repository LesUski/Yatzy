package com.kyh;

import java.util.Scanner;

public class Yatzy {
    private static final Scanner sc = new Scanner(System.in);
    private static final Dice[] dices = new Dice[5];
    private static int turns = 0;

    public static void initiateDices() {

        for (int i = 0; i < dices.length; i++) {
            dices[i] = new Dice();
        }
    }

    public static void playGame() {
        System.out.println("====================================================================================\n" +
                "Welcome to Yatzy, type (R) to roll the dices, or anything else to close the program.");
        System.out.print("Type (R): ");

        while (turns < 3) {

            if (sc.next().equalsIgnoreCase("R")) {

                turns = turns + 1;

                startTurn();

            } else {
                System.out.println("Closing game...");
                return;
            }
        }
        if (turns == 3) {
            System.out.println("======================================================================================================");
            System.out.println("You ran of of rounds, if youw wish to start a new game press (Y), anything else will close the program.");
            System.out.print("Type to start all over (Y): ");

            if (sc.next().equalsIgnoreCase("Y")) {
                turns = 0;
                playGame();

            } else {
                System.out.println("Closing game...");
            }
        }

    }

    public static void startTurn() {

        for (int i = 0; i < dices.length; i++) {
            dices[i].generateRandomValue();
            System.out.println("Dice " + (i + 1) + " shows " + dices[i].value);
        }

        if (checkIfYatzy(dices)) {
            System.out.println("You got Yatzy!! In turn " + turns + " out of 3");

        } else {
            System.out.println("No luck this time! Turn " + turns + " out of 3");
            if (turns != 3)
                System.out.print("Type (R) to play again: \n");
        }

    }

    public static boolean checkIfYatzy(Dice[] d) {
        boolean b = true;

        for (int i = 1; i < d.length; i++) {

            if (d[i].value != d[i - 1].value) {
                b = false;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        initiateDices();
        playGame();
    }
}