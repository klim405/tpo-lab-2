package org.klim405.trigonometry;

import org.klim405.IterativeFunc;

import java.math.BigDecimal;

public class Sec extends IterativeFunc  {
    private final Cos cos;

    public Sec(int maxIterations, double accuracy, Cos cos) {
        super(maxIterations, accuracy);
        this.cos = cos;
    }

    public Sec(double accuracy, Cos cos) {
        super(accuracy);
        this.cos = cos;
    }

    public Sec(Cos cos) {
        this.cos = cos;
    }

    @Override
    public BigDecimal calc(BigDecimal x) {
        return BigDecimal.valueOf(1 / cos.calcDouble(x));
    }
}
