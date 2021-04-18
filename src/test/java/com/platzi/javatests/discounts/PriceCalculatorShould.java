package com.platzi.javatests.discounts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceCalculatorShould {

    @Test
    void return_zero_when_there_are_not_prices() {
        PriceCalculator calculator = new PriceCalculator();

        assertEquals(0, calculator.getTotal());
    }

    @Test
    void return_is_the_prices_sum() {
        PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice(10.2);
        calculator.addPrice(15.2);

        assertEquals(25.4, calculator.getTotal());
    }

    @Test
    void apply_discount_to_prices() {
        PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice(50.5);
        calculator.addPrice(49.5);
        calculator.setDiscount(10);

        assertEquals(90, calculator.getTotal());
    }
}