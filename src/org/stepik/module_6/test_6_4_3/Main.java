package src.org.stepik.module_6.test_6_4_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) {
        Comparator<Map.Entry<String, Integer>> c1 = Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder());
        Comparator<Map.Entry<String, Integer>> c2 = Comparator.comparing(Map.Entry::getKey);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        Stream<String> stream = bufferedReader.lines();
        stream.flatMap(x -> stream(x.split("\\W+")))
                .map(String::toLowerCase)

                .forEach(System.out::println);
    }
}
