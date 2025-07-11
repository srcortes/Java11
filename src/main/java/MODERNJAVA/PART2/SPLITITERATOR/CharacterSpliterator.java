package MODERNJAVA.PART2.SPLITITERATOR;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

public class CharacterSpliterator implements Spliterator<Character> {

    private final String source;
    private int currentIndex;
    private final int endIndex;

    /**
     * Constructor for a CharacterSpliterator.
     *
     * @param source The string to iterate over.
     * @param start  The starting index (inclusive).
     * @param end    The ending index (exclusive).
     */
    public CharacterSpliterator(String source, int start, int end) {
        this.source = source;
        this.currentIndex = start;
        this.endIndex = end;
    }

    /**
     * Default constructor, covering the entire string.
     * @param source The string to iterate over.
     */
    public CharacterSpliterator(String source) {
        this(source, 0, source.length());
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        if (currentIndex < endIndex) {
            action.accept(source.charAt(currentIndex));
            currentIndex++;
            return true;
        }
        return false;
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = endIndex - currentIndex;
        if (currentSize < 10) { // Arbitrary threshold for splitting
            return null; // Don't split if too small
        }

        // Calculate a split point roughly in the middle
        int splitPoint = currentIndex + currentSize / 2;

        // Ensure we don't split in the middle of a surrogate pair if dealing with Unicode.
        // For simplicity with basic Latin characters, this might not be strictly necessary,
        // but it's good practice for general character handling.
        // In a real-world scenario with full Unicode, you'd want more robust handling
        // (e.g., Character.isHighSurrogate, Character.isLowSurrogate).
        // For this example, we'll keep it simpler assuming common characters.

        if (splitPoint > currentIndex && splitPoint < endIndex) {
            // Create a new Spliterator for the first half
            Spliterator<Character> newSpliterator = new CharacterSpliterator(source, currentIndex, splitPoint);
            // Update this Spliterator to cover the second half
            this.currentIndex = splitPoint;
            return newSpliterator;
        }
        return null; // No suitable split found
    }

    @Override
    public long estimateSize() {
        return endIndex - currentIndex;
    }

    @Override
    public int characteristics() {
        // Here we declare the characteristics of our Spliterator.
        // SIZED: The estimateSize() method returns an exact size.
        // SUBSIZED: If we split, the new spliterator and this one will also be SIZED and their combined sizes will be equal to the original.
        // ORDERED: The elements are traversed in a defined order (the string's character order).
        // IMMUTABLE: The underlying source (String) is immutable.
        // NONNULL: Characters are never null.
        return SIZED | SUBSIZED | ORDERED | IMMUTABLE | NONNULL;
    }

    public static void main(String[] args) {
        String text = "Hello, World! This is a test string for Spliterator.";
        List<String> words = Arrays.asList(text.split("\\s+")); // Splits by one or more whitespace
        Spliterator<String> wordSpliterator = words.spliterator();
        System.out.println(wordSpliterator.estimateSize());
        wordSpliterator.forEachRemaining(word -> System.out.println("Word: " + word));
        System.out.println(wordSpliterator.estimateSize());




      
    }
}

