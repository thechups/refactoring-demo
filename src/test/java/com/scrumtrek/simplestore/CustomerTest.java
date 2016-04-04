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
//        Customer custDonaldDuck = new Customer("Donald Duck");
//        Customer custMinnieMouse = new Customer("Minnie Mouse");

        // Create rentals
        Rental rental1 = new Rental(movCinderella, 5);
        Rental rental2 = new Rental(movStarWars, 5);
        Rental rental3 = new Rental(movGladiator, 5);

        // Assign rentals to customers
        custMickeyMouse.addRental(rental1);
        custMickeyMouse.addRental(rental2);
        custMickeyMouse.addRental(rental3);

        // Generate invoice
        String statement = custMickeyMouse.Statement();

        // Print the statement
        System.out.println(statement);

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddRental() {
        custMickeyMouse.Statement();
    }

    @Test
    public void nameTest() {
        custMickeyMouse.Statement();
        assertEquals("Mickey Mouse", custMickeyMouse.getName());
    }

}