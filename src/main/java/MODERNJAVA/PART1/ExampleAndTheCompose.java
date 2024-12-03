package MODERNJAVA.PART1;


import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
interface CreateFunction<A, B, C, R> {
    R apply (A a, B b, C c);
}

class Computer {
    private String marca;
    private String tipo;

    private Double precio;

    public Computer(String marca, String tipo, Double precio) {
        this.marca = marca;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return marca + " "+ tipo + " " + precio;
    }
}


public class ExampleAndTheCompose {

    public static Computer createPerson(String name, String apellido) {
       TriFunction<String, String, Double, Computer> function = Computer::new;
       return function.apply(name, apellido, 0.0);
    }

    public static Double calculatePrice(String price) {
        return Double.valueOf(price);
    }

    public static void main(String[] args) {
        BiFunction<String, String, Computer> personBiFunction = ExampleAndTheCompose::createPerson;
        personBiFunction.apply("John", "Rodriguez");


        Function<String, Double> biFunction = ExampleAndTheCompose::calculatePrice;







        Function<Integer, Integer> multiply = (value) -> value * 2;
        Function<Integer, Integer> add      = (value) -> value + 3;

        Function<Integer, Integer> addThenMultiply = multiply.compose(add);

        Integer result1 = addThenMultiply.apply(3);
        System.out.println(result1);

    }
}
