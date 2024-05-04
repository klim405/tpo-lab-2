package org.klim405.trigonometry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinTest {
    @DisplayName("Проверка sin")
    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometry/sin.csv", numLinesToSkip = 1)
    public void testSin(double value, double accuracy) {
        Sin sin = new Sin();
        assertEquals(Math.sin(value), sin.calcDouble(value), accuracy);
    }
}
