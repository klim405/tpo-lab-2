package org.klim405.logarithms;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class LogTest {

    @DisplayName("Проверка log")
    @ParameterizedTest
    @CsvFileSource(resources = "/logarithms/log.csv", numLinesToSkip = 1)
    public void testLogWithLnMock(
            BigDecimal x, int n, BigDecimal ln_x, BigDecimal ln_n, double log_x, double log_accuracy) {
        BigDecimal bigN = BigDecimal.valueOf(n);
        Ln mockLn = Mockito.mock(Ln.class);
        when(mockLn.calc(x)).thenReturn(ln_x);
        when(mockLn.calc(bigN)).thenReturn(ln_n);

        Log log = new Log(mockLn, n);
        assertEquals(log.calcDouble(x), log_x, log_accuracy);
    }
}
