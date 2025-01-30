package MODERNJAVA.PART2.COLLECTORS;


import static java.util.stream.Collectors.*;

import MODERNJAVA.PART2.COLLECTORS.CUSTOMERCOLLECTOR.CountStringCollector;
import MODERNJAVA.PART2.COLLECTORS.CUSTOMERCOLLECTOR.PrimeNumberCollector;
import MODERNJAVA.PART2.COLLECTORS.CUSTOMERCOLLECTOR.StringNameCollector;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PersonTest {
    public static void main(String[] args) {

        Department department = new Department();
        department.setNameDeparment("TI");

        Department department1 = new Department();
        department1.setNameDeparment("INFRAESTRUCTURE");



        List<Persons> personsList = new ArrayList<>();
        Persons persons = new Persons();
        persons.setNumber(List.of("3218259650, 3218259650, 3143562181"));
        persons.setName("John Jairo");
        persons.setDepartment(department);
        persons.setAge(43);

        Persons persons1 = new Persons();
        persons1.setName("July Mora");
        persons1.setNumber(List.of("6270561"));
        persons1.setDepartment(department);
        persons1.setAge(40);

        Persons persons2 = new Persons();
        persons2.setName("Juan Pablo");
        persons2.setNumber(List.of("62705610000"));
        persons2.setDepartment(department1);
        persons2.setAge(60);

        personsList.add(persons);
        personsList.add(persons1);
        personsList.add(persons2);




        Optional<Persons> p = personsList.stream()
                .collect(minBy(Comparator.comparing(Persons::getAge)));

        p.ifPresentOrElse(System.out::println, () -> System.out.println("No exxiste"));

        int totalAge = personsList.stream().collect(summingInt(Persons::getAge));
        System.out.println(totalAge);

        double ageAverage = personsList.stream().collect(averagingInt(Persons::getAge));
        System.out.println(ageAverage);

        IntSummaryStatistics value = personsList.stream().collect(summarizingInt(Persons::getAge));
        System.out.println(value);

        String person = personsList.stream().map(Persons::getName).collect(Collectors.joining(" - "));
        System.out.println(person);

        int outcome = personsList.stream().collect(reducing(0, Persons::getAge, (i,j)-> i +  j));
        System.out.println(outcome);

        int newOutCome = personsList.stream().collect(reducing(0, Persons::getAge, (max, min) -> max > min ? max : min));
        System.out.println("---" + newOutCome);

        String namesChain = personsList.stream().collect(Collectors.reducing("", Persons::getName
                , (name1, name2) -> name1 + "  " + name2));
        System.out.println(namesChain);

       /**Grouping**/
        Map<Department, List<Persons>> mapGroup = personsList.stream().collect(Collectors.groupingBy(Persons::getDepartment));
        System.out.println("1.) "+ mapGroup);


        Map<Department, List<Persons>> mapByDepartment = personsList.stream().filter(dep-> dep.getDepartment().getNameDeparment().equals("TI")).collect(Collectors
                .groupingBy(persons3 -> {
                    if(persons3.getAge() >= 43)
                        return persons3.getDepartment();
                    else
                      return new Department();
                }));
        mapByDepartment.entrySet().removeIf(j -> j.getKey().getNameDeparment() == null);
        System.out.println("2.) " + mapByDepartment);

        Map<Integer, List<Persons>> mapPersonAge = personsList.stream().collect(Collectors.groupingBy(Persons::getAge,
                filtering(people-> people.getAge() <= 18, toList())));
        mapPersonAge.entrySet().removeIf(value2 -> value2.getValue().isEmpty());
        System.out.println("3.) " + mapPersonAge);

        Map<Department, List<String>> mapByAgeAndName = personsList.stream().collect(Collectors
                .groupingBy(Persons::getDepartment, mapping(Persons::getName, toList())));
        System.out.println("4.)" + mapByAgeAndName);

        Map<Department, Set<String>> mapSomething = personsList.stream().filter(v -> Objects.nonNull(v.getNumber()))
                .collect(groupingBy(Persons::getDepartment, flatMapping(val -> val.getNumber().stream(), toSet())));
        System.out.println("5.)" + mapSomething);

        Map<Department, Integer> newTest = personsList.stream()
            .collect(groupingBy(Persons::getDepartment, Collectors.summingInt(pp-> 1)));
        System.out.println("6.)" + newTest);

        Map<String, Long> map = personsList.stream()
            .filter(per -> per.getNumber() != null)
            .collect(groupingBy(Persons::getName, flatMapping(j-> j.getNumber()
                .stream().flatMap(jj -> Stream.of(jj.split(","))), counting())));
        System.out.println(map);

        Map<String, Integer> newMap = personsList.stream()
            .map(Persons::getNumber)
            .filter(Objects::nonNull)
            .flatMap(Collection::stream)
            .flatMap(jj -> Stream.of(jj.split(",")))
            .map(String::trim)
            .collect(toMap(Function.identity(),String::length,
                (aa, bb) -> aa));
        System.out.println("-" + newMap);

        Map<String, Map<String, List<String>>> newMap2 = personsList.stream()
            .filter(j -> j.number != null)
            .collect(groupingBy(depa -> depa.getDepartment().getNameDeparment(),
                groupingBy(Persons::getName, mapping(v->v.getNumber().stream().findFirst().get(), toList())
                )));
        System.out.println("****" + newMap2);

        Map<String, Map<String, List<String>>> newMap3 = personsList.stream()
            .filter(j -> j.number != null)
            .collect(groupingBy(Persons::getName,
                groupingBy(g -> g.getDepartment().getNameDeparment(),
                    mapping(v->v.getNumber().stream().findFirst().get(), toList())
                )));
        System.out.println(newMap3);

        Map<String, String> newMap4 = personsList.stream()
            .collect(toMap(Persons::getName, j -> j.getDepartment().getNameDeparment()));
        System.out.println(newMap4);

        Map<String, Persons> newMap5  = personsList.stream()
            .collect(groupingBy(Persons::getName,
                collectingAndThen(maxBy(Comparator.comparingInt(j -> j.number.size())), Optional::get)
                ));
        System.out.println("**" + newMap5);

        Map<String, Long> newMap6 = personsList.stream().collect(
            groupingBy(per -> per.getDepartment().getNameDeparment(), counting()));
        System.out.println(newMap6);

        Map<String, Optional<Persons>> newMap7 = personsList.stream()
            .collect(groupingBy(dep -> dep.getDepartment().getNameDeparment(),
                 maxBy(Comparator.comparingInt(Persons::getAge)) ));
        System.out.println(newMap7);

        Map<Long, Persons> newMap8 = personsList.stream()
            .collect(groupingBy(n -> n.getNumber().stream()
                    .flatMap(k -> Stream.of(k.split(",")))
                    .count(), collectingAndThen(maxBy(Comparator.comparingInt(Persons::getAge)),
                Optional::get)));
        System.out.println(newMap8);

        Map<String, Integer> newMap9 = personsList.stream()
            .collect(groupingBy(Persons::getName,
                summingInt(gg -> Math.toIntExact(gg.getNumber()
                    .stream().flatMap(y -> Stream.of(y.split(","))).count()))));
        System.out.println(newMap9);

        Map<String, Set<String>> newMap10 = personsList.stream().collect(groupingBy(Persons::getName,
            mapping(amount->{
                String message = "";
                long amountNumberContact = amount.getNumber().stream()
                    .flatMap(numberContact -> Stream.of(numberContact.split(","))).count();
                if(amountNumberContact < 2)
                    message =  "Incomplete Data";

                return message;
            }, toCollection(HashSet::new) )));
        System.out.println(newMap10);


        //////PARTIONING//////////
        Map<Boolean, List<Persons>> newMap11 = personsList.stream()
            .collect(partitioningBy(j -> j.getAge() >= 60));
        List<Persons> isTrue = newMap11.get(false);
        System.out.println(isTrue);

        Map<Boolean, Map<Department, List<Persons>>> newMap12 = personsList.stream()
            .collect(partitioningBy(j-> j.getNumber().stream()
                .flatMap(num -> Stream.of(num.split(","))).count() > 2, groupingBy(Persons::getDepartment)));
        Map<Department, List<Persons>> newMap13 = newMap12.get(false);
        System.out.println(newMap13);

        Map<Boolean, Persons> newMap14 = personsList.stream().collect(partitioningBy(j-> j.getNumber().stream()
            .flatMap(num -> Stream.of(num.split(","))).count() == 1,
            collectingAndThen(maxBy(Comparator.comparingInt(Persons::getAge)), Optional::get)));
        System.out.println(newMap14.get(true));

        List<Department> list = personsList.stream()
            .map(Persons::getDepartment)
            .collect(new ToListCollector<>());
        System.out.println(list);


        Department[] deparment = personsList.stream().map(Persons::getDepartment)
            .collect(new ToArraysCollector<>());
        System.out.println(Arrays.toString(deparment));

        System.out.println(partitionPrimesWithCustomCollector(1));

        List<String> pruebaString = List.of("John", "July", "Juan", "John", "Juan");
        List<String> list1 =   List.of("Hello", "Hello", "Piece", "Bad", "Bad", "Bad", "Piece", "Hello", "Bad");
        List<String> a = pruebaString.stream().collect(new StringNameCollector());
        Map<String, Integer> b = list1.stream().collect(new CountStringCollector());
        System.out.println(a);
        System.out.println(b);




    }
    
    /**METHOD TO EVALUATE WITHIN A RANGE OF NUMBER WHETER A NUMBER IS PRIME OR NOT**/
    public static Map<Boolean, List<Integer>> partitionPrimes(int n){
        return IntStream.rangeClosed(2, n).boxed().collect(partitioningBy(candidate->isPrime(candidate)));
    }

    public static boolean isPrime(int candidate){
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream
            .rangeClosed(2, candidateRoot)
            .noneMatch(i-> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n){
        return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumberCollector());
    }


}
