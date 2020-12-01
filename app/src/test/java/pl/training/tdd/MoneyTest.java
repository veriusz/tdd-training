package pl.training.tdd;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyTest {

    @Test
    void should_return_amount_zero() {
        var money = new Money(null);
        assertEquals(BigDecimal.ZERO, money.getAmount());
    }

    @Test
    void given_one_two_when_add_should_return_three() {
        var money = new Money(null);
        money.add(BigDecimal.ONE);
        money.add(new BigDecimal("2"));
        assertEquals(new BigDecimal("3"), money.getAmount());
    }

    @Test
    void given_amount_should_return_currency() {
        var money = new Money(Currency.PLN);
        assertEquals(Currency.PLN, money.getCurrency());
    }

    @Test
    void difference_return_correct_value() {
        var money = new Money(Currency.PLN);
        money.add(BigDecimal.TEN);
        money.diff(new BigDecimal("9"));
        assertEquals(BigDecimal.ONE, money.getAmount());
    }

    @Test
    void difference_when_subtract_throw_below_zero_exception() {
        var money = new Money(Currency.PLN);
        money.add(BigDecimal.ONE);
        assertThrows(IllegalArgumentException.class, () -> money.diff(new BigDecimal("9")));
    }

    @Test
    void given_money_when_compare_then_return_correct_value() {
        var m1 = new Money(Currency.PLN);
        m1.add(BigDecimal.TEN);
        var m2 = new Money(Currency.PLN);
        m2.add(BigDecimal.ONE);

        assertEquals(-1, m1.compareAmount(m2));
        assertEquals(0, m1.compareAmount(m1));
        assertEquals(1, m2.compareAmount(m1));
    }

}
