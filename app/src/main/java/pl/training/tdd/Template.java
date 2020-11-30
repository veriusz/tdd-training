package pl.training.tdd;

import java.util.Map;
import java.util.regex.Pattern;

public class Template {

    private static final Pattern EXPRESSION = Pattern.compile("\\$\\{\\w+}");
    private static final String INVALID_VALUE = "\\W+";

    private final String textWithExpressions;

    public Template(String testWithExpressions) {
        this.textWithExpressions = testWithExpressions;
    }

    public String evaluate(Map<String, String> valuesMap) {
        if (containsInvalidValues(valuesMap) || isComplete(valuesMap)) {
            throw new IllegalArgumentException();
        }
        return textWithExpressions;
    }

    private boolean isComplete(Map<String, String> valuesMap) {
        return getExpressionsCount() != valuesMap.size();
    }

    private long getExpressionsCount() {
        return EXPRESSION.matcher(textWithExpressions).results().count();
    }

    private boolean containsInvalidValues(Map<String, String> valuesMap) {
        return valuesMap.values().stream().anyMatch(value -> value.matches(INVALID_VALUE));
    }

}
