package com.test.zopa.domain;

import java.math.BigDecimal;

public class LoanResult {

    private BigDecimal requestedAmount;
    private BigDecimal rate;
    private BigDecimal monthlyRepayment;
    private BigDecimal totalRepayment;

    public LoanResult(BigDecimal requestedAmount, BigDecimal rate, BigDecimal monthlyRepayment, BigDecimal totalRepayment) {
        this.requestedAmount = requestedAmount;
        this.rate = rate;
        this.monthlyRepayment = monthlyRepayment;
        this.totalRepayment = totalRepayment;
    }

    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public BigDecimal getMonthlyRepayment() {
        return monthlyRepayment;
    }

    public BigDecimal getTotalRepayment() {
        return totalRepayment;
    }
}
