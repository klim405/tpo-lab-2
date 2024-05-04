package org.klim405.logarithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LnTest {
    @DisplayName("Проверка ln")
    @ParameterizedTest
    @CsvFileSource(resources = "/logarithms/ln.csv", numLinesToSkip = 1)
    public void testLn(double value) {
        Ln log = new Ln();
        assertEquals(Math.log(value), log.calcDouble(value), 0.0001);
    }
}
