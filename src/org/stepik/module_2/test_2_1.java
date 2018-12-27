package org.stepik.module_2;

public class test_2_1 {
    public static void main(String[] args) {
// 2.1.1 test booleanExpression
        boolean b0, b1, b2, b3;  ///   b3b2b1b0
        System.out.println("2.1.1");
        for (int i = 0; i < 16; i++) {
            if ((0b00000001 & i) > 0) b0 = true;
            else b0 = false;
            if ((0b00000010 & i) > 0) b1 = true;
            else b1 = false;
            if ((0b00000100 & i) > 0) b2 = true;
            else b2 = false;
            if ((0b00001000 & i) > 0) b3 = true;
            else b3 = false;
            System.out.println(i + ") Test for - " + Integer.toBinaryString(i));
            System.out.println(booleanExpression(b3, b2, b1, b0));
        }

 // 2.1.2
        //test  for  leapYearCount
        System.out.println("2.1.2");
        System.out.println(leapYearCount(10));
        System.out.println(leapYearCount(2014));
        System.out.println(leapYearCount(2018));
// 2.1.3

        //test doubleExpression
        System.out.println("2.1.3");
        System.out.println(doubleExpression(0.1,0.1,0.3));
        // 2.1.4
        //test flipBit
        int a = 25;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(flipBit(a,1)));
    }
    // 2.1.1
    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return ((a ^ b) & (c ^ d)) || ((a ^ c) & (b ^ d));
    }
    // 2.1.2
    public static int leapYearCount(int year) {
        return(year / 4) - (year / 100) + (year / 400);
    }
    // 2.1.3
    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs((a + b) - c) < 1e-4 ;
    }
    // 2.1.4
    public static int flipBit(int value, int bitIndex) {
        return value ^ (1 << (bitIndex-1));
    }

}
