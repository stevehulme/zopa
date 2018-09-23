package com.test.zopa.service.loan;

import com.test.zopa.domain.LoanMatch;
import com.test.zopa.domain.LoanResult;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class LoanResultBuilder {

    public static final int MONTHS = 12;
    public static final int TERM_IN_MONTHS = 3 * MONTHS;

    public LoanResult createLoanResult(List<LoanMatch> loanMatches, BigDecimal requestedAmount) {

        BigDecimal interestRateSum = BigDecimal.ZERO;
        BigDecimal monthlyRepaymentSum = BigDecimal.ZERO;

        for (LoanMatch loanMatch : loanMatches) {
            BigDecimal interestRate = loanMatch.getRate();
            interestRateSum = interestRateSum.add(interestRate);

            double monthlyRate = interestRate.doubleValue() / MONTHS;

            double monthlyPayment =
                    (loanMatch.getAmountBorrowed().doubleValue() * monthlyRate) /
                            (1 - Math.pow(1 + monthlyRate, -TERM_IN_MONTHS));

            monthlyRepaymentSum = monthlyRepaymentSum.add(BigDecimal.valueOf(monthlyPayment));
        }

        return new LoanResult(requestedAmount, interestRateSum.divide(BigDecimal.valueOf(loanMatches.size())), monthlyRepaymentSum, monthlyRepaymentSum.multiply(BigDecimal.valueOf(TERM_IN_MONTHS)));
    }
}
