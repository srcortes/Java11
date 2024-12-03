package PROJECTOEULER;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Fibonacci {
    static Integer a = 1;
    static Integer b = 2;
    static Integer c = 0;

    static Integer sum = 0;

    public static void changeValue(Integer value, Consumer<Integer> consumer) {
        consumer.accept(value);
    }

    public static void main(String[] args) {
        while (c < 4000000) {
            Predicate<Integer> isEvenNumber = (val) -> val % 2 == 0;
            BiFunction<Integer, Integer, Integer> sumNumber = Integer::sum;
            c = sumNumber.apply(a, b);
            Fibonacci.changeValue(b, val2 -> a = val2);
            Fibonacci.changeValue(c, val2 -> b = val2);

            if (isEvenNumber.test(a)) {
                Fibonacci.changeValue(a, val -> sum += val);
            }
        }
        Consumer<Object> sumPar = System.out::println;
        sumPar.accept(sum);
    }
}
