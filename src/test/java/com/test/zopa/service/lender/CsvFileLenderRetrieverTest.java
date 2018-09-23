package com.test.zopa.service.lender;

import com.test.zopa.domain.Lender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.test.zopa.service.lender.CsvFileLenderRetriever.LENDER_RATE_AVAILABLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CsvFileLenderRetrieverTest {

    public static final String TEST_FILE_NAME = "testFileName";
    public static final String LENDER_STRING = "A,1,10";

    private CsvFileLoader csvFileLoader = mock(CsvFileLoader.class);

    private LenderBuilder lenderBuilder = mock(LenderBuilder.class);

    private CsvFileLenderRetriever csvFileLenderRetriever;

    @BeforeEach
    private void setup() {
        csvFileLenderRetriever = new CsvFileLenderRetriever(csvFileLoader, lenderBuilder);
    }

    @Test
    public void shouldReturnListOfLenders() throws IOException {
        Stream<String> lendersStream = Stream.of(LENDER_RATE_AVAILABLE, LENDER_STRING);
        when(csvFileLoader.parseCsvFile(TEST_FILE_NAME)).thenReturn(lendersStream);
        Lender lender = mock(Lender.class);
        when(lenderBuilder.buildLender(LENDER_STRING)).thenReturn(lender);

        List<Lender> lenders = csvFileLenderRetriever.getLenders(TEST_FILE_NAME);

        assertEquals(Arrays.asList(lender), lenders);
    }


}