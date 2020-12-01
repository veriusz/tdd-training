package pl.training.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    void should_return_amount_zero() {
        var money = new Money();
        Assertions.assertEquals(0.0, money.getAmount());
    }

}
