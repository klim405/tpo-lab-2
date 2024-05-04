package org.klim405.trigonometry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosTest {
    @DisplayName("Проверка cos")
    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometry/cos.csv", numLinesToSkip = 1)
    public void testCos(double value, double accuracy) {
        Cos cos = new Cos();
        assertEquals(Math.cos(value), cos.calcDouble(value), accuracy);
    }
}
