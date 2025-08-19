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

        System.out.println("******* TrySplit ******");
        int remaining = str.length() - currentPos;


        if (remaining < 3) return null; // Only split if enough left
        int splitPoint = currentPos + remaining / 2;
        ReverseStringSplit split = new ReverseStringSplit(str, chunkSize);
        this.currentPos = splitPoint;
        return split;
    }

    @Override
    public long estimateSize() {
        return 0;
    }

    @Override
    public int characteristics() {
        return 0;
    }

    public static void main(String[] args) {
        ReverseStringSplit reverseStringSplit = new ReverseStringSplit("John Jairo", 4);

       StreamSupport.stream(reverseStringSplit, true)
               .forEach(System.out::println);
    }
}
