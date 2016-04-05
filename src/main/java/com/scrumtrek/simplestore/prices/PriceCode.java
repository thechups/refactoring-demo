package com.scrumtrek.simplestore.prices;

public abstract class PriceCode {
    /**
     * calculates amount
     *
     * @param daysRented
     * @return rent amount depends on realization
     */
    protected abstract double getRentAmount(int daysRented);

    public double getRentAmount(int daysRented, double discountPercent) {
        return getRentAmount(daysRented) * discountPercent / 100.0;
    }
}
