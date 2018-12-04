package org.stepik;

public class test_2_2 {
    public static void main(String[] args) {
        //test 2.2.2
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(-2));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(4));
        System.out.println("****----------*********");
        //System.out.println(Integer.);
        //test 2.2.1
        System.out.println(charExpression(32));
        System.out.println(charExpression(29));
    }

    //test 2.2.2
    public static boolean isPowerOfTwo(int value) {
        int n = Math.abs(value);
        return (n > 0 && (n & (n - 1)) == 0);
    }
    //test 2.2.1
    public static char charExpression(int a) {
        return  (char)('\\' + a);
    }
}
