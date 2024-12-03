package MODERNJAVA.PART2.COLLECTORS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ToArraysCollector<T> implements Collector<T, List<T>, T[]> {

  @Override
  public Supplier<List<T>> supplier() {
    return ArrayList::new;
  }

  @Override
  public BiConsumer<List<T>, T> accumulator() {
    return List::add;
  }

  @Override
  public BinaryOperator<List<T>> combiner() {
    return (left, right) -> {
      left.addAll(right);
      return left;
    };
  }

  @Override
  public Function<List<T>, T[]> finisher() {
    return list -> list.toArray((T[]) java.lang.reflect.Array.newInstance(Department.class, list.size()));
  }

  @Override
  public Set<Characteristics> characteristics() {
    return EnumSet.noneOf(Characteristics.class);
  }
}
