package com.scrumtrek.simplestore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by serge on 04.04.2016.
 */
public class MovieTests {
    @Test
    public void ConstructorShouldProperInitialize(){
        Movie m = new Movie("Movie1", PriceCodes.Childrens);

        assertEquals("Movie1", m.getTitle());
        assertEquals(PriceCodes.Childrens, m.getPriceCode());
    }
}