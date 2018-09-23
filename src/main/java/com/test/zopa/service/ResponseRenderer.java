package com.test.zopa.service;

import com.test.zopa.domain.LoanResult;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ResponseRenderer {

    public void generateResponseText(LoanResult loanResult) {

        System.out.println("Requested amount: £" + loanResult.getRequestedAmount().toString());
        System.out.println("Rate " + loanResult.getRate().multiply(BigDecimal.valueOf(100)).setScale(1, BigDecimal.ROUND_HALF_UP).toString() + "%");
        System.out.println("Monthly repayment: £" + loanResult.getMonthlyRepayment().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        System.out.println("Total repayment: £" + loanResult.getTotalRepayment().setScale(2, BigDecimal.ROUND_HALF_UP).toString());

    }
}
