package org.klim405.logarithms;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class LogTest {

    @DisplayName("Проверка log c моковым ln")
    @ParameterizedTest
    @CsvFileSource(resources = "/logarithms/log.csv", numLinesToSkip = 1)
    public void testLogWithLnMock(
            BigDecimal x, int n, BigDecimal lnX, BigDecimal lnN, double logX, double logAccuracy) {
        BigDecimal bigN = BigDecimal.valueOf(n);
        Ln mockLn = Mockito.mock(Ln.class);
        when(mockLn.calc(x)).thenReturn(lnX);
        when(mockLn.calc(bigN)).thenReturn(lnN);

        Log log = new Log(mockLn, n);
        assertEquals(logX, log.calc(x).doubleValue(), logAccuracy);
    }

    @DisplayName("Проверка log")
    @ParameterizedTest
    @CsvFileSource(resources = "/logarithms/log.csv", numLinesToSkip = 1)
    public void testLog(
            double x, int n, BigDecimal lnX, BigDecimal lnN, double logX, double logAccuracy) {

        Log log = new Log(new Ln(logAccuracy), n);
        double res = Math.log10(x) / Math.log10(n);
        assertEquals(res, log.calcDouble(x), logAccuracy);
    }
}
