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
        if (isSubtractGreaterThenZero(bigDecimal)) {
            throw new IllegalArgumentException();
        }
        amount = amount.subtract(bigDecimal);
    }

    private boolean isSubtractGreaterThenZero(BigDecimal bigDecimal) {
        return BigDecimal.ZERO.compareTo(amount.subtract(bigDecimal)) > 0;
    }

    public int compareAmount(Money m2) {
        if (amount.compareTo(m2.getAmount()) > 0) {
            return -1;
        }
        if (amount.compareTo(m2.getAmount()) == 0) {
            return 0;
        }
        if (amount.compareTo(m2.getAmount()) < 0) {
            return 1;
        }
        return 100;
    }
}
