package org.stepik;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class CodePageOutPrint {
    public static void main(String[] args ) throws UnsupportedEncodingException {
        String x = "Привет, мир!!!"; //Это строка, которую мы будем выводить на экран
        System.out.println(x);
        PrintStream printStream = new PrintStream(System.out, true, "UTF8");
        printStream.println(x);
    }
}
