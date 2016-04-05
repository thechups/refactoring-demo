package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.prices.PriceCode;

public class Movie {
	private String title;
	private PriceCode priceCode;

	public Movie(String title, PriceCode priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public PriceCode getPriceCode()	{
		return priceCode;
	}
	
	public void setPriceCode(PriceCode value) {
		priceCode = value;
	}

	public String getTitle() {
		return title;
	}
}

