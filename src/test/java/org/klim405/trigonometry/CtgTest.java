package org.klim405.trigonometry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CtgTest {
    @DisplayName("Проверка ctg c моковым cos и sin")
    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometry/ctg.csv", numLinesToSkip = 1)
    public void testCtgWithLnMock(double value) {
        BigDecimal bigDecimal = new BigDecimal(value);
        Cos mockCos = Mockito.mock(Cos.class);
        when(mockCos.calc(bigDecimal)).thenReturn(BigDecimal.valueOf(Math.cos(value)));
        Sin mockSin = Mockito.mock(Sin.class);
        when(mockSin.calc(bigDecimal)).thenReturn(BigDecimal.valueOf(Math.sin(value)));

        Ctg ctg = new Ctg(mockSin, mockCos);
        assertEquals(1 / Math.tan(value), ctg.calc(bigDecimal).doubleValue(), 0.00001);
    }

    @DisplayName("Проверка ctg")
    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometry/ctg.csv", numLinesToSkip = 1)
    public void testCtg(double value, double accuracy) {
        Ctg ctg = new Ctg(new Sin(), new Cos());
        assertEquals(1 / Math.tan(value), ctg.calcDouble(value), accuracy);
    }
}
