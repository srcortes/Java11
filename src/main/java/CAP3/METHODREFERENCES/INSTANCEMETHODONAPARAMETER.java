package CAP3.METHODREFERENCES;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface Util{
  int test();
}

public class INSTANCEMETHODONAPARAMETER {



    public boolean testing(){

        return false;
    }


    public static void main(String[] args) {
        var j = "";
        Predicate<String> methodRef = String::isEmpty;
        System.out.println(methodRef.test(j));

        var h = "John Jairo";
        Function<String, Integer> function = String::length;
        Integer u = function.apply(h);
        System.out.println(u);


        Predicate<INSTANCEMETHODONAPARAMETER> f = INSTANCEMETHODONAPARAMETER::testing;
        Supplier<INSTANCEMETHODONAPARAMETER> getObject = INSTANCEMETHODONAPARAMETER::new;
        boolean hh = f.test(getObject.get());

        Function<INSTANCEMETHODONAPARAMETER, Boolean> a = INSTANCEMETHODONAPARAMETER::testing;
        boolean hh1 = a.apply(getObject.get());

        System.out.println(hh+" - "+ hh1);




    }
}
