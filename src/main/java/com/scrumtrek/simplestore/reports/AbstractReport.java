package com.scrumtrek.simplestore.reports;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Rental;

/**
 * Abstract class for report building
 */
public abstract class AbstractReport {
    protected double fullRentalAmount;
    protected Customer customer;

    public AbstractReport(Customer customer) {
        this.customer = customer;
    }


    protected void countFullRentalAmountAndFreqPoints() {
        fullRentalAmount = 0;
        double discount = customer.getDiscountPercent();

        for (Rental rental : customer.getRentals()) {
            fullRentalAmount += rental.getAmount(discount);
        }
    }

    /**
     * Builds simple report with header and footer only
     *
     * @return
     */
    public String getSimpleReport() {
        countFullRentalAmountAndFreqPoints();
        return getHeader() + getFooter();
    }

    /**
     * Builds report with header, rents and footer only
     *
     * @return
     */
    public String getMiddleReport() {
        countFullRentalAmountAndFreqPoints();
        return getHeader() + getMiddleBody() + getFooter();
    }

    /**
     * Builds report with header, rents, movies and footer only
     *
     * @return
     */
    public String getDetailReport() {
        countFullRentalAmountAndFreqPoints();
        return getHeader() + getDetailedBody() + getFooter();
    }

    protected abstract String getHeader();

    protected abstract String getMiddleBody();

    protected abstract String getDetailedBody();

    protected abstract String getFooter();
}
