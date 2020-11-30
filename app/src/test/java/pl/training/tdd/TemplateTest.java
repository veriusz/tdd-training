package pl.training.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemplateTest {

    @DisplayName("Given an empty template, when evaluating, then should return an empty text")
    @Test
    void evaluation_of_empty_template_returns_an_empty_string() {
        var template = new Template("");
        assertEquals("", template.evaluate());
    }

    @DisplayName("Given an template with simple text (without expressions), when evaluating, then should return the text")
    @Test
    void evaluation_of_template_with_simple_text_returns_an_text_string() {
        var template = new Template("My name is Jan");
        assertEquals("My name is Jan", template.evaluate());
    }

}
