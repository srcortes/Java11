package MODERNJAVA.PART2.SPLITITERATOR;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ReverseStringSplit implements Spliterator<String> {

    private final String str;
    private final int chunkSize;
    private int currentPos = 0;

    public ReverseStringSplit(String str, int chunkSize) {
        this.str = str;
        this.chunkSize = chunkSize;
    }

    @Override
    public boolean tryAdvance(Consumer<? super String> action) {
        if (currentPos >= str.length()) {
            return false; // no more chunks
        }
        int endPos = Math.min(currentPos + chunkSize, str.length());
        String chunk = str.substring(currentPos, endPos);

        action.accept(chunk);
        currentPos = endPos;
        return true;
    }

    @Override
    public Spliterator<String> trySplit() {

     
        int remaining = str.length() - currentPos;
        if (remaining < chunkSize * 2) return null; // Only split if enough left
        int splitPoint = currentPos + remaining / 2;
        ReverseStringSplit split = new ReverseStringSplit(str.substring(currentPos, splitPoint), chunkSize);
        this.currentPos = splitPoint;
        return split;
    }

    @Override
    public long estimateSize() {
        return str.length() - currentPos;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }

    public static void main(String[] args) {
        String chain = "John Jairo";
        ReverseStringSplit reverseStringSplit = new ReverseStringSplit(chain, 2);

       StreamSupport.stream(reverseStringSplit, true)
               .forEach(System.out::println);
    }
}
