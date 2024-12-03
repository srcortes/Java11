package MODERNJAVA.PART2.PRACTICESTREAM;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExecutionTrader {
    public static void main(String[] args) {
        Trader raoul =  new Trader("Raoul", "Cambridge");
        Trader mario =  new Trader("Mario", "Milan");
        Trader alan =  new Trader("Alan", "Cambridge");
        Trader brian =  new Trader("Brian", "Cambridge");

        List<Transaction> transaction = Arrays.asList(new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012,700),
                new Transaction(alan, 2012, 950));

        transaction.stream().filter(j -> j.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
        transaction.stream().map(j -> j.getTrader().getCity()).distinct().forEach(System.out::println);
        transaction.stream().filter(j->j.getTrader().getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(k -> k.getTrader().getName())).forEach(System.out::println);
        String traders = transaction.stream().map(j -> j.getTrader().getName()).sorted().reduce((a,b) -> a + b)
                .map(String::toString).orElseGet(()->"");
        String traders2 = transaction.stream().map(j->j.getTrader().getName()).sorted().collect(Collectors.joining());
        System.out.println(traders + "::::"+ traders2);

        /**
         * HERE WE'RE GROUPING CITIES AND ITS PERSON KEYS.
         */
        Map<String, List<Trader>> map = transaction.stream().map(Transaction::getTrader).distinct()
                .collect(Collectors.groupingBy(Trader::getCity));
        System.out.println("*****" + map);

        boolean isMilan = transaction.stream().map(Transaction::getTrader).anyMatch(j -> j.getCity().equals("Milan"));
        System.out.println(isMilan);

        boolean isColombian = transaction.stream().map(Transaction::getTrader).noneMatch(j -> j.getCity().equals("Colombia"));
        System.out.println(isColombian);

        transaction.stream().filter(j -> j.getTrader().getCity().equals("Cambridge"))
        .map(Transaction::getValue).forEach(System.out::println);

        Integer value = transaction.stream().map(Transaction::getValue).reduce(Integer::max).orElse(0);
        System.out.println(value);

        Integer value2 = transaction.stream().map(Transaction::getValue).reduce(Integer::min).orElse(0);
        System.out.println(value2);

        Integer value3 = transaction.stream()
                .reduce(BinaryOperator.minBy(Comparator.comparing(Transaction::getValue)))
                .map(Transaction::getValue).orElse(0);
        System.out.println(value3);

        Integer value4 = transaction.stream().mapToInt(Transaction::getValue).max().getAsInt();
        System.out.println(value4);

        IntStream value5 = transaction.stream().mapToInt(Transaction::getValue);

        List<Integer> value7 = value5.boxed().collect(Collectors.toList());
        System.out.println(value7);

        Map<Integer, String> person = new HashMap<>();
        person.put(63545795, "July Mora");
        person.put(80217780, "John Jairo");

        IntStream ids = person.keySet().stream().mapToInt(s -> s);
        List<Integer> listIds = person.keySet().stream().mapToInt(s -> s).boxed().collect(Collectors.toList());
        List<Integer> listId = ids.boxed().collect(Collectors.toList());
        System.out.println(listId);

        OptionalInt value8 = person.keySet().stream().mapToInt(j -> j).max();
        System.out.println(value8.orElseThrow(() -> new RuntimeException("...")));


        System.out.println(IntStream.rangeClosed(1, 5).filter(j -> j % 2 == 0).count());

        /**
         * To remember using % 1 in a decimal number we can get fractional part, for instances
         * here  we get 0.0
         */
        System.out.println(5.0 % 1);


    }
}
