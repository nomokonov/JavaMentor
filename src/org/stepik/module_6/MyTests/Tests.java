package org.stepik.module_6.MyTests;

import java.io.BufferedReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Tests {

    public static void main(String[] args) {
        Scanner  scanner =  new Scanner(System.in);
        int i  = scanner.nextInt();
        System.out.println(factorial(i));
    }

    public static BigInteger factorial ( int n){
        return   IntStream.rangeClosed( 1, n )
                .mapToObj( i -> BigInteger.valueOf(i))
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }

}
