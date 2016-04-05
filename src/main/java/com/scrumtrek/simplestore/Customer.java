package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private CustomerStateBuilder stateBuilder = new CustomerStateBuilder();
    private String m_Name;
    private List<Rental> m_Rentals = new ArrayList<>();

    public Customer(String name) {
        m_Name = name;
    }

    public List<Rental> getRentals() {
        return new ArrayList<>(m_Rentals);
    }

    public String getName() {
        return m_Name;
    }


    public void addRental(Rental arg) {
        m_Rentals.add(arg);
    }

    public String Statement() {


        CustomerState state = stateBuilder.GetCustomerState(this);

        String result = "Rental record for " + m_Name + "\n";

        for (CustomerMovieState movieState : state.getMovieStates()) {
            result += "\t" + movieState.getMovie().getTitle() + "\t" + movieState.getAmount() + "\n";
        }

        // Add footer lines
        result += "Amount owed is " + state.getTotalAmount() + "\n";
        result += "You earned " + state.getFrequentRenterPoints() + " frequent renter points.";
        return result;
    }

    public String StatementJson() {
        CustomerState state = stateBuilder.GetCustomerState(this);
        String result = "{" +
                "customerName:'" + this.getName() + "'" +
                "totalAmount'" + state.getTotalAmount() + "'" +
                "frequentRenterPoints:'" + state.getFrequentRenterPoints() + "'" +
                getJsonMovieStates(state.getMovieStates()) +
                "}";
        return result;
    }

    private String getJsonMovieStates(List<CustomerMovieState> states) {
        String result = "";
        for (CustomerMovieState state : states) {
            result += "{movieName:'" + state.getMovie().getTitle() + "', amount:'" + state.getAmount() + "'},";
        }
        result = result.substring(0, result.length() - 1);
        return "[" + result + "]";
    }
}

