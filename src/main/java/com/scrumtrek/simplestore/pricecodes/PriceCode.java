package com.scrumtrek.simplestore.pricecodes;

/**
 * Created by serge on 05.04.2016.
 * Base class for all pricecodes
 */
public abstract class PriceCode {
    private String name;

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public abstract double getAmount(int daysRented);
}
