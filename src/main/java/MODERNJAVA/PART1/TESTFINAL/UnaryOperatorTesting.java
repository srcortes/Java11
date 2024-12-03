package MODERNJAVA.PART1.TESTFINAL;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorTesting {

    public static void main(String[] args) {
        String name = "John Jairo";

        /**
         * UNARYOPERATOR IS A FUNCTIONAL INTERFACE, THAT EXTENDS TO FUNCTION,
         * IN ORDER TO BE SPECIFIC HERE LET'S A EXAMPLE
         */
        Function<String, String> function = String::toUpperCase;
        System.out.println(function.apply(name));

        UnaryOperator<String> unaryOperator = String::toUpperCase;
        System.out.println(unaryOperator.apply(name));

        UnaryOperator<String> unaryOperator1 = val -> val.toUpperCase().charAt(0) + (val.substring(1, val.length() -1));
        System.out.println(unaryOperator1.apply(name));

        /**
         * INTUNARYOPERATOR / LONGUNARYOPERATOR / DOUBLEUNARYOPERATOR PERFORM THE SAME OPERATION BUT RETURN
         * DIFFERENTS VALUES, NONE RECEIVE A PARAMETERS
         */
        IntUnaryOperator intUnaryOperator = gettingIntoValue -> gettingIntoValue * 12;
        IntUnaryOperator intUnaryOperator1 = value -> value / 10;
        IntUnaryOperator intUnaryOperator2 = value -> value * 100;
        int outcome = intUnaryOperator.andThen(intUnaryOperator1).compose(intUnaryOperator2).applyAsInt(5);
        System.out.println(outcome);

        List<Integer> list = Arrays.asList(1);
        IntUnaryOperator intUnaryOperator3 = IntUnaryOperator.identity();
        System.out.println(1 == intUnaryOperator3.applyAsInt(list.get(0)));
    }
}
