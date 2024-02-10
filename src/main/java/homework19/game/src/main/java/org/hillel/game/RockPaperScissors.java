package org.hillel.game;
import org.hillel.game.dto.Card;

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
                System.out.println("Enter your choice (rock, paper, or scissors):");
                playerChoice = scanner.nextLine().toLowerCase();
            } while (!isValidChoice(playerChoice, validChoices));

            Card playerKarta = Card.valueOf(playerChoice.substring(0, 1).toUpperCase() + playerChoice.substring(1));
            System.out.println(playerName +"'s choice: " +   playerKarta.getCard());

            Card computerCard = generateComputerChoice();
            System.out.println("Computer's choice: " + computerCard.getCard());


            String result = game.playRound(playerKarta, computerCard);
            if (result.equals("Player wins!")) {
                System.out.println("You win!");
            } else if (result.equals("Computer wins!")) {
                System.out.println("Computer wins!");
            } else {
                System.out.println("It's a tie!");
            }

//            // Проверяем, хочет ли пользователь завершить игру
//            System.out.println("Do you want to quit? (Type 'quit' to exit)");
//            String userInput = scanner.nextLine().toLowerCase();
//            if (userInput.equals("quit")) {
//                break;
//            }
        }

        System.out.println("Total games played: " + numGames);
        System.out.println("Total wins: " + game.getPlayerWins());
        System.out.println("Total losses: " + game.getComputerWins());
        System.out.println("Total ties: " + game.getTie());
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
