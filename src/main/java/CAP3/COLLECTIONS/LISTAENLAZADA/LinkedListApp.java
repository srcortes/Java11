package CAP3.COLLECTIONS.LISTAENLAZADA;

import java.util.function.Supplier;

public class LinkedListApp {
    public static void main(String[] args) {
        Supplier<SimpleLinkedList> supplier = SimpleLinkedList::new;
        SimpleLinkedList list = supplier.get();
        list.push(1.23);
        list.push(19.23);
        list.push(12.23);
        list.printContent();
        Node nodo = list.insert(19.23,78.4 );
        list.printContent();

        while(!list.isEmpty()){
            nodo = list.pop();
            System.out.println("Nodo elimoinado " + nodo);
            nodo.showContent();
        }

        list.printContent();
        list.push("Cat");
        list.push("Dog");
        list.printContent();

        list.delete("Cat");


    }
}
