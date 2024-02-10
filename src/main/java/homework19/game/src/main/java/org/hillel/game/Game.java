package org.hillel.game;

import org.hillel.game.dto.Card;

public class Game {

    private int playerWins;
    private int computerWins;

    private int tie;

    public String playRound(Card playerCard, Card computerCard) {
        if (playerCard == computerCard) {
            tie++;
            return "It's a tie";
        } else if ((playerCard == Card.Rock && computerCard == Card.Scissors) ||
                (playerCard == Card.Paper && computerCard == Card.Rock) ||
                (playerCard == Card.Scissors && computerCard == Card.Paper)) {
            playerWins++;
            return "Player wins";
        } else {
            computerWins++;
            return "Computer wins";
        }
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public int getComputerWins() {
        return computerWins;
    }
    public int getTie(){
        return tie;
    }
}
