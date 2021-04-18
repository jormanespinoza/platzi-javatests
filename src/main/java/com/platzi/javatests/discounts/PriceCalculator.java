package com.platzi.javatests.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

    private final List<Double> prices = new ArrayList<>();
    private double discount = 0;

    public double getTotal() {
        double total = prices.stream().mapToDouble(price -> price).sum();
        return total * ((100 - discount) / 100);
    }

    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
