package MODERNJAVA.PART1;

import MODERNJAVA.PART1.TESTFINAL.ConsumerTesting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

class Animal {
    String specie;

    public Animal(String specie) {
        this.specie = specie;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    @Override
    public String toString() {
        return specie;
    }
}

public class TestPredicate1 {
    public static Object createObject(Supplier<Object> supplier) {
        return supplier.get();
    }

    public static Animal createObjectNewVersion(String specie, Function<String, Animal> function) {
        return function.apply(specie);

    }

    public static boolean verifyList(List<?> lista, Predicate<List<?>> predicate) {
        return predicate.test(lista);
    }

    public static void printObject(Object obj, Consumer<Object> consumer) {
        consumer.accept(obj);
    }

    public static int sizeList(List<?> list, ToIntFunction<List<?>> intFunction) {
        return intFunction.applyAsInt(list);
    }

    public static int sizeString(String value, Function<String, Integer> function) {
        return function.apply(value);
    }

    public static int compareObjects(Animal obj1, Animal obj2, BiFunction<Animal, Animal, Integer> biFunction) {
        return biFunction.apply(obj1, obj2);
    }

    public static String evaluateComparison(int value, IntPredicate intPredicate, IntPredicate predicate) {
        return intPredicate.test(value) ? "Es mayor" : predicate.test(value) ? "Iguales" : "Es menor";
    }

    public static boolean verifyDate(String[] date, Predicate<String[]> predicate) {
        return predicate.test(date);
    }

    public static String verifyDateArray(String date, UnaryOperator<String> unaryOperator) {
        return unaryOperator.apply(date);
    }

    public static void main(String[] args) {

        Animal animal = (Animal) TestPredicate1.createObjectNewVersion("Aves", Animal::new);


        Animal animal1 = (Animal) TestPredicate1.createObjectNewVersion("Felinos", Animal::new);


        List<Animal> animalList = (List<Animal>) TestPredicate1.createObject(ArrayList::new);
        animalList.add(animal);
        animalList.add(animal1);
        animalList.sort(Comparator.comparing(Animal::getSpecie).reversed());

        TestPredicate1.printObject(animalList, System.out::println);
        TestPredicate1.printObject(TestPredicate1.verifyList(animalList, List::isEmpty), System.out::println);
        TestPredicate1.printObject(TestPredicate1.sizeList(animalList, List::size), System.out::println);

        animalList.forEach(value -> {
            int response = TestPredicate1.sizeString(value.getSpecie(), String::length);
            TestPredicate1.printObject(response, System.out::println);
        });

        TestPredicate1.printObject("******", System.out::println);

        String val = TestPredicate1.evaluateComparison(TestPredicate1.compareObjects(animal, animal1,
                (a1, a2) -> a1.getSpecie().compareTo(a2.getSpecie())), (x) -> x > 0, (x) -> x == 0);
        TestPredicate1.printObject(val, System.out::println);

    }
}
