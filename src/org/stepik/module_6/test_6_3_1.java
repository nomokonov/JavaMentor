package src.org.stepik.module_6;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class test_6_3_1 {
    public static void main(String[] args) {
        Predicate<Object> condition = Objects::nonNull;
        Function<Object, Integer> ifTrue = obj -> 123;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        long starttime = System.nanoTime();
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(safeStringLength.apply("asd"));
        System.out.println(System.nanoTime() - starttime);
    }


    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return (x) -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);

    }

}
