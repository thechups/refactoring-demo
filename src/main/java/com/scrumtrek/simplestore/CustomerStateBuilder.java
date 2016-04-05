package com.scrumtrek.simplestore;

/**
 * Created by serge on 04.04.2016.
 */
public class CustomerStateBuilder {

    public CustomerState getCustomerState(Customer customer) {

        CustomerState result = new CustomerState();
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        for (Rental each : customer.getRentals()) {
            double thisAmount = 0;

            // Determine amounts for each line
            if (each.getMovie().getPriceCode() == PriceCodes.REGULAR) {
                thisAmount += 2;
                if (each.getDaysRented() > 2) {
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                }

            } else if (each.getMovie().getPriceCode() == PriceCodes.NEW_RELEASE) {
                thisAmount += each.getDaysRented() * 3;

            } else if (each.getMovie().getPriceCode() == PriceCodes.CHILDRENS) {
                thisAmount += 1.5;
                if (each.getDaysRented() > 3) {
                    thisAmount = (each.getDaysRented() - 3) * 1.5;
                }
            }

            // Add frequent renter points
            frequentRenterPoints++;

            // Add bonus for a two-day new-release rental
            if ((each.getMovie().getPriceCode() == PriceCodes.NEW_RELEASE) && (each.getDaysRented() > 1)) {
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
