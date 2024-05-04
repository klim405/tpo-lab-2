package org.klim405.trigonometry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SecTest {
    @DisplayName("Проверка sec c моковым cos")
    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometry/sec.csv", numLinesToSkip = 1)
    public void testSecWithLnMock(double value) {
        BigDecimal bigDecimal = new BigDecimal(value);
        Cos mockCos = Mockito.mock(Cos.class);
        when(mockCos.calc(bigDecimal)).thenReturn(BigDecimal.valueOf(Math.cos(value)));

        Sec sec = new Sec(mockCos);
        assertEquals(1 / Math.cos(value), sec.calc(bigDecimal).doubleValue(), 0.00001);
    }

    @DisplayName("Проверка sec")
    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometry/sec.csv", numLinesToSkip = 1)
    public void testSec(double value, double accuracy) {
        Sec sec = new Sec(new Cos(0.00001));
        assertEquals(1 / Math.cos(value), sec.calcDouble(value), accuracy);
    }
}
