package MODERNJAVA.PART1.TESTFINAL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class SupplierExample {

    public static <T> Object createObject(Supplier<T> supplier) {
        return supplier.get();
    }

    public static boolean verify(BooleanSupplier booleanSupplier) {
        if(booleanSupplier.getAsBoolean())
            return true;
        else
            return false;
    }

    public static Double calculate(DoubleSupplier doubleSupplier){
        return doubleSupplier.getAsDouble();
    }

    public static void main(String[] args) {


        /**
         * SUPPLIER IT IS A FUNCTIONAL INTERFACE WHICH HOLD JUST A METHOD (GET) AND RETURN THE OBJECT SPECIFIED
         * WITHIN OPERATOR DIAMOND
         */
        String value = (String) SupplierExample.createObject(String::new);
        Map<Integer, String> map = (Map<Integer, String>)SupplierExample.createObject(HashMap<Integer, String>::new);
        map.put(1, "John");
        System.out.println(map);

        /**
         *  BOOLEANSUPPLIER IT IS A FUNCTIONAL INTERFACE WHICH DOES NOT RECEIVE ARGUMENT AND EVALUATE A DETERMINE VALUE
         *  AND RETURN A BOOLEAN VALUE
         */
        BooleanSupplier booleanSupplier = () -> map.entrySet().isEmpty();
        System.out.println(booleanSupplier.getAsBoolean());

        Predicate<Map> predicate = Map::isEmpty;
        System.out.println(predicate.test(map));

        System.out.println(SupplierExample.verify(map::isEmpty));

        /**
         * INTSUPPLIER IT IS A FUNCTIONAL INTERFACE, DOES NOT RECEIVE ARGUMENTS, HOWEVER
         * RETURN A INT
         */
        List<Integer> list3 = Arrays.asList(12,45,43,56,789,456);
        IntSupplier intSupplier = () -> list3.stream().mapToInt(x->x).sum() / list3.size();
        System.out.println(intSupplier.getAsInt());

        /**
         * DOUBLE SUPPLIER IT'S A FUNCTIONAL INTERFACE WHICH DOESN'T RECEIVE ARGUMENTS, BUT RETURN A DOUBLE VALUE.
         */
        List<Double> list4 = Arrays.asList(12.5,45.8,78.0,45.5,75.4);
        System.out.println(SupplierExample.calculate(() -> list4.stream().mapToDouble(x->x).sum() / list4.size()));

        Map<Long, String> exampleMap = new HashMap<>();
        exampleMap.put(5L, "John Jairo");
        exampleMap.put(10L, "July Mora");

        /**
         * LONGSUPPLIER IT'S A FUNCTIONAL INTERFACE THAT RETURN A LONG VALUE BUT DOESN'T RECEIVE ARGUMENTS
         */
        LongSupplier longSupplier = () -> exampleMap.keySet().stream().mapToLong(x->x).sum();
        System.out.println(longSupplier.getAsLong());




    }
}
