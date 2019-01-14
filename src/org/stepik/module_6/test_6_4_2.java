package src.org.stepik.module_6;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class test_6_4_2 {
    public static void main(String[] args) {


    }

//    public static <T> void findMinMax(
//            Stream<? extends T> stream,
//            Comparator<? super T> order,
//            BiConsumer<? super T, ? super T> minMaxConsumer) {
//
//        Object[] obj = stream.sorted(order).toArray();
//
//        if (obj.length == 0) {
//            minMaxConsumer.accept(null, null);
//        } else {
//            minMaxConsumer.accept((T) obj[0], (T) obj[obj.length - 1]);
//        }
//    }

    //  А ТАК НАДО БЫЛО - КРУТЯК
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        class FindFirstLast implements Consumer<T> {
            T first;
            T last;

            public FindFirstLast() {
                first = null;
                last = null;
            }

            @Override
            public void accept(T t) {
                if (first == null) {
                    first = t;
                }
                last = t;
            }

            public T getFirst() {
                return first;
            }

            public T getLast() {
                return last;
            }

        }
        FindFirstLast findFirstLast = new FindFirstLast();
        stream.sorted(order).forEach(findFirstLast);
        minMaxConsumer.accept(findFirstLast.getFirst(), findFirstLast.getLast());
    }
}
