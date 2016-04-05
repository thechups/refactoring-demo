package com.scrumtrek.simplestore.prices;

public class XXXPriceCode extends RegularPriceCode {
    /**
     * Переопределяем пороговое значение дней
     * после достижения которого начинает учитываться
     * коэффициент
     */
    public XXXPriceCode() {
        DAYS_THRESHOLD = 4;
    }
}
