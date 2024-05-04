package org.klim405;

import org.klim405.logarithms.Ln;
import org.klim405.logarithms.Log;
import org.klim405.trigonometry.Cos;
import org.klim405.trigonometry.Ctg;
import org.klim405.trigonometry.Sec;
import org.klim405.trigonometry.Sin;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FunctionSystem implements MathFunc {
    private final Cos cos;
    private final Sin sin;
    private final Sec sec;
    private final Ctg ctg;
    private final Log log3;
    private final Log log10;
    private final Ln ln;

    public FunctionSystem(Cos cos, Sin sin, Sec sec, Ctg ctg, Log log3, Log log10, Ln ln) {
        this.cos = cos;
        this.sin = sin;
        this.sec = sec;
        this.ctg = ctg;
        this.log3 = log3;
        this.log10 = log10;
        this.ln = ln;
    }

    public FunctionSystem() {
        this.cos = new Cos();
        this.sin = new Sin();
        this.sec = new Sec(new Cos());
        this.ctg = new Ctg(new Sin(), new Cos());
        this.log3 = new Log(3);
        this.log10 = new Log(10);
        this.ln = new Ln();
    }

    @Override
    public BigDecimal calc(BigDecimal x) {
        if (x.compareTo(BigDecimal.ZERO) <= 0) {
//            x <= 0 : ((
//            ( [(sec(x)+cos(x)) ^ 3]
//                  * cot(x)) ^ 2)
//                  * (cos(x) -
//                  ((sin(x) + cos(x)) / sin(x)))
//                  )
            return sec.calc(x).add(cos.calc(x)).pow(3).multiply(
                    ctg.calc(x)).pow(2).multiply(
                            cos.calc(x).subtract(
                                    sin.calc(x).add(cos.calc(x)).divide(sin.calc(x), RoundingMode.HALF_UP)
                            )
            );
        } else {
//            x > 0: ((
//            ((
//            (log_10(x) / log_3(x))
//            ^ 2) ^ 2)
//            * (
//            log_3(x) * (ln(x) / log_10(x)))
//            ) + ((log_3(x) ^ 2) ^ 2))
            return log10.calc(x).divide(log3.calc(x), RoundingMode.HALF_UP)
                    .pow(2).pow(2)
                    .multiply(
                            log3.calc(x).multiply(
                                    ln.calc(x).divide(log10.calc(x), RoundingMode.HALF_UP)
                            )
                    ).add(
                            log3.calc(x).pow(2).pow(2)
                    );
        }
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
