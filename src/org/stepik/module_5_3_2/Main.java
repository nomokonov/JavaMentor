package org.stepik.module_5_3_2;

import java.nio.channels.Channel;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        String subStr;
        double summ = 0;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            subStr = scanner.next();
            try {
                summ += Double.parseDouble(subStr);
            } catch (NumberFormatException e) {
                //ignore
            }
        }
        System.out.printf("%.6f", summ);
    }

}
