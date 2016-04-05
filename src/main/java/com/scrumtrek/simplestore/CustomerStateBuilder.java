package com.scrumtrek.simplestore;

/**
 * Creates CustomerState by customer.
 */
public class CustomerStateBuilder {

    public CustomerState getCustomerState(Customer customer) {

        CustomerState result = new CustomerState();
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        for (Rental rental : customer.getRentals()) {
            double thisAmount = 0;

            // Determine amounts for rental line
            if (rental.getMovie().getPriceCode() == PriceCodes.REGULAR) {
                thisAmount += 2;
                if (rental.getDaysRented() > 2) {
                    thisAmount += (rental.getDaysRented() - 2) * 1.5;
                }

            } else if (rental.getMovie().getPriceCode() == PriceCodes.NEW_RELEASE) {
                thisAmount += rental.getDaysRented() * 3;

            } else if (rental.getMovie().getPriceCode() == PriceCodes.CHILDRENS) {
                thisAmount += 1.5;
                if (rental.getDaysRented() > 3) {
                    thisAmount = (rental.getDaysRented() - 3) * 1.5;
                }
            }

            // Add frequent renter points
            frequentRenterPoints++;

            // Add bonus for a two-day new-release rental
            if ((rental.getMovie().getPriceCode() == PriceCodes.NEW_RELEASE) && (rental.getDaysRented() > 1)) {
                frequentRenterPoints++;
            }

            totalAmount += thisAmount;
            result.addMovieStates(new CustomerMovieState(rental.getMovie(), thisAmount));
        }
        result.setTotalAmount(totalAmount);
        result.setFrequentRenterPoints(frequentRenterPoints);
        return result;
    }
}
