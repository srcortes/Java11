package MODERNJAVA.PART2.COLLECTORS.CUSTOMERCOLLECTOR;



import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;


public class PrimeNumberCollector implements Collector<Integer, Map<Boolean, List<Integer>>,
    Map<Boolean, List<Integer>>>{

  @Override
  public Supplier<Map<Boolean, List<Integer>>> supplier() {
    return ()->new HashMap<Boolean, List<Integer>>(){{
      put(true, new ArrayList<Integer>());
      put(false, new ArrayList<Integer>());
    }};
  }

  @Override
  public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
    return (Map<Boolean, List<Integer>> acc, Integer candidate)
        -> acc.get(isPrimeV1(acc.get(true), candidate)).add(candidate);
  }

  @Override
  public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
    return null;
  }


  @Override
  public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
    return Function.identity();
  }
  @Override
  public Set<Characteristics> characteristics() {

    return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
  }
  public static boolean isPrimeV1(List<Integer> primes, int candidate){
    int candidateRoot = (int) Math.sqrt(candidate);
    return primes.stream().takeWhile(i->i <= candidateRoot)
        .peek(i->System.out.println("i: "+i))
        .noneMatch(i->candidate % i == 0);
  }
}
