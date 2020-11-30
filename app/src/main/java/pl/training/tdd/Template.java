package pl.training.tdd;

import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.regex.Pattern;

public class Template {

    private static final Pattern EXPRESSION = Pattern.compile("\\$\\{\\w+}");
    private static final String INVALID_VALUE = "\\W+";
    private static final String EXPRESSION_START = "\\$\\{";
    private static final String EXPRESSION_END = "}";

    private final String textWithExpressions;

    public Template(String testWithExpressions) {
        this.textWithExpressions = testWithExpressions;
    }

    public String evaluate(Map<String, String> valuesMap) {
        if (containsInvalidValues(valuesMap) || isComplete(valuesMap)) {
            throw new IllegalArgumentException();
        }
        return valuesMap.keySet().stream().reduce(textWithExpressions, substitute(valuesMap));
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

    private BinaryOperator<String> substitute(Map<String, String> valuesMap) {
        return (result, key) -> result.replaceAll(createExpression(key), valuesMap.get(key));
    }

    private String createExpression(String key) {
        return EXPRESSION_START + key + EXPRESSION_END;
    }

}
