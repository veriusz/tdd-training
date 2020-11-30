package pl.training.tdd;

public class Template {

    private final String textWithExpressions;

    public Template(String testWithExpressions) {
        this.textWithExpressions = testWithExpressions;
    }

    public String evaluate() {
        return textWithExpressions;
    }

}
