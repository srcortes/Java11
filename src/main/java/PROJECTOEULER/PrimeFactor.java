package PROJECTOEULER;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PrimeFactor {

    static LinkedList<Integer> list = new LinkedList<>();

    public static boolean isPrime(Integer value, IntPredicate intPredicate){
       return intPredicate.test(value);
    }

    public static void verifyList(Integer number){
        list.removeIf(val -> number %  val == 0);

    }

    public static void main(String[] args) {

        IntPredicate isDivisibleBySame = val -> (val % val == 0);
        IntPredicate isDivisibleByUnit = isDivisibleBySame.and(val -> val % 1 == 0);
        IntPredicate isOtherDivisibleByTwo = isDivisibleByUnit.and(val -> val % 2 != 0);

        for(int j = 2; j < 10; j++) {
            boolean response = PrimeFactor.isPrime(j, isOtherDivisibleByTwo);
            if(response) {
                list.add(j);
                PrimeFactor.verifyList(j);
            }



        }


        System.out.println(list);






    }
}
