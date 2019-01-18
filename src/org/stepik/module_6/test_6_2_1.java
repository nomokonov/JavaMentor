package org.stepik.module_6;

import java.util.HashSet;
import java.util.Set;


public class test_6_2_1 {
    public static void main(String[] args) {
        Set<Integer> num1 = new HashSet<>();
        num1.add(3);
        num1.add(7);
        num1.add(9);

        HashSet<Integer> num2 = new HashSet<>();
        num2.add(5);
        num2.add(7);
        num2.add(12);

        Set<Integer> result = symmetricDifference(num1,num2);
        System.out.println(result);
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        HashSet<T> hashSet1 = new HashSet<>(set1);
        HashSet<T> hashSet2 = new HashSet<>(set2);
        hashSet1.removeAll(set2);
        hashSet2.removeAll(set1);
        hashSet1.addAll(hashSet2);
        return hashSet1;
    }
}
