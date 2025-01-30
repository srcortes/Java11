package MODERNJAVA.PART2.COLLECTORS.CUSTOMERCOLLECTOR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StringNameCollector implements Collector<String, List<String>, List<String>> {

  @Override
  public Supplier<List<String>> supplier() {
    return ArrayList::new;
  }

  @Override
  public BiConsumer<List<String>, String> accumulator() {
    return  (List<String> list, String element) -> {
      if (algo(list, element)) {
        list.add(element);
      }
    };
  }

  @Override
  public BinaryOperator<List<String>> combiner() {
     return (list1, list2) -> {
      list2.stream()
          .filter(element -> algo(list1, element))
          .forEach(list1::add);
      return list1;
    };
  }

  @Override
  public Function<List<String>, List<String>> finisher() {
    return Function.identity();
  }

  @Override
  public Set<Characteristics> characteristics() {
    return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
  }

  private boolean algo(List<String> list, String element) {
    return list.stream().noneMatch(e -> e.equals(element));
  }
}
