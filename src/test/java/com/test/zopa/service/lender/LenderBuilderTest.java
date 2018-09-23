package com.test.zopa.service.lender;

import com.test.zopa.domain.Lender;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LenderBuilderTest {

    public static final String LENDER_NAME = "lenderName";
    public static final String RATE = "10";
    public static final String AVAILABLE = "1000";
    private LenderBuilder lenderBuilder = new LenderBuilder();

    @Test
    public void shouldBuildLender() {

        Lender lender = lenderBuilder.buildLender(LENDER_NAME + "," + RATE + "," + AVAILABLE);
        assertAll(
                () -> assertEquals(LENDER_NAME, lender.getName()),
                () -> assertEquals(new BigDecimal(RATE), lender.getRate()),
                () -> assertEquals(new BigDecimal(AVAILABLE), lender.getAvailable())

        );
    }
}