package com.test.zopa.domain;

import java.math.BigDecimal;

public class LoanMatch {

    private BigDecimal amountBorrowed;
    private BigDecimal rate;

    public LoanMatch(BigDecimal amountBorrowed, BigDecimal rate) {
        this.amountBorrowed = amountBorrowed;
        this.rate = rate;
    }

    public BigDecimal getAmountBorrowed() {
        return amountBorrowed;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
