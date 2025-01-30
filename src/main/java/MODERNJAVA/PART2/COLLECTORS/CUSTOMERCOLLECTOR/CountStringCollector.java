package MODERNJAVA.PART2.COLLECTORS.CUSTOMERCOLLECTOR;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CountStringCollector implements Collector<String, Map<String, Integer>, Map<String, Integer>> {

  @Override
  public Supplier<Map<String, Integer>> supplier() {
    return HashMap::new;
  }

  @Override
  public BiConsumer<Map<String, Integer>, String> accumulator() {
    return (Map<String, Integer> map, String element) ->{
      Integer outcome = identifyElementInsideMap(map, element);
      map.put(element, outcome+1);

    };
  }

  @Override
  public BinaryOperator<Map<String, Integer>> combiner() {
    return null;
  }

  @Override
  public Function<Map<String, Integer>, Map<String, Integer>> finisher() {
    return Function.identity();
  }

  @Override
  public Set<Characteristics> characteristics() {
    return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
  }
    private Integer identifyElementInsideMap(Map<String, Integer> map, String element){
         return Math.toIntExact(map.entrySet().stream().filter(j -> element.equals(j.getKey()))
             .count());

    }
}
