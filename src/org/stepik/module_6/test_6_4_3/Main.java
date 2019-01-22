package src.org.stepik.module_6.test_6_4_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

//        Comparator<Map.Entry<String, Long>> c1 = Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder());
//        Comparator<Map.Entry<String, Long>> c2 = Comparator.comparing(Map.Entry::getKey);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        Stream<String> stream = bufferedReader.lines();
        stream
                .map(x -> x.split("[^a-zA-Zа-яА-Я0-9']+"))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
//                .sorted(c1.thenComparing(c2))  // так всетаки красивее
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(o -> o.getKey())
                .limit(10)
                .forEach(System.out::println);


//        Comparator<Map.Entry<String, Integer>> c1 = Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder());
//        Comparator<Map.Entry<String, Integer>> c2 = Comparator.comparing(Map.Entry::getKey);
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        Stream<String> stream = in.lines();
//        stream.flatMap(x -> Arrays.stream(x.split("\\W+")))
//                .map(String::toLowerCase)

//                .collect(Collectors.groupingBy(x -> x, Collectors.summingInt(p -> 1)))
//                .entrySet()
//                .stream()
//                .sorted(c1.thenComparing(c2))
//                .map(x -> x.getKey())
//                .limit(10)
//                .forEach(System.out::println);
    }
}
