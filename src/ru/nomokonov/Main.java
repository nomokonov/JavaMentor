package ru.nomokonov;

import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //test 2.4.3
        String[] roles ={
        "Городничий", "Аммос Федорович", "Артемий Филиппович",
        "Лука Лукич"};
        String[] testLines = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
        "Аммос Федорович: Как ревизор?", "Артемий Филиппович: Как ревизор?",
        "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
        "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println(printTextPerRole(roles,testLines));
        System.exit(0);
        //test 2.4.2
        int[] a1 = {0,1,2,2,5,9,10};
        int[] a2 = {2,3,5,11,12};
        System.out.println(Arrays.toString(mergeArrays(a1,a2)));
        System.exit(0);
        //test 2.4.1
        System.out.println(factorial(10));

        //test 2.3.1
        System.out.println(isPalindrome("Madam, I'm Adam!"));
        System.exit(0);
        //test 2.2.2
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(-2));
        System.out.println('A'+"12");
        System.out.println("A"+12);
        System.out.println( "A" + ('\t' + '\u0003') );
        //test 2.2.1

        System.out.println(charExpression(32));
        System.out.println(charExpression(29));

        //test flipBit
        int a = 25;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(flipBit(a,1)));
        System.out.format("%,.2f%n",360e6);
        System.exit(0);
        //test doubleExpression
        System.out.println(doubleExpression(0.1,0.1,0.3));

   //test  for  leapYearCount
        System.out.println(leapYearCount(10));
        System.out.println(leapYearCount(2014));
        System.out.println(leapYearCount(2018));
        System.out.println(0.1f+0.1f+0.1f+0.1f+0.1f+0.1f+0.1f+0.1f+0.1f+0.1f);

//test booleanExpression
        boolean b0, b1, b2, b3;  ///   b3b2b1b0

        for (int i = 0; i < 16; i++) {
            if ((0b00000001 & i) > 0) b0 = true;
            else b0 = false;
            if ((0b00000010 & i) > 0) b1 = true;
            else b1 = false;
            if ((0b00000100 & i) > 0) b2 = true;
            else b2 = false;
            if ((0b00001000 & i) > 0) b3 = true;
            else b3 = false;
            System.out.println(i + ") Test for - "  +Integer.toBinaryString(i));
            System.out.println(booleanExpression(b3, b2, b1, b0));

        }

    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder res;
        res =new StringBuilder();
        for (int i = 0; i < roles.length; i++) {
            res.append(roles[i]);
            res.append(":\n");
            for (int j = 0; j < textLines.length; j++) {
                if ( textLines[j].startsWith(roles[i]+":")){
                    res.append(j+1);
                    res.append(")");
                    res.append(textLines[j].replaceFirst(roles[i]+":",""));
                    res.append("\n");
                }
            }
            res.append("\n");
        }
        return res.toString();
    }


    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] res = new int[a1.length+a2.length];
        boolean noStop = true;
        int c_a1, c_a2, c_res;
        c_a1 = c_a2 = c_res = 0;
        while (noStop){

            if (a1.length > c_a1 && a2.length > c_a2){
                if ( a1[c_a1] < a2[c_a2]){
                    res[c_res] = a1[c_a1];
                    c_res++;
                    c_a1++;
                } else {
                    res[c_res] = a2[c_a2];
                    c_res++;
                    c_a2++;
                }
            }else{
                if (a1.length > c_a1){
                    res[c_res] = a1[c_a1];
                    c_res++;
                    c_a1++;
                }
                if (a2.length > c_a2){
                    res[c_res] = a2[c_a2];
                    c_res++;
                    c_a2++;
                }
            }
            if ( res.length <= c_res ) noStop = false;
        }
        return res; // your implementation here
    }


    public static BigInteger factorial(int value) {
        BigInteger res ;
        res = BigInteger.valueOf(1);
        for (int i = 1; i <= value; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
            return res; // your implementation here
    }

    public static boolean isPalindrome(String text) {
        String str = text.toLowerCase().replaceAll("[^a-z0-9]","");
        String str2 = new StringBuilder(str).reverse().toString();
        if (str2.equals(str))
                return true; // your implementation here
        else
            return false;
    }

    public static boolean isPowerOfTwo(int value) {
        int a = Math.abs(value);
        return (a <= 0) ? false : (a & (a-1)) == 0;
    }


    public static char charExpression(int a) {
        char s =  0x005C;//"\\".toCharArray()[0];

        return  (char)(s + a);
    }

    public static int flipBit(int value, int bitIndex) {
        return value ^ (1 << (bitIndex-1));
    }


    public static boolean doubleExpression(double a, double b, double c) {
        return (Math.abs((a + b) - c) < 1e-4) ? true : false;
    }

    public static int leapYearCount(int year) {

        return(year / 4) - (year / 100) + (year / 400);
    }

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        int res =0;
        if (a) res++;
        if (b) res++;
        if (c) res++;
        if (d) res++;
        return (res ==2) ? true : false;
    }

}




