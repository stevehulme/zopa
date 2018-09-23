package com.test.zopa.service.lender;

import com.test.zopa.domain.Lender;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LenderBuilder {

    public Lender buildLender(String lenderString) {
        String[] lenderParameters = lenderString.split(",");
        return new Lender(lenderParameters[0], new BigDecimal(lenderParameters[1]), new BigDecimal(lenderParameters[2]));

    }
}
