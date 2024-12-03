package FIT.AMADEUS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PercentageLetter {

  public static void main(String[] args) {
    System.out.println(percentageLetter("foobar", 'o'));
    System.out.println(countWords(new String[]{"a","ab"},
        new String[]{"a","a","a","ab"}));

  }

  private static int percentageLetter(String s, char letter) {
    int amount = 0;

    for (int j = 0; j < s.length(); j++) {
      if (s.charAt(j) == letter)
        amount += 1;
    }
    return amount * 100 / s.length();
  }

  private static int countWords(String[] words1, String[] words2) {
    List<String> list1 = new ArrayList<>(Arrays.asList(words1));
    List<String> list2 = new ArrayList<>(Arrays.asList(words2));
    list1.addAll(list2);
    Map<String, Long> map = list1.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    map.values().removeIf(i -> i != 2);
    return (int) map.entrySet().stream().count();
  }

}
