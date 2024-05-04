package org.klim405;

import java.math.BigDecimal;

public abstract class IterativeFunc implements MathFunc {
    protected int maxIterations = 100;
    protected double accuracy;

    public IterativeFunc(int maxIterations, double accuracy) {
        this.maxIterations = maxIterations;
        this.accuracy = accuracy;
    }

    public IterativeFunc(double accuracy) {
        this.accuracy = accuracy;
    }

    public boolean nextStep(BigDecimal prev, BigDecimal current, int n) {
        if (prev == null) {
            return true;
        }
        return current.subtract(prev).abs().compareTo(BigDecimal.valueOf(accuracy)) >= 0
                && n <= maxIterations;
    }

    public IterativeFunc() {
        this.accuracy = 1E-5;
    }

    @Override
    public BigDecimal calc(double x) {
        return calc(BigDecimal.valueOf(x));
    }

    @Override
    public double calcDouble(double x) {
        return calcDouble(BigDecimal.valueOf(x));
    }

    @Override
    public double calcDouble(BigDecimal x) {
        return calc(x).doubleValue();
    }
}
