package CAP3.WRAPPER;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.BooleanSupplier;

public class Wrapper {

    public static void main(String[] args) {

        Optional<Integer> prueba = Optional.empty();

        System.out.println(prueba.orElse(5));

        var heigth = new ArrayList<Integer>();
        heigth.add(null);
    }
}
