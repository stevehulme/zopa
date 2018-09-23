package com.test.zopa.service.loan;

import com.test.zopa.domain.Lender;
import com.test.zopa.domain.LoanMatch;
import com.test.zopa.domain.LoanResult;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class LoanCalculator {

    private LoansMatcher loansMatcher;

    private LoanResultBuilder loanResultBuilder;

    public LoanCalculator(LoansMatcher loansMatcher, LoanResultBuilder loanResultBuilder) {
        this.loansMatcher = loansMatcher;
        this.loanResultBuilder = loanResultBuilder;
    }

    public LoanResult calculateBestLoan(List<Lender> lenders, BigDecimal requestedAmount) {
        List<LoanMatch> partialLoanResults = loansMatcher.getMatchedLoans(lenders, requestedAmount);
        return loanResultBuilder.createLoanResult(partialLoanResults, requestedAmount);
    }
}
