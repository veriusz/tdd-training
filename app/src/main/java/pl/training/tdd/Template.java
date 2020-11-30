package pl.training.tdd;

import java.util.Map;
import java.util.regex.Pattern;

public class Template {

    private final String textWithExpressions;

    public Template(String testWithExpressions) {
        this.textWithExpressions = testWithExpressions;
    }

    public String evaluate(Map<Object, Object> valuesMap) {
        if (Pattern.compile("\\$\\{\\w+}").matcher(textWithExpressions).results().count() !=  valuesMap.size()) {
            throw new IllegalArgumentException();
        }
        return textWithExpressions;
    }

}
