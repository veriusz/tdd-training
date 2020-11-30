package pl.training.tdd;

import java.util.Map;
import java.util.regex.Pattern;

public class Template {

    public static final Pattern EXPRESSION = Pattern.compile("\\$\\{\\w+}");

    private final String textWithExpressions;

    public Template(String testWithExpressions) {
        this.textWithExpressions = testWithExpressions;
    }

    public String evaluate(Map<String, String> valuesMap) {
        if (getExpressionsCount() !=  valuesMap.size()) {
            throw new IllegalArgumentException();
        }
        return textWithExpressions;
    }

    private long getExpressionsCount() {
        return EXPRESSION.matcher(textWithExpressions).results().count();
    }

}
