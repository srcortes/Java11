package CAP3.COLLECTIONS.LIST;

import java.util.*;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;


class Person{
    private long id;
    private String nombre;

    Person(long id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return nombre + "  " + id;
    }

    @Override
    public boolean equals(Object obj){
        BooleanSupplier isNull = ()-> obj == null;
        BooleanSupplier isAnInstance = () -> obj instanceof Person;
        BooleanSupplier areSameObject = ()-> false;

        if(isNull.getAsBoolean()){
            return areSameObject.getAsBoolean();
        }

        if(isAnInstance.getAsBoolean()){
            Person person = (Person) obj;
            areSameObject = ()-> this.id == person.id && this.nombre.equalsIgnoreCase(nombre);
        }

        return areSameObject.getAsBoolean();
    }
}

public class FirtsTest {

    @FunctionalInterface
    interface GetObjectPerson{
        Person person(long id, String nombre);
    }

    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("this is a example");

        Consumer<Collection<String>> consumer = System.out::println;
        consumer.accept(list);

        GetObjectPerson getObjectPerson = Person::new;
        Person john = getObjectPerson.person(80217780L, "John Jairo");
        Person july = getObjectPerson.person(60545795L, "July Joanne");
        Person julyRemove = getObjectPerson.person(60545795L, "July Joanne");

        Collection<Person> listPersons = new ArrayList<>();
        listPersons.add(john);
        listPersons.add(july);

        Consumer<Collection<Person>> printPerson = System.out::println;
        printPerson.accept(listPersons);

        listPersons.forEach(j->{
            System.out.println(j);
        });

        listPersons.removeIf(i->i.equals(julyRemove));

        Consumer<Boolean> printContainsPerson = System.out::println;
        printContainsPerson.accept(listPersons.contains(julyRemove));

        //listPersons.remove(julyRemove);
        printPerson.accept(listPersons);


    }


}
