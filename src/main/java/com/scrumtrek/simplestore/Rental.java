package com.scrumtrek.simplestore;

/**
 * Class that contains movie and it days rental.
 */
public class Rental {
    private Movie movie;
    private int daysRented;


    /**
     * Creates rental instance with movie and days.
     * @param movie
     * @param daysRented
     */
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }


    /**
     * Returns days movie rented.
     * @return days rented.
     */
    public int getDaysRented() {
        return daysRented;
    }


    /**
     * Returns rental movie.
     * @return movie.
     */
    public Movie getMovie() {
        return movie;
    }
}

