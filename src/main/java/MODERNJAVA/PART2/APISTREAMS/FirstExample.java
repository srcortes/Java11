package MODERNJAVA.PART2.APISTREAMS;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

class Viaje{
    private String pais;

    public Viaje(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Viaje{" +
                "pais='" + pais + '\'' +
                '}';
    }
}

class Persona{
    private String nombre;
    private List<Viaje>  lista = new ArrayList<>();

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void addViaje(Viaje v) {
        lista.add(v);
    }
    public List < Viaje > getLista() {
        return lista;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", lista=" + lista +
                '}';
    }
}

public class  FirstExample {



    public static List<Dish> getList() {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

        return menu;
    }

    public static List<Dish> getListTwo() {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

       return specialMenu;
    }

    public static List <Persona>  getPersona() {
        Persona p = new Persona("pedro");
        Viaje v = new Viaje("Francia");
        Viaje v2 = new Viaje("Inglaterra");
        p.addViaje(v);
        p.addViaje(v2);
        Persona p1 = new Persona("gema");
        Viaje v3 = new Viaje("Italia");
        Viaje v4 = new Viaje("Belgica");
        p1.addViaje(v3);
        p1.addViaje(v4);

        List < Persona > lista = new ArrayList < Persona > ();
        lista.add(p);
        lista.add(p1);

        return lista;
    }

    public static void main(String[] args) {

        List<String> tittle = Arrays.asList("Modern", "Java", "In", "Action");
        Stream s = tittle.stream();
        s.forEach(System.out::println);


        List<String> threeHighCaloriesDisName = FirstExample.getList().stream()
                .filter(val -> val.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());
        System.out.println(threeHighCaloriesDisName);

        Map<String, Boolean> dishes = FirstExample.getList().stream()
                .filter(Dish::isVegetarian)
                .collect(toMap(Dish::getName, Dish::isVegetarian));
        System.out.println(dishes);

        FirstExample.getList().stream()
                .takeWhile(val -> val.getName().length() > 7).map(Dish::getName).collect(toList())
                .forEach(System.out::println);

        FirstExample.getListTwo().stream()
                .filter(j -> j.getCalories() < 320)
                .collect(toList()).forEach(System.out::println);


        /**
         * It is like distinct in BD, it eliminate duplicate information based on hashcode.
         */
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        numbers.stream().filter(j -> j % 2 == 0).distinct().forEach(System.out::println);


        /**
         * TAKEWHILE: It is a method which verify given a conditions if the next element isn´t true operation is abort
         * DROPWHILE: It is opposite to takewhile
         */
        FirstExample.getListTwo().stream().takeWhile(j -> j.getCalories() < 320).forEach(System.out::println);
        List<String> names = Arrays.asList("John", "July", "Jose", "Mariana", "Juan Pablo", "Joaquin");
        System.out.println(names.stream().filter(val -> val.charAt(0) == 'J').collect(toList()));
        System.out.println("TAKE WHILE ->" + names.stream().takeWhile(val -> val.charAt(0) == 'J').collect(toList()));
        System.out.println("DROP WHILE ->" + names.stream().dropWhile(val -> val.charAt(0) == 'J').collect(toList()));

        /**
         * Limit allows us to truncate the result about list
         */
        List<Dish> list = FirstExample.getList().stream().filter(val -> val.getCalories() > 500)
                .limit(3).collect(toList());
        System.out.println("LIMIT -> " + list);
        names.stream().limit(4).forEach(System.out::println);


        /**
         * Remove elements that are specified within method skip.
         */
        List<Dish> list1 = FirstExample.getList().stream().filter(j -> j.getCalories() < 500)
                .skip(2).collect(toList());
        System.out.println("SKIP->" + list1);


        /**
         * Map method allow us to transform data as far a list for instances.
         */
        Optional<String> list2 = FirstExample.getList().stream().filter(Dish::isVegetarian)
                .limit(1).map(Dish::getName).map(String::toUpperCase).findFirst();
        System.out.println("MAP-> " + list2.get());
        List<String> words = Arrays.asList("John", "Jairo", "Rodriguez", "Cortes");
        List<Integer> list3 = words.stream().map(String::length).collect(toList());
        System.out.println("MAP EXAMPLE 2 -> " + list3);
        List<Integer> list4 = FirstExample.getList().stream().filter(j->j.getCalories() >= 800)
                .map(Dish::getName).map(String::length)
                .collect(toList());
        System.out.println("MAP EXAMPLE 3 ->" + list4);
        List<String> map = words.stream()
                .map(val -> {
                    if(val.charAt(0) == 'J'){
                        return val.toUpperCase();
                    } else {
                        return "invalidate";
                    }
                })
                .collect(toList());
        System.out.println("MAP EXAMPLE 4 ->" + map);
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("John", 1980);
        map1.put("July", 1983);
        map1.put("Mariana", 2021);
        map1.put("Gabriela", 2022);

        Optional<Persona> p = map1.entrySet().stream().filter(j -> LocalDate.now().getYear() - j.getValue() > 10)
                .map(k -> new Persona(k.getKey())).findFirst();
        System.out.println("MAP EXAMPLE 5 ->" + p.map(Persona::getNombre).orElseGet(() -> "There isn't any criteria"));

        List<Dish> list6 = FirstExample.getListTwo().stream().filter(Dish::isVegetarian)
                .map(j -> new Dish(j.getName().toUpperCase(), j.isVegetarian(), j.getCalories(), j.getType()))
                .collect(toList());
        System.out.println("MAP EXAMPLE 5.1 ->" + list6);


        /**
         * Allow us join in an unique list or array the information of several collections.
         */
        List<String> word =Arrays.asList("Goodbye", "World");
        List<String> w1 = word.stream().map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .collect(toList());
        System.out.println("MAP EXAMPLE 6 ->" + w1);

        List<Persona> list7 = FirstExample.getPersona();

        for (Persona persona: list7) {
            for (Viaje viaje: persona.getLista()) {
                System.out.println("---" + viaje.getPais());
            }
        }

        List<Viaje> list8 = list7.stream().map(Persona::getLista)
                .flatMap(Collection::stream)
                .collect(toList());
        Optional<List<Viaje>> op = Optional.of(list8);
        op.ifPresent(System.out::println);


        Map<String, List<String>> map2 = list7.stream().collect(toMap(Persona::getNombre
                ,trip -> trip.getLista().stream().map(Viaje::getPais).map(String::toUpperCase).collect(toList())
        ));
        System.out.println(map2);

        List<Integer> listOne = Arrays.asList(1,2,3);
        List<Integer> listThree = Arrays.asList(3,4);
        List<List<Integer>> listFour = Arrays.asList(listOne, listThree);
        List<Integer> list5 = listFour.stream().flatMap(Collection::stream).distinct().collect(toList());
        System.out.println(listFour);
        System.out.println(list5);

        List<List<String>> list33 = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"));

        List<String> list44 = list33.stream().flatMap(Collection::stream).map(String::toUpperCase)
                .filter(i->i.equals("A"))
                .collect(Collectors.toList());
        System.out.println(list44);

        /**
         * Anymatch it's a function that find whithin collection if some value match with given conditions
         */
        Stream<String> stream
                = Stream.of("CS", "C+", "Ja", "DS");
        boolean b = map1.entrySet().stream().map(Map.Entry::getValue).anyMatch(x-> x == 1980);
        boolean b1 = stream.anyMatch(value -> value.length() == 3);
        System.out.println("ANYMATCH " + b +" "+ b1);

        /**
         * Verify if all elements in collections match with the given conditions.
         */
        Stream<String> stream1
                = Stream.of("CSE", "C++", "Jav", "DSs");
        List<String> list9 = Arrays.asList("A", "A");
        boolean c = list9.stream().allMatch(x -> x.equals("A"));
        boolean c1 = stream1.allMatch(value -> value.length() == 3);
        System.out.println("ALLMATCH " + c +" "+ c1);

        /**
         * Verify in collections that all elements don't match with given conditions
         */
        Stream<String> stream2
                = Stream.of("CS", "C+", "Ja", "DSf");
        boolean d = list9.stream().noneMatch(x->x.equals("B"));
        boolean d1 = stream2.noneMatch(x -> x.length() == 3);
        boolean d2 = map1.entrySet().stream().noneMatch(x -> (LocalDate.now().getYear() - x.getValue()) >= 18);
        System.out.println("NONEMATCH " + d +" "+ d1 +" "+ d2);
        Optional<Boolean> optional = Optional.of(d2);
        optional.filter(v -> v).ifPresentOrElse(v-> System.out.println("menores"), ()-> System.out.println("hay un adulto"));

        /**
         * In order to find some element which achieve with given conditions, we can use findAny
         * To remind this method find an arbitrary element and return an Optional.
         */
        List<Double> list10 = Arrays.asList(2.6, 2.9, 3.9, 3.2);

        Optional<Double> optionalDouble = list10.stream().filter(i-> i <= 2.2).findAny();
        optionalDouble.ifPresentOrElse(System.out::println, () -> System.out.println("No existe criterio"));

        /**
         * To find the first coincidence inside collections we can use this method
         */
        map1.entrySet().stream().filter(age -> (LocalDate.now().getYear() - age.getValue()) > 18).findFirst()
                .ifPresent(System.out::println);

        /**
         * Reduce
         */
        List<Integer> numbersSum = Arrays.asList(40,43,18,11,2);
        System.out.println(numbersSum.stream().reduce(1, (numberOne, numberTwo) -> numberOne * numberTwo));
        numbersSum.stream().reduce((A1, A2) -> A1 * A2).ifPresent(System.out::println);





    }
}
