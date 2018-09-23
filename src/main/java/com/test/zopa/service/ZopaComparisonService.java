package com.test.zopa.service;

import com.test.zopa.domain.Lender;
import com.test.zopa.domain.LoanResult;
import com.test.zopa.service.lender.CsvFileLenderRetriever;
import com.test.zopa.service.loan.LoanCalculator;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ZopaComparisonService {

    private CsvFileLenderRetriever csvFileLenderRetriever;

    private LoanCalculator loanCalculator;

    private ResponseRenderer responseRenderer;

    public ZopaComparisonService(CsvFileLenderRetriever csvFileLenderRetriever, LoanCalculator loanCalculator, ResponseRenderer responseRenderer) {
        this.csvFileLenderRetriever = csvFileLenderRetriever;
        this.loanCalculator = loanCalculator;
        this.responseRenderer = responseRenderer;
    }

    public void calculateComparison(String lendersFilename, String requestedAmount) throws IOException {
        List<Lender> lenders = csvFileLenderRetriever.getLenders(lendersFilename);
        LoanResult loanResult = loanCalculator.calculateBestLoan(lenders, new BigDecimal(requestedAmount));
        responseRenderer.generateResponseText(loanResult);

    }


}
