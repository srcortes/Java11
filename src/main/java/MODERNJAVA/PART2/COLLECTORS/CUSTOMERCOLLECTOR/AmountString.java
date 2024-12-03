package MODERNJAVA.PART2.COLLECTORS.CUSTOMERCOLLECTOR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class AmountString implements Collector<String, Map<String,Integer>, Map<String, Integer>> {

  @Override
  public Supplier<Map<String, Integer>> supplier() {
    return HashMap::new;
  }

  @Override
  public BiConsumer<Map<String, Integer>, String> accumulator() {
    return (map, value) -> map.put(algo(), value);
  }

  @Override
  public BinaryOperator<List<String>> combiner() {
    return null;
  }

  @Override
  public Function<List<String>, Integer> finisher() {
    return null;
  }

  @Override
  public Set<Characteristics> characteristics() {
    return null;
  }

  private static boolean algo(List<String> info, String value){
    long outcome = info.stream().filter(value::equals).count();
    return outcome >= 2;
  }
}
