package org.stepik.module_6;


import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> stack = new LinkedList<>();   // Связ список быстро удаляет вставляет а на основе массива по индексу быстро
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                stack.add(scanner.nextInt());
            } else {
                scanner.next();
            }
        }
        Iterator<Integer> iterator = stack.iterator();
        int count = 0;
        while (iterator.hasNext()){
            iterator.next();
            if ( (count++ & 1) ==0 ) {
                iterator.remove();
            }
        }
        Collections.reverse(stack);
        stack.forEach(x -> System.out.print(x + " "));
    }
}