package pl.training.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Collections.emptyMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TemplateTest {

    @DisplayName("Given an empty template, when evaluating, then should return an empty text")
    @Test
    void evaluation_of_empty_template_returns_an_empty_string() {
        var template = new Template("");
        assertEquals("", template.evaluate(emptyMap()));
    }

    @DisplayName("Given an template with simple text (without expressions), when evaluating, then should return the text")
    @Test
    void evaluation_of_template_with_simple_text_returns_an_text_string() {
        var template = new Template("My name is Jan");
        assertEquals("My name is Jan", template.evaluate(emptyMap()));
    }

    @DisplayName("Given an template, when evaluating without providing all values, then should throw an exception")
    @Test
    void evaluation_of_template_without_providing_all_values_throw_an_exception() {
        var template = new Template("My name is ${firstName}");
        assertThrows(IllegalArgumentException.class, () -> template.evaluate(emptyMap()));
    }

    @DisplayName("Given an template, when evaluating with non alphanumeric values, then should throw an exception")
    @Test
    void evaluation_of_template_with_non_alphanumeric_values_throw_an_exception() {
        var template = new Template("My name is ${firstName}");
        var valuesMap = Map.of("firstName", "@aaa");
        assertThrows(IllegalArgumentException.class, () -> template.evaluate(valuesMap));
    }

    @DisplayName("Given an template, when evaluating, then should return the text with substituted values")
    @Test
    void evaluation_of_template_returns_text_with_substituted_values() {
        var template = new Template("My name is ${firstName} ${lastName}");
        var valuesMap = Map.of("firstName", "Jan", "lastName", "Kowalski");
        assertEquals("My name is Jan Kowalski", template.evaluate(valuesMap));
    }

}
