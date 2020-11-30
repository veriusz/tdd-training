package pl.training.tdd;

import java.util.Map;

public class Template {

    private final String textWithExpressions;

    public Template(String testWithExpressions) {
        this.textWithExpressions = testWithExpressions;
    }

    public String evaluate(Map<Object, Object> valuesMap) {
        return textWithExpressions;
    }

}
