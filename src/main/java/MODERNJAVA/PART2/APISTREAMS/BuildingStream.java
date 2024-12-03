package MODERNJAVA.PART2.APISTREAMS;

import java.util.stream.Stream;

class Product{
    private String nameProduct;

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
}

public class BuildingStream {
    public static void main(String[] args) {

        Stream<String> stream = Stream.of("John", "Jairo", "Rodriguez");
        stream.map(String::toUpperCase).forEach(System.out::println);

        /**
         * WE CAN CREATE TO EMPTY STREA
         */
        Stream<String> stream1 = Stream.empty();

        /**
         * Stream.ofNullable allows us to controller when some object comes null.
         */
        Product p = null;
        Stream<Product> stream2 = Stream.of(p);
        stream2.map(Product::getNameProduct).map(String::toUpperCase).forEach(System.out::println);

    }
}
