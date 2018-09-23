package com.test.zopa.service.loan;

import com.test.zopa.domain.LoanMatch;
import com.test.zopa.domain.LoanResult;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LoanResultBuilderTest {

    private LoanResultBuilder loanResultBuilder = new LoanResultBuilder();

    @Test
    public void shouldBuildResultForOneLoanMatch() {
        BigDecimal requestedAmount = BigDecimal.valueOf(1000);
        LoanMatch loanMatch = mock(LoanMatch.class);
        when(loanMatch.getRate()).thenReturn(BigDecimal.valueOf(0.07));
        when(loanMatch.getAmountBorrowed()).thenReturn(BigDecimal.valueOf(1000));

        LoanResult loanResult = loanResultBuilder.createLoanResult(Arrays.asList(loanMatch), requestedAmount);

        assertAll(
                () -> assertEquals(loanResult.getMonthlyRepayment().setScale(2, BigDecimal.ROUND_HALF_UP), BigDecimal.valueOf(30.88)),
                () -> assertEquals(loanResult.getRate(), BigDecimal.valueOf(0.07)),
                () -> assertEquals(loanResult.getTotalRepayment().setScale(2, BigDecimal.ROUND_HALF_UP), BigDecimal.valueOf(1111.58)),
                () -> assertEquals(loanResult.getRequestedAmount(), BigDecimal.valueOf(1000))

                );

    }

    @Test
    public void shouldBuildResultForTwoLoanMatches() {
        BigDecimal requestedAmount = BigDecimal.valueOf(1000);
        LoanMatch loanMatch1 = mock(LoanMatch.class);
        when(loanMatch1.getRate()).thenReturn(BigDecimal.valueOf(0.07));
        when(loanMatch1.getAmountBorrowed()).thenReturn(BigDecimal.valueOf(500));
        LoanMatch loanMatch2 = mock(LoanMatch.class);
        when(loanMatch2.getRate()).thenReturn(BigDecimal.valueOf(0.08));
        when(loanMatch2.getAmountBorrowed()).thenReturn(BigDecimal.valueOf(500));

        LoanResult loanResult = loanResultBuilder.createLoanResult(Arrays.asList(loanMatch1, loanMatch2), requestedAmount);

        assertAll(
                () -> assertEquals(loanResult.getMonthlyRepayment().setScale(2, BigDecimal.ROUND_HALF_UP), BigDecimal.valueOf(31.11)),
                () -> assertEquals(loanResult.getRate(), BigDecimal.valueOf(0.075)),
                () -> assertEquals(loanResult.getTotalRepayment().setScale(2, BigDecimal.ROUND_HALF_UP), BigDecimal.valueOf(1119.84)),
                () -> assertEquals(loanResult.getRequestedAmount(), BigDecimal.valueOf(1000))

        );

    }

}