package org.klim405;

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
}
