package CAP3.METHODREFERENCES;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

class Animal{
    private String specie;
    private String food;

    public Animal() {
    }

    public Animal(String specie, String food) {
        this.specie = specie;
        this.food = food;
    }

    @Override
    public String toString(){
        return specie + " - " + food;
    }
}

@FunctionalInterface
interface GetObjectAnimal{
    Animal getObjectAnimal(String specie, String food);
}

public class CALLINGCONSTRUCTOR {

    public static void main(String[] args) {
        Supplier<Animal> animalSupplier = Animal::new;
        Supplier<List<Animal>> listSupplier = ArrayList::new;
        List<Animal> animal = listSupplier.get();


        GetObjectAnimal getObjectAnimal = Animal::new;
        getObjectAnimal.getObjectAnimal("A", "B");
        animal.add( getObjectAnimal.getObjectAnimal("A", "B"));
        System.out.println(animal);

        Function<Integer, List<String>> method = ArrayList::new;
        method.apply(1);



    }
}
