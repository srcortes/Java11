package MODERNJAVA.PART1.TESTFINAL;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public class BinaryOperatorTesting {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> function = Integer::sum;
        System.out.println(function.apply(5,2));

        BinaryOperator<Integer> binaryOperator = Integer::sum;
        System.out.println(binaryOperator.apply(5,2));

        BinaryOperator<String> binaryOperator1
                = BinaryOperator.minBy(Comparator.comparingInt(String::length));
        System.out.println(binaryOperator1.apply("Johnssss", "Julys"));

        List<String> list = Arrays.asList("B", "A", "C");
        List<Integer> list1 = Arrays.asList(1890,25000);
        List<String> list2 =  list.stream().sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(list2);



        BinaryOperator<List<?>> binaryOperator2
                = BinaryOperator.minBy((val1, val2) -> val1.size() > val2.size()  ? 1 : (val1.size() == val2.size() ? 0 : -1 ));
        System.out.println("***" + binaryOperator2.apply(list, list1));

        IntBinaryOperator intBinaryOperator = (val1, val2) -> {
            if(val1 > val2)
                return val1;
            else
                return val2;
        };

        Iterator<Integer> iterator = list1.iterator();
        int outcome = 0;
        while(iterator.hasNext()){
            outcome = intBinaryOperator.applyAsInt(iterator.next(), iterator.next()+1);
        }
        System.out.println(outcome);





    }
}
