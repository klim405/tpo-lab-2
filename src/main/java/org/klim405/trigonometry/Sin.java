package org.klim405.trigonometry;

import org.klim405.IterativeFunc;
import org.klim405.utils.CachedFactorial;
import org.klim405.utils.TrigonometricArgConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sin extends IterativeFunc {
    public Sin(int maxIterations, double accuracy) {
        super(maxIterations, accuracy);
    }

    public Sin(double accuracy) {
        super(accuracy);
    }

    public Sin() {
        super();
    }

    @Override
    public BigDecimal calc(BigDecimal x) {
        x = TrigonometricArgConverter.convert(x);
        BigDecimal sign, numerator, denominator;

        BigDecimal prev = null;
        BigDecimal res = BigDecimal.ZERO;
        for (int n = 1; nextStep(prev, res, n); n++) {
            prev = res;
            sign = BigDecimal.valueOf(Math.pow(-1, n-1));
            numerator = x.pow(2*n-1);
            denominator = CachedFactorial.calc(2*n-1);
            res = res.add(
                    sign.multiply(numerator.divide(denominator, RoundingMode.HALF_UP))
            );
        }
        return res;
    }
}
