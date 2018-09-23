package com.test.zopa.service.loan;

import com.test.zopa.domain.Lender;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LenderSorterTest {

    LenderSorter lenderSorter = new LenderSorter();

    @Test
    public void shouldSortListCorrectly() {
        Lender lender1 = mock(Lender.class);
        when(lender1.getRate()).thenReturn(BigDecimal.valueOf(22));
        Lender lender2 = mock(Lender.class);
        when(lender2.getRate()).thenReturn(BigDecimal.valueOf(3));
        Lender lender3 = mock(Lender.class);
        when(lender3.getRate()).thenReturn(BigDecimal.valueOf(1));
        Lender lender4 = mock(Lender.class);
        when(lender4.getRate()).thenReturn(BigDecimal.valueOf(12));

        List<Lender> sortedLenders = lenderSorter.sort(Arrays.asList(lender1, lender2, lender3, lender4));

        assertAll(
                () -> assertEquals(lender3, sortedLenders.get(0)),
                () -> assertEquals(lender2, sortedLenders.get(1)),
                () -> assertEquals(lender4, sortedLenders.get(2)),
                () -> assertEquals(lender1, sortedLenders.get(3))
        );

    }

}