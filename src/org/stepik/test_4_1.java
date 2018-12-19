package org.stepik;

public class test_4_1 {

    public static void main(String[] args) {
        System.out.println(sqrt(2));
        System.out.println(sqrt(-2));
    }

    public static double sqrt(double x) {
        if ( x < 0)
            throw new IllegalArgumentException ( "Expected non-negative number, got " + x);
        return  Math.sqrt(x); // your implementation here
    }
}
