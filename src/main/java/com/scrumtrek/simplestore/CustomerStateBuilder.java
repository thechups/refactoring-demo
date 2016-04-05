package com.scrumtrek.simplestore;

/**
 * Created by serge on 04.04.2016.
 */
public class CustomerStateBuilder {
    public CustomerStateBuilder() {

    }

    public CustomerState GetCustomerState(Customer customer) {

        CustomerState result = new CustomerState();
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        for (Rental each : customer.getRentals()) {
            double thisAmount = 0;

            // Determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Regular:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;

                case NewRelease:
                    thisAmount += each.getDaysRented() * 3;
                    break;

                case Childrens:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount = (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }

            // Add frequent renter points
            frequentRenterPoints++;

            // Add bonus for a two-day new-release rental
            if ((each.getMovie().getPriceCode() == PriceCodes.NewRelease) && (each.getDaysRented() > 1)) {
                frequentRenterPoints++;
            }

            totalAmount += thisAmount;
            result.addMovieStates(new CustomerMovieState(each.getMovie(), thisAmount));
        }
        result.setTotalAmount(totalAmount);
        result.setFrequentRenterPoints(frequentRenterPoints);
        return result;
    }
}
