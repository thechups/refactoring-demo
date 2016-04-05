package com.scrumtrek.simplestore.prices;

public class NewReleasePriceCode extends PriceCode {
    @Override
    public double getRentAmount(int daysRented) {
        return daysRented * 3.0;
    }

}
