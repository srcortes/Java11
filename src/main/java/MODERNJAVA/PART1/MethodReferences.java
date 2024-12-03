package MODERNJAVA.PART1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

class Person {
    private String name;
    private String lastName;

    private Integer id;

    public Person(String name, String lastName, Integer id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}

@FunctionalInterface
interface TriFunction<A, B, C, R>{
    R apply(A a, B b, C c);
}
public class MethodReferences {

    public static boolean isValidaNameUno(String name) {
        return Character.isUpperCase(name.charAt(0));
    }

    public static void printValue(Object value, Consumer<Object> obj) {
        obj.accept(value);
    }

    public static void printValue(Object value) {
        System.out.println(":::: object-> " + value);
    }

    public void printValueString(String value){
        System.out.println(":::-> "+ value);
    }

    public static Object createObject(Supplier<Object> supplier) {
        return supplier.get();
    }

    public static Person createObject(String name, String lastName, Integer id,
                                      TriFunction<String, String, Integer, Person> biFunction) {
        return biFunction.apply(name, lastName, id);
    }

    public static Person someTest(String value, Person p) {
        return p;
    }

    public static void main(String[] args) {
        Function<String, Boolean> test1 = MethodReferences::isValidaNameUno;
        //MethodReferences.printValue( test1.apply("John"), System.out::println);
        Consumer<Boolean> test2 = MethodReferences::printValue;
        test2.accept(test1.apply("John"));

        String value = "Jairo";
        MethodReferences methodReferences = (MethodReferences) MethodReferences.createObject(MethodReferences::new);

        Consumer<String> test3 = methodReferences::printValueString;
        test3.accept(value);

        Person person1 = MethodReferences.createObject("Gabriela", "Rodriguez", 2, Person::new);
        Consumer<Person> personConsumer = MethodReferences::printValue;
        personConsumer.accept(person1);

        List<String> str = Arrays.asList("a", "b", "A", "B");
        str.sort(String::compareToIgnoreCase);
        System.out.println("**" + str);
        str.stream().sorted(String::compareToIgnoreCase).forEach(System.out::println);

        Person person2 = MethodReferences.createObject("Mariana", "Rodriguez", 11, Person::new);
        Person person3 = MethodReferences.createObject("July", "Mora", 39, Person::new);
        Person person4 = MethodReferences.createObject("John", "Rodriguez", 42, Person::new);

        List<Person> personGroup = Arrays.asList(person1, person3, person2, person4);
        System.out.println(personGroup);

        /*personGroup.stream().sorted(Comparator.comparingInt(Person::getId)).forEach(System.out::println);
        personGroup.stream().sorted(Comparator.comparing(Person::getName)
                .thenComparing(name -> name.getName().length()).reversed()).forEach(System.out::println);*/

        Predicate<Person> evaluateConditions = p -> p.getId() > 10;
        Predicate<Person> evaluateNewConditions = evaluateConditions.and(p -> p.getLastName().startsWith("R"));


        personGroup.stream().filter(evaluateNewConditions)
                .map(v -> v.getName().concat(" ").concat(v.getLastName()).toUpperCase())
                .peek(System.out::println)
                .forEach(System.out::println);



    }
}
