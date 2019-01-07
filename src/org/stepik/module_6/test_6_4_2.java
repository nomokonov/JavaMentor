package src.org.stepik.module_6;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class test_6_4_2 {
    public static void main(String[] args) {



    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
//        stream.sorted(order);
        Object[] obj = stream.sorted(order).toArray();

        if (obj.length == 0) {
            minMaxConsumer.accept( null, null);
        } else {
            T min = (T) obj[0];
            T max = (T) obj[obj.length - 1];

            minMaxConsumer.accept(min, max);
        }
    }
}
