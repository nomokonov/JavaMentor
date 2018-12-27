// 3.5.2
package org.stepik.module_3;

public class AsciiCharSequence implements CharSequence{
    private final  byte[] array;

    public AsciiCharSequence(byte[] array) {
            this.array = array;
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
        byte[] dest = new byte[end-start];
        System.arraycopy(array,start, dest,0,end-start);
        return   new AsciiCharSequence(dest);
    }

    @Override
    public String toString() {
        return new String(array);
    }
}
