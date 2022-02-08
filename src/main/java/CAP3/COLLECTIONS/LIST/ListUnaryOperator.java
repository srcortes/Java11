package CAP3.COLLECTIONS.LIST;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ListUnaryOperator {
    public static void main(String[] args) {
        Supplier<List<String>> initialListAnimals = ArrayList::new;
        List<String> listAnimal = initialListAnimals.get();
        listAnimal.add("Lion");
        listAnimal.add("Monkey");
        listAnimal.add("bee");
        listAnimal.add("elephant");

        listAnimal.replaceAll(x-> x.substring(0,1).toUpperCase().concat(x.substring(1).trim()));

        Consumer<List<String>> printList = System.out::println;
        printList.accept(listAnimal);

        listAnimal.forEach(System.out::println);

        ListIterator<String> iterator = listAnimal.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        /*HERE AS LISTITERATOR OBJECT GOING TO SEE THE LIST IN INVERSE ORDER*/
        while(iterator.hasPrevious()){
            System.out.println("Inverse Value: " + iterator.previous());
        }

        /*HERE WE'VE CREATED A INMUTABLE LIST AS OF LISTANIMAL*/
        List<String> wildLife = List.copyOf(listAnimal);
        printList.accept(wildLife);

        List<String> wildLife2 = new ArrayList<>(wildLife);
        wildLife2.add("butterfly");
        printList.accept(wildLife2);


    }
}
