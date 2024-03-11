package com.coderscampus.assignment2;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rng = new Random();
        int secretNumber = rng.nextInt(100) + 1;
        int remainingGuesses = 5;
        int playerGuess;
        boolean playerWon = false;
        do {
            try {
                System.out.print("Pick a number between 1 and 100: ");
                playerGuess = Integer.parseInt(scanner.nextLine());
                if (playerGuess < 1 || playerGuess > 100) {
                    System.out.println("Your guess is not between 1 and 100, please try again");
                } else if (playerGuess < secretNumber) {
                    --remainingGuesses;
                    System.out.println("Please pick a higher number. Remaining guesses: " + remainingGuesses);
                } else if (playerGuess > secretNumber) {
                    --remainingGuesses;
                    System.out.println("Please pick a lower number. Remaining guesses: " + remainingGuesses);
                } else {
                    System.out.println("You win!");
                    playerWon = true;
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Must be a whole number!");
            }
        } while (remainingGuesses > 0);
        if (!playerWon) {
            System.out.println("You lose!");
            System.out.println("The number to guess was: " + secretNumber);
        }
    }
}
