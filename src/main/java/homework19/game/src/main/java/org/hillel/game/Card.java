package org.hillel.game;

public enum Card {
    Rock("rock"),
    Paper("paper"),
    Scissors("scissors");

    private final String symbol;
    public String getCard(){return symbol;}
    Card(String symbol) {
        this.symbol = symbol;
    }
}
