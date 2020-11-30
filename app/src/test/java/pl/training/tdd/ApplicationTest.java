package pl.training.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

    @DisplayName("Given an empty template, when evaluating, then should return an empty text")
    @Test
    void evaluation_of_empty_template_returns_an_empty_string() {
        var template = new Template();
        Assertions.assertEquals("", template.evaluate());
    }

}
