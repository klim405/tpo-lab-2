package org.klim405.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CachedFactorial {
    private static final List<BigDecimal> factorials = new ArrayList<>(
            Arrays.asList(BigDecimal.ONE, BigDecimal.ONE)
    );

    public static BigDecimal calc(int n) {
        int lastN = factorials.size() - 1;
        BigDecimal lastValue = factorials.get(lastN);
        while (lastN < n) {
            lastValue = lastValue.multiply(BigDecimal.valueOf(++lastN));
            factorials.add(lastValue);
        }

        return factorials.get(n);
    }
}
