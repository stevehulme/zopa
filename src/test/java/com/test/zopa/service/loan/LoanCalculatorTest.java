package com.test.zopa.service.loan;

import com.test.zopa.domain.Lender;
import com.test.zopa.domain.LoanMatch;
import com.test.zopa.domain.LoanResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LoanCalculatorTest {

    private LoansMatcher loansMatcher = mock(LoansMatcher.class);

    private LoanResultBuilder loanResultBuilder = mock(LoanResultBuilder.class);

    private LoanCalculator loanCalculator;

    @BeforeEach
    private void setup() {
        loanCalculator = new LoanCalculator(loansMatcher, loanResultBuilder);
    }

    @Test
    public void shouldReturnLoanResult() {
        BigDecimal requestedAmount = mock(BigDecimal.class);
        Lender lender = mock(Lender.class);
        LoanMatch loanMatch = mock(LoanMatch.class);
        when(loansMatcher.getMatchedLoans(Arrays.asList(lender), requestedAmount)).thenReturn(Arrays.asList(loanMatch));
        LoanResult loanResult = mock(LoanResult.class);
        when(loanResultBuilder.createLoanResult(Arrays.asList(loanMatch), requestedAmount)).thenReturn(loanResult);

        LoanResult calculatedLoanResult = loanCalculator.calculateBestLoan(Arrays.asList(lender), requestedAmount);

        assertEquals(loanResult, calculatedLoanResult);

    }

}