package MODERNJAVA.PART1.TESTFINAL;

import java.util.*;
import java.util.function.*;


class Student{
    private String name;
    private double qualification;

    public Student(String name, double qualification) {
        this.name = name;
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQualification() {
        return qualification;
    }

    public void setQualification(double qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", qualification=" + qualification +
                '}';
    }
}
public class FunctionExampleOne {
    static String name = "John";



    public static String firstExample(String value, Function<String, String> function){
        return function.apply(value);
    }

    public static Student createStudent(String name, double qualification,
                                       BiFunction<String, Double, Student> biFunction){
        return biFunction.apply(name, qualification);
    }

    public static Map<String, Integer> createMap(List<String> list, Function<String, Integer> function){
        Map<String, Integer> map = new HashMap<>();
        for( String s : list ) {
                map.put(s, function.apply(s));
        }
        return map;
    }

    public static String sha256(String str) {
        return  str.toUpperCase();
    }

    public static List<String> returnNewList(Function<String, String> p, List<String> s1) {
        List<String> list = new ArrayList<>();
        for(String s : s1 ){
            Predicate<String> predicate = val -> val.length() > 4;
            if(predicate.test(s)) {
                list.add(p.apply(s));
            }
        }
        System.out.println(list);
        return list;
    }

    public static List<Student> createList(Function<Student, List<Student>> function, Student... student) {
        List<Student> list = new ArrayList<>();
        for(Student s : student){
            list = function.apply(s);
        }
        return list;
    }

    public static String analyzeCompose(String value, Function<Integer, String> function){
        return function.compose(String::length).apply(value);
    }

    public static String otherExample(String[] values, Function<String[], String> function){
        return function.apply(values);
    }

    public static String applyIdentityToEmpList(String value, Function<String, String> function){
        return function.apply(value);
    }

    public static Double applyIntFunction(int value, IntFunction<Double> intFunction){
        return intFunction.apply(value);
    }

    public static String analyzeAndThen(List value, Function<List<String>, String> function){
        return function.andThen(val -> {
            if("".equals(val)){
                return "No existio error";
            }else{
                return val;
            }
        }).apply(value);

    }

    public static void main(String[] args) {
        System.out.println("Primer ejemplo**************");
        String valor = FunctionExampleOne
                .firstExample(" Rodriguez", val -> name.concat(val));
        System.out.println(valor);

        System.out.println("Segundo ejemplo**************");
        Function<String, String> function = val -> {
            String newName = "";
            if(name.equalsIgnoreCase("John")) {
                newName = "Mariana".concat(val);
            } else {
                newName = "Gabriela".concat(val);
            }

            return newName;
        };
        System.out.println(function.apply("pruebas"));

        System.out.println("Tercer ejemplo**************");


        List<String> list = new ArrayList<>();
        list.add("A");



        Function<List<String>, String> evaluate = val -> {
            Predicate<List<String>> predicate = value -> value.size() == 2;
            if(predicate.test(val)) {
                return "Error";
            } else {
                return "";
            }
        };

        Function<String, String> evaluate2 = val->{
            if("".equals(val)){
                return "No existio error";
            }else{
                return val;
            }
        };

        System.out.println(evaluate.andThen(evaluate2).apply(list));
        String newMsn = FunctionExampleOne.analyzeAndThen(list, val->{
            Predicate<List<String>> predicate = value -> value.size() == 2;
            if(predicate.test(val)) {
                return "Error";
            } else {
                return "";
            }

        });
        System.out.println(newMsn);

        Student studentUno = FunctionExampleOne.createStudent("John", 5.0,
                Student::new);
        Student studentDos = FunctionExampleOne.createStudent("July", 5.0,
                Student::new);
        Student studentTres = FunctionExampleOne.createStudent("Mariana", 4.0,
                Student::new);

        List<Student> a = new ArrayList<>();
        List<Student> list1 = FunctionExampleOne.createList((val1) -> {
                    a.add(val1);
                    return a;
                },
                studentUno, studentDos, studentTres);
        Consumer<Object> consumer = System.out::println;


        consumer.accept(list1);

        List<String> listFields = Arrays.asList("node", "c++", "java", "javascript");
        Map<String, Integer> map = FunctionExampleOne.createMap(listFields, String::length);
        System.out.println(map);
        List<String> newList = FunctionExampleOne.returnNewList(FunctionExampleOne::sha256, listFields);
        consumer.accept(newList);



        String name = "john jairo";
        Function<Integer, String> function1 = val -> {
            if(val > 5) {
                return "Reach limit";
            } else {
                return "Continue..";
            }
        };

        UnaryOperator<String> unaryOperator = String::toUpperCase;

        String nameValue = function1.compose(String::length).andThen(unaryOperator).apply(name);
        consumer.accept(nameValue);

        String newValue = FunctionExampleOne.analyzeCompose(name, val -> {
            if(val > 5) {
                return "Reach limit";
            } else {
                return "Continue..";
            }
        });
        consumer.accept(newValue);

        String values[] = {"A", "B", "C"};
        Function<String[], String> function2 = val -> {
            if(val[1].equals("B")) {
                return "Correcto";
            }else {
                return "Nada";
            }
        };
        consumer.accept(function2.apply(values));

        String message = FunctionExampleOne.otherExample(values, val -> {
            if(val[1].equals("B")) {
                return "Correcto";
            }else {
                return "Nada";
            }
        });
        System.out.println(message);

        if(message.equals("Correcto")) {
            var message2 = FunctionExampleOne.applyIdentityToEmpList("Okkkkkkk", Function.identity());
            System.out.println(message2);
        }


        /**
         * IntFunction, recibe un valor de tipo entero, y devuelve el valor especificado en el operador <>
         */
        IntFunction<Double> ob = a1 -> a1 / 2.7;
        System.out.println(ob.apply(3));
        Double val = FunctionExampleOne.applyIntFunction(3, val1 -> val1 / 2.7);
        System.out.println(val);

        IntFunction<Boolean> ob1 = valIntFunction -> valIntFunction > 2021 ;
        System.out.println("IntFunction<R> " + ob1.apply(2021));


        /**
         * IntToDoubleFunction recibe un valor entero y devuelve un double
         */
        IntToDoubleFunction func = a2 -> 3.12 * a2;
        System.out.println("IntToDoubleFunction " + func.applyAsDouble(3));

        /**
         * IntToLongFunction recibe un entero y devuelve un long
         */
        IntToLongFunction ob3 = a3 -> a3 * 23450L;
        System.out.println("IntToLongFunction " + ob3.applyAsLong(3));

        /**
         * LongFunction recibe un valor de tipo Long y devuelve el valor especificado en el operador <>
         */
        LongFunction<Boolean> ob4 = a4 -> a4 > 345L;
        System.out.println("LongFunction " + ob4.apply(34L));

        /**
         * LongToDoubleFunction recibe un Long como parametro y retorna un double
         */
        LongToDoubleFunction ob5 = a5 -> a5 + 345.98;
        System.out.println("LongToDoubleFunction " + ob5.applyAsDouble(45L));

        //LongToIntFunction recibe un Long como parametro y devuelve un entero como resultado
        LongToIntFunction ob6 = a6 -> (int)a6 * 34;
        System.out.println("LongToIntFunction " + ob6.applyAsInt(45L));

        //DoubleFunction<R> recibe como parametro un valor de tipo double y devuelve el especificado en el operador <>
        DoubleFunction<Integer> ob7 = a7 -> (int)a7 + 45;
        System.out.println("DoubleFunction<R> " + ob7.apply(45.78));

        //DoubleToIntFunction recibe un valor de tipo double y devuelve un entero
        DoubleToIntFunction ob8 = a8 -> (int)a8;
        System.out.println(ob8.applyAsInt(34.98));

        //DoubleToIntFunction recibe un valor de tipo double y devuelve un entero
        DoubleToLongFunction ob9 = a9 -> (long)a9;
        System.out.println(ob9.applyAsLong(34.67));

        /**
         * Para tener en cuenta
         * A diferencia de IntFunction<R> que devuelve los especificado en el <>
         * aqui recibe lo que esta en el operador <> y devuelve un entero
         */
        ToIntFunction<List<String>> intFunction = List::size;
        List<String> list2 = Arrays.asList("A","B", "C");
        System.out.println("ToIntFunction " + intFunction.applyAsInt(list2));

        /**
         * ToDoubleFunction<R> recibe el valor que se especifica en el operador <> y retorna un double
         */
        List<Double> list3 = Arrays.asList(12.3,45.5,43.8,56.7);
        ToDoubleFunction<List<Double>>
                list4 = qualifications -> qualifications.stream().mapToDouble(j -> j).sum() / qualifications.size();
        System.out.println("ToDoubleFunction " + list4.applyAsDouble(list3));

        /**
         * ToLongFunction recibe el valor especificado en el operador <> y retorna un long
         */
        List<Long> list5 = Arrays.asList(12L, 34L, 56L, 56L);
        ToLongFunction<List<Long>> toLongFunction = calculate -> calculate.stream().mapToLong(x->x).sum();
        long among = toLongFunction.applyAsLong(list5);
        System.out.println(among);

        /**
         * BiFunction it is a functional that receive two arguments and return the specific value
         */
        List<String> words = List.of("Piece", "Hello", "Piece", "Bad", "Bad", "Bad", "John");

        Supplier<Map<String, Integer>> supplier = HashMap::new;

        Map<String, Integer> map2 = supplier.get();
        Map<String, Integer> newMap = supplier.get();
        Map<String, Integer> newMap1 = supplier.get();

        UnaryOperator<Map<String, Integer>> function3 = vals -> {
            vals.forEach((k,v) -> {
                newMap1.put(k.toUpperCase(), v);
            });

            return newMap1;
        };

        BiFunction<String, Integer, Map<String, Integer>> biFunction = (key, chain) -> {
            map2.put(key, chain);
            return map2;
        };

        for(String s : words) {
            newMap = biFunction.andThen(function3).apply(s, Collections.frequency(words, s));
        }
        newMap.entrySet().forEach(System.out::println);

        /**
         * ToIntBiFunction, it is a functional interface which receive two arguments and return an int.
         * It is the same situation to ToLongBifunction<T,U>  - ToDoubleBiFunction<T, U>
         */
        ToIntBiFunction<String, Integer> toIntBiFunction = (chain, value) -> (chain.length() + value) / 2;
        System.out.println(toIntBiFunction.applyAsInt("John", 1980));

        /**
         *
         */
        List<Double> list6 = Arrays.asList(12.3,45.5,43.8,56.7);
        List<Double> list7 = Arrays.asList(15.3,35.5,49.8,1175.7,145.3);

        ToDoubleBiFunction<Double, Double> toDoubleBiFunction = Double::sum;
        DoubleSupplier firstAverage = () -> list6.stream().mapToDouble(c->c).sum() / list6.size();
        DoubleSupplier secondAverage = () -> list7.stream().mapToDouble(c->c).sum() / list7.size();
        System.out.println(toDoubleBiFunction.applyAsDouble(firstAverage.getAsDouble(), secondAverage.getAsDouble()));

        ToLongBiFunction<Long, Integer> toLongBiFunction = Math::floorDiv;
        long outcome = toLongBiFunction.applyAsLong(1985L, 85);
        System.out.println(outcome);



























    }
}
