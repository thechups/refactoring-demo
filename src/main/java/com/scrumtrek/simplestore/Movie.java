package com.scrumtrek.simplestore;

/*
Class movie.
contains movie name and it`s price code.
*/
public class Movie {
    private String m_Title;
    private PriceCodes m_PriceCode;

    public Movie(String title, PriceCodes priceCode) {
        m_Title = title;
        m_PriceCode = priceCode;
    }

    public PriceCodes getPriceCode() {
        return m_PriceCode;
    }

    public String getTitle() {
        return m_Title;
    }
}

