package org.klim405.utils;

import java.math.BigDecimal;

public class TrigonometricArgConverter {
    private final static BigDecimal PI2 = BigDecimal.valueOf(Math.PI * 2);

    public static BigDecimal convert(BigDecimal arg) {
        if (arg.compareTo(PI2) > 0) {
            while (arg.compareTo(PI2) > 0) {
                arg = arg.subtract(PI2);
            }
        } else if (arg.compareTo(PI2.negate()) < 0){
            while (arg.compareTo(PI2.negate()) < 0) {
                arg = arg.add(PI2);
            }
        }
        return arg;
    }
}

