package MODERNJAVA.PART1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;


@FunctionalInterface
interface QuadFunction<T,U,V,Z,R>{
    R apply(T t, U u, V v, Z z);
}
class Car {


    private String marca;
    private String color;

    private String countryOrigen;

    private Integer codigoBarra;

    public Car(String marca, String color, String countryOrigen, Integer codigoBarra) {
        this.marca = marca;
        this.color = color;
        this.countryOrigen = countryOrigen;
        this.codigoBarra = codigoBarra;
    }

    public Car(String marca) {
        this.marca = marca;
    }



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountryOrigen() {
        return countryOrigen;
    }

    public void setCountryOrigen(String countryOrigen) {
        this.countryOrigen = countryOrigen;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString(){
        return marca + " " + color ;
    }
}
public class TestPredicate2 {

    private static Object createObject(Supplier<Object> supplier) {
        return supplier.get();
    }

    public static List<?> createList (Supplier<List<?>> listSupplier) {
        return listSupplier.get();
    }

    public static void printData(Object obj, Consumer<Object> consumer) {
        consumer.accept(obj);
    }

    public static List<Car> createCar(List<String> list, String color, String origen, Integer code,
                                      QuadFunction2<String, String, String, Integer, Car> function) {
        List<Car> carList = (List<Car>) createList(ArrayList::new);

        list.forEach(value ->{
            carList.add(function.apply(value, color, origen, code));
        });
        carList.sort(Comparator.comparing(Car::getMarca));
        return carList;

    }

    public static void main(String[] args) {
        List<String> referenceName = Arrays.asList("Ferrari", "Mazda", "Renault", "Dodge");

        TestPredicate2.printData(TestPredicate2.createCar(referenceName, "Rojo", "USA", 123456, Car::new), System.out::println);
    }
}
