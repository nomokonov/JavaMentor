package org.stepik;

import java.math.BigInteger;
import java.util.Arrays;

public class test_2_4 {
    public static void main(String[] args) {
        //test 2.4.3
        String[] roles = {
                "Городничий", "Аммос Федорович", "Артемий Филиппович",
                "Лука Лукич"};
        String[] testLines = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?", "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println(printTextPerRole(roles, testLines));
        //test 2.4.2
        System.out.println("//test 2.4.2");
        int[] a1 = {0, 1, 2, 2, 5, 9, 10};
        int[] a2 = {2, 3, 5, 11, 12};
        System.out.println(Arrays.toString(mergeArrays(a1, a2)));

        //test 2.4.1
        System.out.println("test 2.4.1");
        System.out.println(Integer.MAX_VALUE);
        System.out.println("10! = "+ factorial(10));
        System.out.println("17! = "+ factorial(17));
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder res;
        res = new StringBuilder();
        for (int i = 0; i < roles.length; i++) {
            res.append(roles[i]);
            res.append(":\n");
            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].startsWith(roles[i] + ":")) {
                    res.append(j + 1);
                    res.append(")");
                    res.append(textLines[j].replaceFirst(roles[i] + ":", ""));
                    res.append("\n");
                }
            }
            res.append("\n");
        }
        return res.toString();
    }


    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] res = new int[a1.length + a2.length];
        int c_a1, c_a2, c_res;
        c_a1 = c_a2 = c_res = 0;
        while (c_res < res.length) {

            if (a1.length > c_a1 && a2.length > c_a2) {
                if (a1[c_a1] < a2[c_a2]) {
                    res[c_res] = a1[c_a1];
                    c_res++;
                    c_a1++;
                } else {
                    res[c_res] = a2[c_a2];
                    c_res++;
                    c_a2++;
                }
            } else {
                if (a1.length > c_a1) {
                    res[c_res] = a1[c_a1];
                    c_res++;
                    c_a1++;
                }
                if (a2.length > c_a2) {
                    res[c_res] = a2[c_a2];
                    c_res++;
                    c_a2++;
                }
            }
        }
        return res;
    }

// Нужно решить рекурсией
//    public static BigInteger factorial(int value) {
//        BigInteger res;
//        res = BigInteger.valueOf(1);
//        for (int i = 1; i <= value; i++) {
//            res = res.multiply(BigInteger.valueOf(i));
//        }
//        return res;
//    }


    public static BigInteger factorial(int value){
        if (  value ==1 )  return BigInteger.ONE;
        BigInteger n = BigInteger.valueOf(value);
        return   n.multiply ( factorial(value-1) );
    }
//    public static BigInteger factorial(int value){
//        BigInteger n = BigInteger.valueOf(value);
//        if (  n.equals(BigInteger.ONE))  return BigInteger.ONE;
//        return   n.multiply (Fact2(n.subtract(BigInteger.ONE)));
//    }
//    public static BigInteger Fact2(BigInteger value) {
//        if (  value.equals(BigInteger.ONE))  return BigInteger.ONE;
//        return   value.multiply (Fact2(value.subtract(BigInteger.ONE)));
//    }

//    public static int factorial(int value){
//        if (  value==1)  return 1;
//        return   value * (factorial(value-1));
//    }

}
