package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serge on 04.04.2016.
 */
public class CustomerState {
    private int frequentRenterPoints;
    private double totalAmount;
    private List<CustomerMovieState> movieStates = new ArrayList<CustomerMovieState>() ;



    public CustomerState(){

    }


    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public void setFrequentRenterPoints(int frequentRenterPoints) {
        this.frequentRenterPoints = frequentRenterPoints;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<CustomerMovieState> getMovieStates() {
        return new ArrayList<>(movieStates);
    }

    public void addMovieStates(CustomerMovieState movieState) {
        this.movieStates.add(movieState);
    }
}
