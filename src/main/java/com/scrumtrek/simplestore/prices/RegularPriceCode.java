package com.scrumtrek.simplestore.prices;

public class RegularPriceCode extends PriceCode {
    protected double baseAmount = 2.0;
    protected double daysThreshold = 2;

    /**
     * Common for regular movies price value
     * with days threshold
     *
     * @param daysRented
     * @return rentAmount
     */
    @Override
    public double getRentAmount(int daysRented) {
        double amount = baseAmount;
        if (daysRented > daysThreshold) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }
}
