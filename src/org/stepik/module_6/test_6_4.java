package src.org.stepik.module_6;

import com.sun.javafx.scene.control.skin.LabeledImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class test_6_4 {
    public static void main(String[] args) {
        long startTimer = System.nanoTime();
        int x = 12345;
        System.out.println(x);
//        System.out.println(x / 10 % 10 );
//        System.out.println((x)/100 % 10);
//        System.out.println((x)/1000 % 10);
//
        System.out.println(x /= 10);
        System.out.println(x % 1000);
        System.out.println(x % 1000);


        System.out.println((x / 10) % 1000);
        IntStream is = pseudoRandomStream(13);
        is.forEach(System.out::println);


        System.out.println(System.nanoTime() - startTimer);

//
//        IntStream is1 = "1235".to();
//        is1.map((x)-> Integer.parseInt(Character.valueOf(x)));
//        is1.forEach(System.out::println);


    }

    //6.4.1
    // bad
//    public static IntStream pseudoRandomStream(int seed) {
//        IntStream is = IntStream.iterate(seed, (x) -> {
//
//            List<Integer> numbersArrays = new ArrayList<>();
//            for (int a = x * x; a > 0; a /= 10){
//                numbersArrays.add(a % 10);
//            }
//            int res = 0;
//            int count = 0;
//            Iterator<Integer> iter = numbersArrays.iterator();
//            if ( iter.hasNext() ) {
//                iter.next();
//            }
//            while (iter.hasNext() && count < 3) {
//                res += iter.next() * (Math.pow(10, count++));
//            }
//            return Integer.valueOf(res);
//        });
//
//        return is; // your implementation here
//    }

    // OR ACCEPT
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, x -> ((x * x) / 10) % 1000);
    }
}
