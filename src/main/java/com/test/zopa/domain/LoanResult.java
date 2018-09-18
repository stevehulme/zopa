package com.test.zopa.domain;

import java.math.BigDecimal;

public class LoanResult {

    private BigDecimal requestedAmount;
    private BigDecimal rate;
    private BigDecimal monthlyTepayment;
    private BigDecimal totalRepayment;

    public LoanResult(BigDecimal requestedAmount, BigDecimal rate, BigDecimal monthlyTepayment, BigDecimal totalRepayment) {
        this.requestedAmount = requestedAmount;
        this.rate = rate;
        this.monthlyTepayment = monthlyTepayment;
        this.totalRepayment = totalRepayment;
    }

    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public BigDecimal getMonthlyTepayment() {
        return monthlyTepayment;
    }

    public BigDecimal getTotalRepayment() {
        return totalRepayment;
    }
}
