package CAP3.METHODREFERENCES;

import java.util.Arrays;
import java.util.function.*;

@FunctionalInterface
interface VerifyString{
    boolean startString(String value);
}

@FunctionalInterface
interface Operation{
    int suma(int g, int h);
}

@FunctionalInterface
interface OperationV1{
    void sumValue(int...h);
}

public class INSTANCEMETHODPARTICULAROBJECT {

    public int sumarNumeros(int a, int b){
        return a + b;
    }

    public void valuesSum(int... h){
        System.out.println(Arrays.toString(h));
    }


    public static void main(String[] args) {
        var str = "John Jairo";
        var lastName = " Rodriguez Cortes";

        Predicate<String> testUno = str::startsWith;
        boolean uno = testUno.test("J");

        Predicate<String> testDos = i-> str.startsWith(i);
        boolean dos = testDos.test("H");

        VerifyString v = str::startsWith;
        boolean tres = v.startString("J");

        System.out.println(uno+" - "+ dos + " - "+ tres);

        Function<String, String> function = str::concat;
        String j = function.apply(lastName);

        System.out.println(j);

        Supplier<INSTANCEMETHODPARTICULAROBJECT> supplier = INSTANCEMETHODPARTICULAROBJECT::new;
        INSTANCEMETHODPARTICULAROBJECT object = supplier.get();

        Operation p = object::sumarNumeros;
        int sum = p.suma(10,200);

        BiFunction<Integer, Integer, Integer> function1 = object::sumarNumeros;/*(x, y)-> object.sumarNumeros(x, y);*/
        int sum2 = function1.apply(10, 210);

        System.out.println(sum + " - " + sum2);

        OperationV1 operationV1 = object::valuesSum;
        BiConsumer<Integer, Integer> biConsumer = object::valuesSum;
        biConsumer.accept(2,8);
        /*operationV1.sumValue(2,4);*/


    }


}
