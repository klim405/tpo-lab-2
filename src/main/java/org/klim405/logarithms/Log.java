package org.klim405.logarithms;

import org.klim405.IterativeFunc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Log extends IterativeFunc {
    private final Ln ln;
    private final int n;

    public Log(int maxIterations, double accuracy, Ln ln, int n) {
        super(maxIterations, accuracy);
        this.ln = ln;
        this.n = n;
    }

    public Log(double accuracy, Ln ln, int n) {
        super(accuracy);
        this.ln = ln;
        this.n = n;
    }

    public Log(Ln ln, int n) {
        this.ln = ln;
        this.n = n;
    }

    public Log(int n) {
        this.ln = new Ln();
        this.n = n;
    }

    @Override
    public BigDecimal calc(BigDecimal x) {
        return ln.calc(x).divide(
                ln.calc(BigDecimal.valueOf(n)),
                RoundingMode.HALF_UP
        );
    }
}
