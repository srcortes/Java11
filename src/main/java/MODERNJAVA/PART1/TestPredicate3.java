package MODERNJAVA.PART1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


@FunctionalInterface
interface QuadFunction2<A, B, C, D, R> {
    R apply(A a, B b, C c, D d);
}
class Alumnos{

    private Integer id;
    private String name;
    private String lastName;

    private LocalDate born;

    public Alumnos(Integer id, String name, String lastName, LocalDate born) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.born = born;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    @Override
    public String toString() {
        return "" + id +" "+ name + " " + lastName + " "+ born;
    }
}
public class TestPredicate3 {
    static List<Alumnos> alumnosList = new ArrayList<>();

    public static Alumnos createAlumno(Integer id, String nombre, String apellido, LocalDate localDate,
                                       QuadFunction2<Integer, String, String, LocalDate, Alumnos> function) {
        return function.apply(id, nombre, apellido, localDate);
    }

    public static List<Alumnos> createLista(QuadFunction2<Integer, String, String, LocalDate, Alumnos> alumFunction
            , Alumnos alumnos) {
        alumnosList.add(alumFunction.apply(alumnos.getId(), alumnos.getName(), alumnos.getLastName(), alumnos.getBorn()));
        alumnosList.sort(Comparator.comparing(Alumnos::getLastName).thenComparing(Alumnos::getId));
        return alumnosList;
    }

    public static void printValue(List<Alumnos> list, Consumer<List<Alumnos>> consumer) {
         consumer.accept(list);
    }

    public static void printValue(Alumnos list, Consumer<Alumnos> consumer) {
        consumer.accept(list);
    }

    public static boolean Experiment(Alumnos alumnos, Predicate<Alumnos> predicate) {
        return predicate.negate().and(value -> value.getName().length() >  7).test(alumnos);
    }


    public static void main(String[] args) {
        TestPredicate3.createLista(Alumnos::new, TestPredicate3.createAlumno(80217780, "John Jairo",
                "Rodriguez Cortes", LocalDate.of(1980, 10, 15), Alumnos::new));
        TestPredicate3.createLista(Alumnos::new, TestPredicate3.createAlumno(1141234566, "Mariana",
                "Rodriguez Mora",LocalDate.of(2011, 11, 06), Alumnos::new));
        TestPredicate3.createLista(Alumnos::new, TestPredicate3.createAlumno(63545795, "July",
                "Mora Ardila", LocalDate.of(1983, 10, 23), Alumnos::new));
        TestPredicate3.createLista(Alumnos::new, TestPredicate3.createAlumno(456789, "Gabriela",
                "Rodriguez Mora", LocalDate.of(2021, 04, 15), Alumnos::new));


        TestPredicate3.printValue(alumnosList, System.out::println);
        alumnosList.forEach(value->{           ;
            boolean a = TestPredicate3.Experiment(value,
                    j -> (LocalDate.now().getYear() - j.getBorn().getYear()  > 18));

            if( a ) {
                System.out.println(":::" + value);
            }
        });


    }
}
