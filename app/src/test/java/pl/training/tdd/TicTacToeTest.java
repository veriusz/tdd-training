package pl.training.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeTest {

    @DisplayName("Given, a new game, when created new game, then should return true")
    @Test
    void evaluate_of_empty_template_returns_an_empty_string() {
        var ticTacToe = new TicTacToe();
        assertTrue(ticTacToe.begin("", ""));
    }

    @DisplayName("Given players name, when created new game, then should return numbers of players")
    @Test
    void give_names_returns_numbers_of_players() {
        var ticTacToe = new TicTacToe();
        assertEquals(2, ticTacToe.begin("jan", "anna"));
    }

}
