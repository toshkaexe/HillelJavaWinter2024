package org.hillel.game;

public class Game {

    private int playerWins;
    private int computerWins;
    private int tie;

    public int playRound(Card playerCard, Card computerCard) {
        if (playerCard.getCard().equals(computerCard.getCard())) {
            tie++;
            return 0;
        } else if ((playerCard == Card.Rock && computerCard == Card.Scissors) ||
                (playerCard == Card.Paper && computerCard == Card.Rock) ||
                (playerCard == Card.Scissors && computerCard == Card.Paper)) {
            playerWins++;
            return 1;
        } else {
            computerWins++;
            return 2;
        }
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public int getComputerWins() {
        return computerWins;
    }

    public int getTie() {
        return tie;
    }
}
