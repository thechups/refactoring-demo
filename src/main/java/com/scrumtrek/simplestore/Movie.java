package com.scrumtrek.simplestore;

/**
 * Class movie.
 * contains movie name and it`s price code.
 */
public class Movie {
    private String title;
    private PriceCodes priceCode;

    public Movie(String title, PriceCodes priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public PriceCodes getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }
}

