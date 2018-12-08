// 3.5.2
package org.stepik;

import java.util.Arrays;

public class AsciiCharSequence implements CharSequence{
    private final  byte[] array;

    public AsciiCharSequence(byte[] array) {
        if ( array.length > 0 ) {
            this.array = Arrays.copyOf(array, array.length);
        } else this.array = new byte[0];
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public char charAt(int index) {
        return (char)array[index];
    }

    @Override
    public AsciiCharSequence subSequence(int start, int end) {
        return   new AsciiCharSequence(Arrays.copyOfRange(array,start,end));
    }

    @Override
    public String toString() {
        return new String(array);
    }
}
