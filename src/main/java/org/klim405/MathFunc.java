package org.klim405;

import java.math.BigDecimal;

public interface MathFunc {
    BigDecimal calc(double x);
    BigDecimal calc(BigDecimal x);
    double calcDouble(double x);
    double calcDouble(BigDecimal x);
}
