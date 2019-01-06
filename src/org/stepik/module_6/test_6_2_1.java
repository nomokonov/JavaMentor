package org.stepik.module_6;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.ObjDoubleConsumer;


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
        HashSet<T> hastSet1 = new HashSet<>();
        HashSet<T> hastSet2 = new HashSet<>();
        HashSet<T> intersectionSet = new HashSet<>();
        hastSet1.addAll(set1);
        hastSet2.addAll(set2);
        intersectionSet.addAll(set1);
        intersectionSet.retainAll(hastSet2); //Оставим только пересечение множеств и "отнимем" из исходных сетов
        hastSet1.removeAll(intersectionSet);
        hastSet2.removeAll(intersectionSet);
        intersectionSet.clear();
        intersectionSet.addAll(hastSet1);
        intersectionSet.addAll(hastSet2);
        return intersectionSet;
    }
}
