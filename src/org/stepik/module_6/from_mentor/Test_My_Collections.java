package org.stepik.module_6.from_mentor;

import java.util.ArrayList;

public class Test_My_Collections {
    public static void main(String[] args) {
        ArrayList_v2<Integer> list = new ArrayList_v2<>();
        for (int i = 0; i < 100; i++) {
            list.add(Integer.valueOf(i));
        }


        list.remove(0);
        list.remove(20);
        for (int i = 0; i < 100; i++) {
            System.out.println(list.get(i));
        }
        ArrayList<Integer> list_std = new ArrayList<>();
    }
}
