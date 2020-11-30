package pl.training.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTest {

    @DisplayName("Given an empty template, when evaluating, then should return an empty text")
    @Test
    void evaluation_of_empty_template_returns_an_empty_string() {
        var template = new Template();
        assertEquals("", template.evaluate());
    }

}
