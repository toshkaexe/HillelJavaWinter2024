import org.hillel.game.Card;
import org.hillel.game.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    void testPlayRound_ComputerWins() {
        Game game = new Game();
        int result = game.playRound(Card.Rock, Card.Scissors);
        assertEquals(1, result, "Expected computer to win");
    }
    @Test
    void testPlayRound_PlayerWins() {
        Game game = new Game();
        int result = game.playRound(Card.Rock, Card.Paper);
        assertEquals(2, result, "Expected player to win");
    }
    @Test
    void testPlayRound_Tie() {

        Game game = new Game();
        int result1 = game.playRound(Card.Rock, Card.Rock);
        assertEquals(0, result1, "Expected tie");

        int result2 = game.playRound(Card.Scissors, Card.Scissors);
        assertEquals(0, result2, "Expected tie");

        int result3 = game.playRound(Card.Paper, Card.Paper);
        assertEquals(0, result3, "Expected tie");

    }

}
