package MODERNJAVA.PART1.TESTFINAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

@FunctionalInterface
interface TriPredicate<A,B,C>{
    boolean test(A a, B b, C c);
}

class Employee {
    private String name;
    private boolean isAuthorized;

    public Employee(String name, boolean isAuthorized) {
        this.name = name;
        this.isAuthorized = isAuthorized;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }
}



public class PredicateAndBipredicate {

    private static final String PROCESSED = "Proccesed";

    public static boolean verifyOne(String obj, Predicate<String> predicate) {
        return predicate.test(obj);
    }

    public static boolean verifyTwo(List<String> obj, BiPredicate<List<String>, Integer> biPredicate ){
        return biPredicate.test(obj, 1);
    }

    public static boolean verifyThree(List<String> obj, String value,
                                      TriPredicate<List<String>, Integer, String> biPredicate ){
        return biPredicate.test(obj, 2, value);
    }

    public static boolean verifyFour(Predicate<String> predicate) {
        return predicate.test(PROCESSED);
    }

    public static boolean verifiFive(String value, Predicate<String> predicate) {
        return predicate.test(value);
    }


    public static void print(Object obj, Consumer<Object> consumer){
        consumer.accept(obj);
    }

    public static Object createObject(Supplier<Object> supplier) {
        return supplier.get();
    }

    public static String changeValue(String value, Function<String, String> function) {
        return function.apply(value);
    }



    public static void main(String[] args) {
        PredicateAndBipredicate.print("Primer Caso", System.out::println);
        String name = "John";
        boolean responde = PredicateAndBipredicate.verifyOne(name, (value) -> value.startsWith("J"));
        PredicateAndBipredicate.print(responde, System.out::println);





        PredicateAndBipredicate.print("Cuarto Caso", System.out::println);
        String value = "Send";
        Predicate<String> predicate = Predicate.isEqual(value);
        boolean newResponse = PredicateAndBipredicate.verifyFour(predicate);
        if(newResponse) {
            value = PredicateAndBipredicate.changeValue("Proccessed", (a) -> a);
        }
        PredicateAndBipredicate.print(value, System.out::println);

        boolean negationStatic =  PredicateAndBipredicate.verifyFour(Predicate.not(predicate));
        if(negationStatic) {
            value = PredicateAndBipredicate.changeValue("Ongoing...", Function.identity());;
        }
        PredicateAndBipredicate.print(value, System.out::println);



        PredicateAndBipredicate.print("Quinto Caso", System.out::println);
        String password = "M4r14na0611@";
        Predicate<String> verifyPass = pwd -> pwd.length() >= 8;
        Predicate<String> verifyAdmins = username -> username.equalsIgnoreCase("M4r14na0611@");
        Predicate<String> verifySubAdmin = userSub -> userSub.equalsIgnoreCase("Srcortes");

        boolean veriyPwd = PredicateAndBipredicate.verifiFive(password,
                verifyPass.and(verifyAdmins.or(verifySubAdmin)));

        PredicateAndBipredicate.print(veriyPwd, System.out::println);

        PredicateAndBipredicate.print("Sexto Caso", System.out::println);
        String user = "Srcortes@";
        Integer authorized = 1;

        /**
         * Predicate it is a functional interface that evaluate a given condition and return boolean value,
         * it receives one argument and holds the following method(test-and-or-negate) two static method(Isequal-not)
         */
        Predicate<String> evaluateName = (userName) -> userName.length() >= 8;
        boolean result = evaluateName.and(v-> v.contains("@")).and(j -> j.startsWith("S")).test(user);
        PredicateAndBipredicate.print(result, System.out::println);

        /**
         * Bipredicate it's a functional interface which receives two arguments and return boolean value
         * it holds the follow methods(test-and-or-negate)
         */
        PredicateAndBipredicate.print("Segundo Caso", System.out::println);
        List<String> list = (List<String>) PredicateAndBipredicate.createObject(ArrayList::new);
        list = Arrays.asList("Uno", "Dos");
        boolean response = PredicateAndBipredicate.verifyTwo(list,  (a, b) -> a.size() == b);
        PredicateAndBipredicate.print(response, System.out::println);

        /**
         * IntPredicate it's a functional interface that doesn't receive arguments, it contains
         * the follow method(test-and-or-negate), this functional interface only evaluate integer values
         * TO REMIND it's the same operation or same definition to DoublePredicate and LongPredicate
         */
        IntPredicate intPredicate = anyValue -> anyValue > 5000;
        System.out.println(intPredicate.test(8000));

        boolean out = true;
        Predicate<Boolean> prueba = val -> val;

        if(prueba.test(out)){
            System.out.println("here");
        }

        Predicate<Boolean> algo = Predicate.not(prueba);
        System.out.println(algo.test(out));

        /**
         * Predicate.isequal
         */
        List<String> testPredicate = Arrays.asList("VOID", "VOID", "VOID");
        Predicate<String> evaluateConditionVoid = Predicate.isEqual("VOID");
        int flag = 0;

        for(int j = 0; j < testPredicate.size(); j++){
            if(evaluateConditionVoid.test(testPredicate.get(j))){
                flag++;
            }
        }
        IntPredicate verifyAmount = val -> val == testPredicate.size();
        if(verifyAmount.test(flag)) {
            System.out.println("TODOS VOID");
        }






    }
}
