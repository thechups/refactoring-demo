package com.scrumtrek.simplestore;

import org.junit.Test;

import static org.junit.Assert.*;


public class CustomerTest {

    Customer custMickeyMouse;

    @org.junit.Before
    public void setUp() throws Exception {
        // Create movies
        Movie movCinderella = new Movie("Cinderella", PriceCodes.Childrens);
        Movie movStarWars = new Movie("Star Wars", PriceCodes.Regular);
        Movie movGladiator = new Movie("Gladiator", PriceCodes.NewRelease);

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

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddRental() {
        String statement = custMickeyMouse.Statement();

        assertEquals("Rental record for Mickey Mouse\n" +
                "\tCinderella\t3.0\n" +
                "\tStar Wars\t14.0\n" +
                "\tGladiator\t45.0\n" +
                "Amount owed is 62.0\n" +
                "You earned 4 frequent renter points.", statement);
    }

    @Test
    public void nameTest() {
        assertEquals("Mickey Mouse", custMickeyMouse.getName());
    }

}