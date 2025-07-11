package MODERNJAVA.PART2.PARALELLSTREAM;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {



    private final long[] numbers;
    private final int start;
    private final int end;
    public static final long THRESHOLD = 3;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }


    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {

           System.out.println(computeDirectly());
            return computeDirectly();
        }

        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        System.out.println(start +"----"+ (start + length / 2) );
        leftTask.fork(); // asynchronously execute the left task

        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        System.out.println("----" + (start + length / 2) + " - " + end   );
        Long rightResult = rightTask.compute(); // synchronously execute the right task
        Long leftResult = leftTask.join(); // join the left task result
        System.out.println("***" + rightResult +" - "+ leftResult);
        return rightResult + leftResult; // combine the results
    }

    private Long computeDirectly() {
        long sum = 0;
        for (int i = start; i < end; i++) {

            sum += numbers[i];
        }
        return sum;
    }

    public static long sum(long number) {
        long[] numbers = LongStream.rangeClosed(1, number).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }
}
