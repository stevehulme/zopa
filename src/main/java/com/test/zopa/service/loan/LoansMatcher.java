package com.test.zopa.service.loan;

import com.test.zopa.domain.Lender;
import com.test.zopa.domain.LoanMatch;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class LoansMatcher {

    private LenderSorter lenderSorter;

    public LoansMatcher(LenderSorter lenderSorter) {
        this.lenderSorter = lenderSorter;
    }

    public List<LoanMatch> getMatchedLoans(List<Lender> lenders, BigDecimal requestedAmount) {
        List<Lender> sortedLenders = lenderSorter.sort(lenders);

        List<LoanMatch> loanMatches = new ArrayList<>();
        BigDecimal remainingLoanToFill = requestedAmount;
        for (Lender lender : sortedLenders) {
            BigDecimal available = lender.getAvailable();
            if (remainingLoanToFill.compareTo(available) > 0) {
                loanMatches.add(new LoanMatch(available, lender.getRate()));
                remainingLoanToFill = remainingLoanToFill.subtract(available);
            }
            else {
                loanMatches.add(new LoanMatch(remainingLoanToFill, lender.getRate()));
                break;
            }
        }

        return loanMatches;
    }
}
