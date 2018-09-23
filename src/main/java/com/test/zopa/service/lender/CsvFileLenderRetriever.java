package com.test.zopa.service.lender;

import com.test.zopa.domain.Lender;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CsvFileLenderRetriever {

    static final String LENDER_RATE_AVAILABLE = "Lender,Rate,Available";

    private CsvFileLoader csvFileLoader;

    private LenderBuilder lenderBuilder;

    public CsvFileLenderRetriever(CsvFileLoader csvFileLoader, LenderBuilder lenderBuilder) {
        this.csvFileLoader = csvFileLoader;
        this.lenderBuilder = lenderBuilder;
    }

    public List<Lender> getLenders(String filename) throws IOException {
        return csvFileLoader.parseCsvFile(filename)
                .filter(lender -> !lender.equals(LENDER_RATE_AVAILABLE))
                .map(lenderBuilder::buildLender)
                .collect(Collectors.toList());
    }
}
