package org.klim405.trigonometry;

import org.klim405.IterativeFunc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ctg extends IterativeFunc {
    private final Sin sin;
    private final Cos cos;

    public Ctg(int maxIterations, double accuracy) {
        super(maxIterations, accuracy);
        sin = new Sin(maxIterations, accuracy);
        cos = new Cos(maxIterations, accuracy);
    }

    public Ctg(double accuracy) {
        super(accuracy);
        sin = new Sin(accuracy);
        cos = new Cos(accuracy);
    }

    public Ctg() {
        super();
        sin = new Sin();
        cos = new Cos();
    }

    public Ctg(Sin sin, Cos cos) {
        super();
        this.sin = sin;
        this.cos = cos;
    }

    @Override
    public BigDecimal calc(BigDecimal x) {
        return cos.calc(x).divide(sin.calc(x), RoundingMode.HALF_UP);
    }
}
