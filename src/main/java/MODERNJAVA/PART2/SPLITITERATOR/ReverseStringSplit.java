package MODERNJAVA.PART2.SPLITITERATOR;

import java.util.Spliterator;
import java.util.function.Consumer;

public class ReverseStringSplit implements Spliterator<String> {
    @Override
    public boolean tryAdvance(Consumer<? super String> action) {
        return false;
    }

    @Override
    public Spliterator<String> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return 0;
    }

    @Override
    public int characteristics() {
        return 0;
    }
}
