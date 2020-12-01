package pl.training.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeTest {

    @DisplayName("Given, a new game, when created new game, then should return true")
    @Test
    void evaluate_of_empty_template_returns_an_empty_string() {
        var ticTacToe = new TicTacToe();
        assertTrue(ticTacToe.begin());
    }
}
