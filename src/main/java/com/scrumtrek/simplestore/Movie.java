package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.pricecodes.PriceCode;

/**
 * Class movie.
 * contains movie name and it`s price code.
 */
public class Movie {
    private String title;
    private PriceCode priceCode;

    public Movie(String title, PriceCode priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public PriceCode getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }
}

