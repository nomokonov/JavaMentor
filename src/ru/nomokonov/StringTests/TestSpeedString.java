package ru.nomokonov.StringTests;

public class TestSpeedString {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); //Заценим скорость в мс для Нано nanoTime();

        StringBuilder s = new StringBuilder("1");
        System.out.println(System.currentTimeMillis());
        for(int i=0; i<100000; i++) {
            s.append("" + i);
        }
        long time = System.currentTimeMillis() - startTime;
        System.out.println("Runtime ms "+time);

        System.out.println(" now use StrinBuffer");
        startTime = System.currentTimeMillis();
        StringBuffer strbuff = new StringBuffer("1");
        for(int i=0; i<100000; i++) {
            strbuff.append("" + i);
        }
        time = System.currentTimeMillis() - startTime;
        System.out.println("Runtime ms "+time);


        System.out.println(" now feel the difference");

        startTime = System.currentTimeMillis();
        String str = "1";
        for(int i=0; i<100000; i++) {
            str += "" + i;
        }
        time = System.currentTimeMillis() - startTime;
        System.out.println("Runtime ms "+time);

    }

}
