package CAP1.INTERFACE.FUNCTIONALINTERFACE;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface TestFI{
    String toString();
    String name();
}

class Animal{
    private String species;
    private boolean canHop;
    private boolean canSwin;

    public Animal(String species, boolean canHop, boolean canSwin) {
        this.species = species;
        this.canHop = canHop;
        this.canSwin = canSwin;
    }

    public boolean canHop(){
        return canHop;
    }

    public boolean canSwin(){
        return canSwin;
    }


    @Override
    public String toString(){
        return species + " " + canHop + " " + canSwin;
    }
}

public class FirstTestFI {

    @FunctionalInterface
    interface StringFormat{
        String run(String value);
    }

    @FunctionalInterface
    interface AnimalI{
        Animal getAnimal(String specie, boolean canHop, boolean canSwin);
    }

    private static void print(List<Animal> list, Predicate<Animal> checker){
        for(Animal animal : list){
            if(checker.test(animal))
                System.out.println(animal);
        }
    }

    private static String formatString(String value, StringFormat sf){
                return sf.run(value);
    }

    public static void main(String[] args) {
        var animals = new ArrayList<Animal>();
        AnimalI animal = Animal::new;

        Animal fish = animal.getAnimal("fish", false, true);
        Animal Kangaro = animal.getAnimal("Kangaroo", true, true);
        Animal Rabbit = animal.getAnimal("Rabbit", true, false);
        Animal Turtle = animal.getAnimal("turtle", false, false);

        animals.add(fish);
        animals.add(Kangaro);
        animals.add(Rabbit);
        animals.add(Turtle);
        print(animals, j-> !j.canHop());

        StringFormat format = (String i) -> i.trim().toUpperCase();
        String name = formatString("John", format);
        Consumer<String> val = System.out::println;
        val.accept(name);

        StringFormat format1 = i -> {
            var value = "";
            BooleanSupplier isEmpty = ()-> i == null || i == " " || i.equals("");
            if(isEmpty.getAsBoolean()) {
                value = "SOMETIMES";
            }else{
                value = i;
            }

            return value.trim();
        };

        String name1 = formatString(null, format1);
        Consumer<String> val1 = System.out::println;
        val1.accept(name1);

        StringFormat format2 = j ->{
            BooleanSupplier contains = ()-> j.contains("j") || j.contains("J");
            if(contains.getAsBoolean())
                return "SI CONTIENE";
            else
                return j;
        };

        String name2 = formatString("John Jairo", format2);
        Consumer<String> val2 = System.out::println;
        val1.accept(name2);

        AnimalI a = (String j, boolean h, boolean i) -> new Animal("fish", false, true);
        Consumer<AnimalI> j = System.out::println;
        j.accept(a);

        animals.forEach((i)->{
            System.out.println(i.canHop());
        });
    }
}
