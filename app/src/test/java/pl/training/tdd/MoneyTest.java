package pl.training.tdd;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyTest {

    // lepsza nazwa testu (domyślna wartość dla Money to zero)
    @Test
    void should_return_amount_zero() {
        var money = new Money(null);
        assertEquals(BigDecimal.ZERO, money.getAmount());
    }


    // unikac hardcode w nazwach metod (suma 2-ch Money, powinna zwracać sumę tych wartości)
    @Test
    void given_one_two_when_add_should_return_three() {
        var money = new Money(null);
        money.add(BigDecimal.ONE); //add(Money a)
        money.add(new BigDecimal("2"));
        assertEquals(new BigDecimal("3"), money.getAmount());
    }

    @Test
        // test gettera
    void given_amount_should_return_currency() {
        var money = new Money(Currency.PLN);
        assertEquals(Currency.PLN, money.getCurrency());
    }

    @Test
    void subtract_of_Moneys_return_difference_of_their_values() {
        var money = new Money(Currency.PLN);
        money.add(BigDecimal.TEN);
        money.subtract(new BigDecimal("9"));
        assertEquals(BigDecimal.ONE, money.getAmount());
    }

    @Test
    void subtract_greater_value_throws_exception() {
        var money = new Money(Currency.PLN);
        money.add(BigDecimal.ONE);
        assertThrows(IllegalArgumentException.class, () -> money.subtract(new BigDecimal("9")));
    }


    @Test
    void money_with_equal_values_and_currencies_should_be_equal() {
        var m1 = new Money(Currency.PLN);
        m1.add(BigDecimal.TEN);
        var m2 = new Money(Currency.PLN);
        m2.add(BigDecimal.TEN);

//        assertEquals(-1, m1.compareAmount(m2));
//        assertEquals(0, m1.compareAmount(m1));
//        implementacja equals o amount i currency
        assertEquals(m1, m2);
    }

}
