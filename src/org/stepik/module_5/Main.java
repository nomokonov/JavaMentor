package org.stepik.module_5;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {

    static String WIN1251 = "windows-1251";
    static String UTF8 = "UTF-8";

    public static void main(String[] args) throws IOException {
        boolean notStop = true;

        int buffer = -1;


        byte[] arr = {65, 66, 13, 13, 10, 10, 13, 67, 13, 13};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(arr);
        System.setIn(inputStream);

        try {
            while (notStop) {
                int data = System.in.read();
               if ( buffer == 13 && data == 10 ){
                   System.out.write(10);
                   outputStream.write(10);
                   buffer = -1;
               } else {
                   if ( buffer > 0 ){
                       System.out.write(buffer);
                       outputStream.write(buffer);
                   }

                   buffer = data;
               }

               if ( data < 0 ) {
                   notStop = false;
               }
            }

        } catch (IOException e){

        }
        System.out.println(Arrays.toString(outputStream.toByteArray()));
        System.out.flush();

        byte[] code = "Ы".getBytes(UTF8);
        for (byte b: code){
            System.out.print(Byte.toUnsignedInt(b) + " ");
        }
        System.out.println(Arrays.toString(code));

        System.out.println(System.getProperty("file.encoding"));
        String g2 = "привет пока";
        System.out.println("standart: " + g2);
        System.out.println("UTF8 " + new String(g2.getBytes(UTF8)));
        System.out.println("win1251 " + new String(g2.getBytes(WIN1251)));
        System.out.println("UTF8->win1251 " + new String(g2.getBytes(UTF8), WIN1251));
        System.out.println("win1251->UTF8 " + new String(g2.getBytes(WIN1251), UTF8));

//5.2
        String s = "Админnns";
        byte[] bytes = s.getBytes("US-ASCII");

        OutputStream outStream = System.out;
        Writer writer = new OutputStreamWriter(outStream, StandardCharsets.US_ASCII);
        writer.write("Ы");
        writer.flush();
//Test 5.2.1

    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        return stringBuffer.toString();
    }
}

