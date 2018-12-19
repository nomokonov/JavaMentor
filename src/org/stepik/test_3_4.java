package org.stepik;

import java.math.BigDecimal;

public class test_3_4 {

    public static void main(String[] args) {
        ClassExample Ce = new ClassExample(10);
        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);

        System.out.println(a.equals(b));
        System.out.println(a.hashCode());

        Timer timer = new Timer();
        long time = timer.measureTime(() -> new BigDecimal("1234567").pow(10000));
        System.out.println(time);
    }
}

final class ComplexNumber {

    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( o == null) return false;
        if ( getClass() != o.getClass()) return false;

        ComplexNumber objNum = (ComplexNumber) o;
        if (Double.compare(objNum.re, re) == 0 &&
                Double.compare(objNum.im, im) == 0)  return true;
        else return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        long result = 1;
        result = prime * result +  Double.doubleToRawLongBits(re);
        result = prime * result + Double.doubleToRawLongBits(im);
        return (int)(result ^ (result >>> 32));
    }
}

class Timer {
    public long measureTime (Runnable runnable) {
        long startTime = System.currentTimeMillis();
        runnable.run();
        return System.currentTimeMillis() - startTime;
    }


}