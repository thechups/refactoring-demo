package com.scrumtrek.simplestore;

/**
 * Created by serge on 04.04.2016.
 */
public class CustomerMovieState {
    private Movie movie;
    private double amount;

    public CustomerMovieState(Movie movie, double amount) {
        this.movie = movie;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public Movie getMovie() {
        return movie;
    }
}
