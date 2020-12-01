package pl.training.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class MoneyTest {

    @Test
    void should_return_amount_zero() {
        var money = new Money();
        Assertions.assertEquals(BigDecimal.ZERO, money.getAmount());
    }

}
