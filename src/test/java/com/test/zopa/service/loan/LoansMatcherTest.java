package com.test.zopa.service.loan;

import com.test.zopa.domain.Lender;
import com.test.zopa.domain.LoanMatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LoansMatcherTest {

    private LenderSorter lenderSorter = mock(LenderSorter.class);

    private LoansMatcher loansMatcher;

    @BeforeEach
    private void setup() {
        loansMatcher = new LoansMatcher(lenderSorter);
    }

    @Test
    public void shouldReturnListOfMatchedLoans() {

        Lender lender1 = mock(Lender.class);
        when(lender1.getAvailable()).thenReturn(BigDecimal.valueOf(600));
        when(lender1.getRate()).thenReturn(BigDecimal.valueOf(12));
        Lender lender2 = mock(Lender.class);
        when(lender2.getAvailable()).thenReturn(BigDecimal.valueOf(500));
        when(lender1.getRate()).thenReturn(BigDecimal.valueOf(41));
        List<Lender> lenderList = Arrays.asList(lender1, lender2);
        when(lenderSorter.sort(lenderList)).thenReturn(lenderList);

        List<LoanMatch> matchedLoans = loansMatcher.getMatchedLoans(lenderList, BigDecimal.valueOf(1000));

        assertAll(
                () -> assertTrue(matchedLoans.size() == 2),
                () -> assertEquals(matchedLoans.get(0).getAmountBorrowed(), BigDecimal.valueOf(600)),
                () -> assertEquals(matchedLoans.get(0).getRate(), lender1.getRate()),
                () -> assertEquals(matchedLoans.get(1).getAmountBorrowed(), BigDecimal.valueOf(400)),
                () -> assertEquals(matchedLoans.get(1).getRate(), lender2.getRate())
        );

    }
}