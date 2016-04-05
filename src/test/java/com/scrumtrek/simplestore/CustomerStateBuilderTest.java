package com.scrumtrek.simplestore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by serge on 04.04.2016.
 */
public class CustomerStateBuilderTest {


    Customer custMickeyMouse;

    @org.junit.Before
    public void setUp() throws Exception {
        // Create movies
        Movie movCinderella = new Movie("Cinderella", PriceCodes.CHILDRENS);
        Movie movStarWars = new Movie("Star Wars", PriceCodes.REGULAR);
        Movie movGladiator = new Movie("Gladiator", PriceCodes.NEW_RELEASE);

        // Create customers
        custMickeyMouse = new Customer("Mickey Mouse");

        // Create rentals
        Rental rental1 = new Rental(movCinderella, 5);
        Rental rental2 = new Rental(movStarWars, 10);
        Rental rental3 = new Rental(movGladiator, 15);

        // Assign rentals to customers
        custMickeyMouse.addRental(rental1);
        custMickeyMouse.addRental(rental2);
        custMickeyMouse.addRental(rental3);
    }

    @Test
    public void getCustomerState() throws Exception {
        CustomerStateBuilder builder = new CustomerStateBuilder();
        CustomerState state = builder.getCustomerState(custMickeyMouse);

        assertEquals(62.0, state.getTotalAmount(), 0);
        assertEquals(4.0, state.getFrequentRenterPoints(), 0);
    }

}