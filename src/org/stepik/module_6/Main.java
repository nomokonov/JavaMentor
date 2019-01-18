package org.stepik.module_6;

/*
Напишите программу, которая прочитает из System.in последовательность целых чисел,
 разделенных пробелами, затем удалит из них все числа, стоящие на четных позициях,
  и затем выведет получившуюся последовательность в обратном порядке в System.out.
Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.
В этом задании надо написать программу целиком, включая import'ы, декларацию класса Main и метода main.
Sample Input:
1 2 3 4 5 6 7
Sample Output:
6 4 2
*/


import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) {

        Deque<Integer> stack = new LinkedBlockingDeque<Integer>();
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                if ( (count++ & 1) !=0 ) {
                    stack.addFirst(scanner.nextInt());
                }
                else {
                    scanner.next();
                }
            } else {
                scanner.next();
            }
        }

        stack.forEach(x -> System.out.print(x + " "));
    }
}