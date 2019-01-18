package org.stepik;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> listInt = Arrays.asList(1,2,3);
        Test1 test1 = new Test1();
        test1.func1(listInt);
    }
    static class Test1<T> {
        void func1 (Collection<T> collection){
            for (T item : collection) {
                System.out.println(item);
            }
        }

        void func1 (List<String> list) {
            for (String item : list) {
                System.out.println(item);
            }
        }
    }
}
