package FIT;

import com.sun.jdi.IntegerValue;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NewFitGlobant {

    static List<String> words =
            List.of("Hello", "Hello", "Piece", "Bad", "Bad", "Bad", "John");


    public static void print(Map map, Consumer<Map> consumer) {
        consumer.accept(map);
    }


    public static void countWords(List<String> list) {
        String a = "";

        Map<String, Long> counted = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        print(counted, System.out::println);
    }



    public static void main(String[] args) {

        NewFitGlobant.countWords(words);

    }
}
