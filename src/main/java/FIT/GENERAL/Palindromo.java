package FIT.GENERAL;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Palindromo {

    public static void operationOverString(String value, Consumer<String> consumer) {
        consumer.accept(value);
    }

    public static boolean verifyValues(String value, Predicate<String> predicate){
        return predicate.test(value);
    }


    public static void main(String[] args) {
        String value = "Moon";

        Palindromo.operationOverString(value, val -> {
            int decr = value.length() - 1;
            int incr = 0;
            boolean isError = false;

            while ((incr < decr) && (!isError)) {
                if (val.charAt(incr) == val.charAt(decr)) {
                    incr++;
                    decr--;
                } else {
                    isError = true;
                }
            }

            if (!isError)
                Palindromo.operationOverString("Es palindromo", System.out::println);
            else
                Palindromo.operationOverString("No es palindromo", System.out::println);

        });
    }
}
