package org.stepik.module_5_3_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double summ = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            if ( scanner.hasNextDouble() ){
                summ += scanner.nextDouble();
            } else {
                scanner.next();
            }
        }
        System.out.printf("%.6f", summ);
    }

}
