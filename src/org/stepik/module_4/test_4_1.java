package org.stepik.module_4;

import java.util.Optional;

public class test_4_1 {

    public static void main(String[] args) {
        Optional<String> str = Optional.of("foo");
        str.ifPresent(System.out::println);
        System.exit(0);

        System.out.println(sqrt(2));
        System.out.println(sqrt(-2));
    }

    public static double sqrt(double x) {
        if ( x < 0)
            throw new IllegalArgumentException ( "Expected non-negative number, got " + x);
        return  Math.sqrt(x); // your implementation here
    }
}
