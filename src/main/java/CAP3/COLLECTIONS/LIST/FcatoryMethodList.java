package CAP3.COLLECTIONS.LIST;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FcatoryMethodList {
    public static void main(String[] args) {
        String[] arrayTest = {"John","Mariana","Gabriela"};
        List<String> listNames = Arrays.asList(arrayTest);
        listNames.forEach(i->{
            System.out.println(i);
        });

        List<String> listNamesNewVersion = List.of(arrayTest);
        Consumer<List<String>> printListNewVersion = System.out::println;
        printListNewVersion.accept(listNamesNewVersion);

        List<String> listInmutableName = List.copyOf(listNamesNewVersion);
        printListNewVersion.accept(listInmutableName);


    }
}
