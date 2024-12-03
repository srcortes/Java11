package FIT.GENERAL;

import java.util.function.Consumer;
import java.util.function.Function;

public class ReverseString {
    static String value = "software";
    static StringBuilder newValue = new StringBuilder();

    public static String reverseString(StringBuilder value, Function<StringBuilder, String> function) {
        return function.apply(value);
    }

    public static void printInfo(String value, Consumer<String> consumer) {
        consumer.accept(value);
    }

    public static void main(String[] args) {
        ReverseString.reverseString(newValue, val -> {
            int count = value.length() - 1;
            while(count >= 0) {
                val.append( value.charAt(count));
                count--;
            }

            return val.toString();
        });
        ReverseString.printInfo(newValue.toString(), System.out::println);
    }
}
