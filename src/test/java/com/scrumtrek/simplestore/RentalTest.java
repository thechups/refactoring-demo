package com.scrumtrek.simplestore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by serge on 04.04.2016.
 */
public class RentalTest {
    @Test
    public void ConstructorShouldProperInitialize() {
        Rental r = new Rental(new Movie("Movie1", PriceCodes.Childrens), 5);

        assertEquals(5, r.getDaysRented());
        assertEquals(PriceCodes.Childrens, r.getMovie().getPriceCode());
        assertEquals("Movie1", r.getMovie().getTitle());
    }
}
