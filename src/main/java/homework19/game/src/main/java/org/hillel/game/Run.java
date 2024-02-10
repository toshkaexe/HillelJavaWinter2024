package org.hillel.game;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();
        System.out.println("How many games would you like to play?");
        int numGames = scanner.nextInt();

        RockPaperScissors gameService = new RockPaperScissors(playerName);
        gameService.playGame(numGames);
        scanner.close();
    }
    }
