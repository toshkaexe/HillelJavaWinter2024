package org.hillel.game;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();

        int numGames;
        do {
            System.out.println("How many games would you like to play?");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // очистка буфера ввода
            }
            numGames = scanner.nextInt();

            if (numGames <= 0) {
                System.out.println("Please enter a number greater than zero.");
            }
        } while (numGames <= 0);

        RockPaperScissors gameService = new RockPaperScissors(playerName);
        gameService.playGame(numGames);
        scanner.close();
    }
}
