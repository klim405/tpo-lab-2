package org.klim405.logarithms;

import org.klim405.IterativeFunc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ln extends IterativeFunc {
    @Override
    public BigDecimal calc(BigDecimal x) {
        x = x.subtract(BigDecimal.ONE);
        BigDecimal sign, numerator, prev, res;

        numerator = BigDecimal.ONE;
        prev = null;
        res = BigDecimal.ZERO;
        for (int n = 1; nextStep(prev, res, n); n++) {
            prev = res;
            sign = BigDecimal.valueOf(Math.pow(-1, n));
            numerator = numerator.multiply(x);
            res = res.add(
                    sign.multiply(numerator.divide(BigDecimal.valueOf(n), RoundingMode.HALF_UP))
            );
        }
        return res;
    }
}
