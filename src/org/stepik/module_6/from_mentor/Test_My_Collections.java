package org.stepik.module_6.from_mentor;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test_My_Collections {
    public static void main(String[] args) {
//        System.out.println("Тест моего варианта листа");
//        long time = System.nanoTime();
//
//        ArrayList_v2<Integer> list = new ArrayList_v2<>();
//        for (int i = 0; i < 100; i++) {
//            list.add(Integer.valueOf(i));
//        }
//        list.remove(0);
//        list.remove(20);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        time = System.nanoTime() - time;
//        System.out.println("Обработка листа за  nano- "+ time);
//        System.out.println("Тест стандартного  листа");
//        time = System.nanoTime();
//        ArrayList<Integer> list_std = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            list_std.add(Integer.valueOf(i));
//        }
//        list_std.remove(0);
//        list_std.remove(20);
//        for (int i = 0; i < list_std.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        time = System.nanoTime() - time;
//        System.out.println("Обработка листа за  nano- "+ time);
//
//
        LinkedList_v2<Integer> linkedList_v2  = new LinkedList_v2<>();

        linkedList_v2.add(1);
        linkedList_v2.add(2);
        linkedList_v2.add(3);

        linkedList_v2.remove(1);

        for (int i = 0; i < linkedList_v2.size(); i++) {
            System.out.println(linkedList_v2.get(i));
        }

    }
}
