package com.scrumtrek.simplestore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CustomerTest {

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

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test
    public void testStatement() {
        String statement = custMickeyMouse.statement();

        assertEquals("Rental record for Mickey Mouse\n" +
                "\tCinderella\t3.0\n" +
                "\tStar Wars\t14.0\n" +
                "\tGladiator\t45.0\n" +
                "Amount owed is 62.0\n" +
                "You earned 4 frequent renter points.", statement);
    }

    @Test
    public void testStatementJson() {
        String statement = custMickeyMouse.statementJson();

        System.out.print(statement);
        assertEquals("{customerName:'Mickey Mouse'totalAmount'62.0'frequentRenterPoints:'4'[{movieName:'Cinderella', amount:'3.0'},{movieName:'Star Wars', amount:'14.0'},{movieName:'Gladiator', amount:'45.0'}]}", statement);
    }

    @Test
    public void nameTest() {
        assertEquals("Mickey Mouse", custMickeyMouse.getName());
    }

}