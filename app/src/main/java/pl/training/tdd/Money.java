package pl.training.tdd;

import java.math.BigDecimal;

public class Money {

    private BigDecimal amount;
    private Currency currency;

    public Money(Currency currency) {
        this.amount = BigDecimal.ZERO;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void add(BigDecimal one) {
        amount = amount.add(one);
    }

    public Currency getCurrency() {
        return currency;
    }

    public void diff(BigDecimal bigDecimal) {
        amount = amount.subtract(bigDecimal);
    }
}
