package PROJECTOEULER;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;


@FunctionalInterface
interface TriPredicate<A, B, C> {
    boolean test(A a, B b, C c);
}


public class Multiple3or5 {

    static int[] values = {3, 5};
    static List<Integer> newList = new ArrayList<>();

    public static boolean isMultiplo(int value1, int value2, int value3,
                                     TriPredicate<Integer, Integer, Integer> biPredicate) {
        return biPredicate.test(value1, value2, value3);
    }

    public static void fillOutList(Integer value, Consumer<Integer> consumer) {
        consumer.accept(value);
    }

    public static void printInfo(Object obj, Consumer<Object> consumer) {
        consumer.accept(obj);
    }

    public static void finalList(int value) {
        for (int i = 0; i < values.length - 1; i++) {
            boolean isMultiplo = Multiple3or5.isMultiplo(value, values[i], values[i + 1],
                    (val1, val2, val3) -> val1 % val2 == 0 || val1 % val3 == 0);
            if (isMultiplo)
                fillOutList(value, (val) -> newList.add(val));
        }
    }

    public static void main(String[] args) {
        IntStream stream = IntStream.range(1, 1000);
        stream.forEach(Multiple3or5::finalList);
        Multiple3or5.printInfo(newList.stream().mapToLong(v -> v).sum(), System.out::println);
    }
}
