package MODERNJAVA.PART1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;


@FunctionalInterface
interface BookTest<T>{
    T name(T b);
}

@FunctionalInterface
interface PrintPart<T>{
    String information(T t);
}
class Book {
    private String nameBook;
    private boolean isStock;

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public boolean isStock() {
        return isStock;
    }

    public void setStock(boolean stock) {
        isStock = stock;
    }

    @Override
    public String toString(){
        return nameBook +"  "+ isStock;
    }
}

class BookLend{
    private String nameBook;
    private boolean isStock;

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public boolean isStock() {
        return isStock;
    }

    public void setStock(boolean stock) {
        isStock = stock;
    }

    @Override
    public String toString(){
        return nameBook +"  "+ isStock;
    }

}

public class TestPredicate {

    public static BookLend transform(Book b, Function<Book, BookLend> change) {
        BookLend bookLend = change.apply(b);
        bookLend.setNameBook(b.getNameBook());
        return bookLend;
    }

    public static void printLogObjectCreated(BookTest t, Object ob, Consumer<Object> c) {
        c.accept(t.name(ob));
    }

    public static void partialInformation(String message, Consumer<Object> c){
        c.accept(message);
    }


    public static<T> boolean filtersBook(List<T> list, Predicate<T> predicate) {
        for(T t : list) {
           if(predicate.test(t)) {
               return true;
           }
        }

        return false;
    }

    public static RuntimeException getException(String message) {
        Function<String, RuntimeException> algo = RuntimeException::new;
        return algo.apply(message);
    }



    public static void main(String[] args) {
        Book book = new Book();
        book.setNameBook("Harry potter");
        book.setStock(false);

        Book book1 = new Book();
        book1.setNameBook("Inteligencia emocional");
        book1.setStock(true);



        List<Book> listBooks = new ArrayList<>();
        listBooks.add(book1);
        listBooks.add(book);
        System.out.println(listBooks);

        listBooks.sort(Comparator.comparing(Book::getNameBook));

        System.out.println(listBooks);

        boolean response = TestPredicate.filtersBook(listBooks, j -> !j.isStock());

        TestPredicate.printLogObjectCreated((Object b) -> b, book1,
                value -> System.out.println("value: " + value));

        TestPredicate.partialInformation("Object created::::: ", System.out::println);


        //INTPREDICATE
        IntPredicate sumTotalNumbers = (i) -> i > 0;
        System.out.println(sumTotalNumbers.test(45));

        BookLend bookLend = TestPredicate.transform(book1, (value) ->  new BookLend());
        System.out.println(bookLend.getNameBook());

        if (response) {
            throw TestPredicate.getException("There is not book in stock");
        }
    }
}
