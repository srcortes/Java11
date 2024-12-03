package MODERNJAVA.PART1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

@FunctionalInterface
interface createPeople<A,B,C,R>{
    R apply(A a, B b, C c);
}

class People{
    private String name;
    private int age;
    private int anioNacimiento;

    public People(String name, int age, int anioNacimiento) {
        this.name = name;
        this.age = age;
        this.anioNacimiento = anioNacimiento;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    @Override
    public String toString() {
        return name +" "+ age + " " + anioNacimiento;
    }
}
public class IntPredicateTest {

    public static People createPeople(String name, int age, int anio,
                                      createPeople<String, Integer, Integer, People>  createPeople ) {
        return createPeople.apply(name, age, anio);
    }

    public static List<?> createList(Supplier<List<?>> supplier) {
        return supplier.get();
    }

    public static boolean verifyAge(int age, IntPredicate predicateTest) {
        return predicateTest.test(age);
    }

    public static boolean verifyGrades(double temperature, DoublePredicate doublePredicate) {
        return doublePredicate.test(temperature);
    }

    public static void print(String value, Consumer<String> consumer) {
        consumer.accept(value);
    }

    public static void print(Double value, Consumer<Double> consumer) {
        consumer.accept(value);
    }

    public static void main(String[] args) {

        IntPredicateTest.print("Caso Uno", System.out::println);
        int age = 50;
        IntPredicate evaluateValue = value -> value >= 40;
        IntPredicate newEvaluate = value -> value <= 50;
        boolean evaluateAge = IntPredicateTest.verifyAge(age, evaluateValue.and(newEvaluate));

        if(evaluateAge) {
            IntPredicateTest.print("Es mayor", System.out::println);
        }

        IntPredicateTest.print("Caso Dos", System.out::println);
        People person1 = IntPredicateTest
                .createPeople("July Mora", 39, 1893, People::new);
        People person2 =  IntPredicateTest
                .createPeople("Mariana Mora", 11, 2011, People::new);
        People person3 =  IntPredicateTest
                .createPeople("Gabriela Mora", 1, 2021, People::new);
        People person4 =  IntPredicateTest
                .createPeople("Gabriela Mora", 41, 2021, People::new);
        People person5 = IntPredicateTest.createPeople("John Rodriguez", 42, 1980, People::new);

        Supplier<List<People>> listSupplier = ArrayList::new;
        List<People> list = (List<People>) IntPredicateTest.createList(ArrayList::new);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);


        list.forEach(value->{
            IntPredicate ages = edad -> edad >= 30 && edad <=50;
            IntPredicate range = val -> val >= 49;
            IntPredicate anio = an -> an >= 2011;
            boolean response = IntPredicateTest.verifyAge(value.getAge(), ages.or(anio));
            if(response) {
                IntPredicateTest.print(value.getName(), System.out::println);
            }
        });

        IntPredicateTest.print("Caso Tres", System.out::println);
        List<Double> listTemperature = (List<Double>) IntPredicateTest.createList(ArrayList::new);
        listTemperature.add(35.9);
        listTemperature.add(10.1);
        listTemperature.add(-0.56);
        listTemperature.add(-13.5);
        listTemperature.add(31.3);
        listTemperature.add(21.3);
        listTemperature.add(-12.9);

        listTemperature.forEach(val->{
            DoublePredicate doublePredicate = grade -> grade <= 0.0;
            DoublePredicate doublePredicate2 = grade -> grade >= 1.0 && grade <= 11.0;
            var response = IntPredicateTest.verifyGrades(val, doublePredicate.or(doublePredicate2));

            if( response ) {
                IntPredicateTest.print(val, System.out::println);
            }

        });




    }
}
