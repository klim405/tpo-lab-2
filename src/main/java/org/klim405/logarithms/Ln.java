package org.klim405.logarithms;

import org.klim405.IterativeFunc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ln extends IterativeFunc {
    public Ln(double accuracy) {
        super(accuracy);
    }

    public Ln() {
        super();
    }

    private BigDecimal calc1(BigDecimal x) {
        x = x.subtract(BigDecimal.ONE);
        BigDecimal sign, numerator, prev, res;

        prev = null;
        res = BigDecimal.ZERO;
        for (int n = 1; nextStep(prev, res, n); n++) {
            prev = res;
            sign = BigDecimal.valueOf(Math.pow(-1, n + 1));
            numerator = x.pow(n);
            res = res.add(
                    sign.multiply(numerator.divide(BigDecimal.valueOf(n), RoundingMode.HALF_UP))
            );
        }
        return res;
    }

    @Override
    public BigDecimal calc(BigDecimal x) {
        if (x.compareTo(BigDecimal.ONE) <= 0) {
            if (x.compareTo(BigDecimal.ZERO) <= 0) {
                return null;
            }
            return calc1(x);
        } else {
            return BigDecimal.valueOf(Math.log(x.doubleValue()));
        }
    }

    @Override
    public double calcDouble(BigDecimal x) {
        BigDecimal res = calc(x);
        return res != null ? res.doubleValue() : Double.NEGATIVE_INFINITY;
    }
}
