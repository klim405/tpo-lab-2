package org.klim405;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FunctionSystemTest {
    @Test
    void testFunctionSystem() {
        FunctionSystem fs = new FunctionSystem();
        assertEquals(1.442, fs.calcDouble(0.3), 0.15);
        assertEquals(0, fs.calcDouble(-1.083), 0.15);
        assertEquals(1963, fs.calcDouble(1500), 2);
        assertEquals(1963, fs.calcDouble(1500), 2);
        assertEquals(7044.256, fs.calcDouble(23500), 2);
        assertEquals(-84.806, fs.calcDouble(-5.294), 1);
        assertEquals(-63.866, fs.calcDouble(-4.001), 0.001);
        assertEquals(-64.798, fs.calcDouble(-3.876), 0.001);
        assertEquals(-167.697, fs.calcDouble(-2.124), 0.001);
    }

    @ParameterizedTest(name = "f({0})")
    @DisplayName("Проверка точек разрыва косинуса")
    @ValueSource(doubles = {0.0, 1.0})
    void testPoints(double x) {
        FunctionSystem fs = new FunctionSystem();
        assertThrows(ArithmeticException.class, () -> fs.calcDouble(x));
    }
}
