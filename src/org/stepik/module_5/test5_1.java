package org.stepik.module_5;

import java.io.IOException;
import java.io.InputStream;

public class test5_1 {
    public static void main(String[] args) {

    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int result = 0;
        int data ;
                while ( (data = inputStream.read()) > 0 ){
            result  = Integer.rotateLeft(result,1) ^ data;
        }
        return result;
    }
}
