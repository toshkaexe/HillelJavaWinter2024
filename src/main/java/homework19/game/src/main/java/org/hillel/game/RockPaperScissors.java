package org.hillel.game;

import java.util.Scanner;
public class RockPaperScissors {
    private final Scanner scanner = new Scanner(System.in);
    private final String playerName;

    public RockPaperScissors(String playerName) {
        this.playerName = playerName;
    }

    public void playGame(int numGames) {
        Game game = new Game();

        String[] validChoices = {"rock", "paper", "scissors", "exit"};
        String playerChoice;

        for (int i = 0; i < numGames; i++) {
            int j = i+1;
            System.out.println("Game: " + j + "/"+numGames);

            do {
                System.out.println("Enter your choice (rock, paper, or scissors, exit):");
                playerChoice = scanner.nextLine().toLowerCase();

                // Проверяем, хочет ли пользователь завершить игру
                if (playerChoice.equals("exit")) {
                    System.out.println("Exiting the game...");
                    return;
                }
            } while (!isValidChoice(playerChoice, validChoices));

            Card playerCard = Card.valueOf(playerChoice.substring(0, 1).toUpperCase() + playerChoice.substring(1));
            System.out.println(playerName +"'s choice: " +   playerCard.getCard());

            Card computerCard = generateComputerChoice();
            System.out.println("Computer's choice: " + computerCard.getCard());


            int result = game.playRound(playerCard, computerCard);
            switch (result) {
                case 1:
                    System.out.println(playerName + " wins!");
                    break;
                case 2:
                    System.out.println("Computer wins!");
                    break;
                default:
                    System.out.println("It's a tie!");
                    break;
            }
        }

        System.out.println(playerName +"'s Total games played: " + numGames);
        System.out.println(playerName +"'s Total wins: " + game.getPlayerWins());
        System.out.println(playerName +"'s Total losses: " + game.getComputerWins());
        System.out.println(playerName +"'s Total ties: " + game.getTie());
    }


    // Метод для проверки правильности выбора
    public static boolean isValidChoice(String choice, String[] validChoices) {
        for (String validChoice : validChoices) {
            if (choice.equals(validChoice)) {
                return true;
            }
        }
        System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
        return false;
    }
    private Card generateComputerChoice() {
        int rand = (int) (Math.random() * 3);
        switch (rand) {
            case 0:
                return Card.Rock;
            case 1:
                return Card.Paper;
            default:
                return Card.Scissors;
        }
    }
}
