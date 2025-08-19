package MODERNJAVA.PART2.SPLITITERATOR;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.StreamSupport;

public class BatchSpliterator implements Spliterator<List<String>> {
    private final List<String> source;
    private final int batchSize;
    private int current;

    public BatchSpliterator(List<String> source, int batchSize) {
        this.source = source;
        this.batchSize = batchSize;
        this.current = 0;
    }

    @Override
    public boolean tryAdvance(Consumer<? super List<String>> action) {
        System.out.println("******* TryAdvanced ******");
        if (current >= source.size()) return false;
        int end = Math.min(current + batchSize, source.size());
        action.accept(source.subList(current, end));
        current = end;
        return true;
    }

    @Override
    public Spliterator<List<String>> trySplit() {
        System.out.println("******* TrySplit ******");
        int remaining = source.size() - current;
        System.out.println(remaining);

        if (remaining <= batchSize * 2) return null; // Only split if enough left
        int splitPoint = current + remaining / 2;
        BatchSpliterator split = new BatchSpliterator(source.subList(current, splitPoint), batchSize);
        this.current = splitPoint;
        return split;
    }

    @Override
    public long estimateSize() {
        return (source.size() - current + batchSize - 1) / batchSize;
    }

    @Override
    public int characteristics() {
        return ORDERED | NONNULL | SIZED | SUBSIZED;
    }

    // Demo
    public static void main(String[] args) {
        List<String> bigList = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight"
        );

        Spliterator<List<String>> spliterator = new BatchSpliterator(bigList, 2);

        StreamSupport.stream(spliterator, false)
                .forEach(batch -> System.out.println("Batch: " + batch));
    }
}