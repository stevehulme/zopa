package com.test.zopa.domain;

import java.math.BigDecimal;

public class Lender {

    private String name;

    private BigDecimal rate;

    private BigDecimal available;

    public Lender(String name, BigDecimal rate, BigDecimal available) {
        this.name = name;
        this.rate = rate;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public BigDecimal getAvailable() {
        return available;
    }
}
