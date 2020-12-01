package pl.training.tdd;

import java.math.BigDecimal;

public class Money {

    private BigDecimal bigDecimal = BigDecimal.ZERO;

    public BigDecimal getAmount() {
        return bigDecimal;
    }

    public void add(BigDecimal one) {
        bigDecimal = bigDecimal.add(one);
    }

    public Currency getCurrency() {
        return null;
    }

}
