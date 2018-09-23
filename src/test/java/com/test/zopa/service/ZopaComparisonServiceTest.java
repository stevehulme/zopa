package com.test.zopa.service;

import com.test.zopa.domain.Lender;
import com.test.zopa.domain.LoanResult;
import com.test.zopa.service.lender.CsvFileLenderRetriever;
import com.test.zopa.service.loan.LoanCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

import static org.mockito.Mockito.*;

class ZopaComparisonServiceTest {

    public static final BigDecimal REQUESTED_AMOUNT = BigDecimal.TEN;
    public static final String TEST_FILENAME = "testFilename";
    private ZopaComparisonService zopaComparisonService;
    private CsvFileLenderRetriever csvFileLenderRetriever = mock(CsvFileLenderRetriever.class);
    private LoanCalculator loanCalculator = mock(LoanCalculator.class);
    private ResponseRenderer responseRenderer = mock(ResponseRenderer.class);


    @BeforeEach
    private void setup() {
        zopaComparisonService = new ZopaComparisonService(csvFileLenderRetriever, loanCalculator, responseRenderer);
    }

    @Test
    public void shouldRenderCorrectResponse() throws IOException {
        Lender lender = mock(Lender.class);
        when(csvFileLenderRetriever.getLenders(TEST_FILENAME)).thenReturn(Arrays.asList(lender));
        LoanResult loadResult = mock(LoanResult.class);
        when(loanCalculator.calculateBestLoan(Arrays.asList(lender), REQUESTED_AMOUNT)).thenReturn(loadResult);

        zopaComparisonService.calculateComparison(TEST_FILENAME, REQUESTED_AMOUNT.toString());
        verify(responseRenderer).generateResponseText(loadResult);
    }

}