package com.test.zopa.service.loan;

import com.test.zopa.domain.Lender;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LenderSorter {

    public List<Lender> sort(List<Lender> lenders) {
        return lenders.stream()
                .sorted(Comparator.comparingDouble(lender -> lender.getRate().doubleValue())).collect(Collectors.toList());
    }
}
