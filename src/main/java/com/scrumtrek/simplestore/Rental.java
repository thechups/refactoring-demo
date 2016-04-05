package com.scrumtrek.simplestore;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getAmount(double discount) {
        return getMovie().getPriceCode().getRentAmount(getDaysRented(), discount);
    }

    public double getAmount() {
        return getAmount(0);
    }

}

