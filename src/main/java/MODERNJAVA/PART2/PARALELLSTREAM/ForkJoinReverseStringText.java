package MODERNJAVA.PART2.PARALELLSTREAM;

import java.time.LocalDateTime;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;


public class ForkJoinReverseStringText extends RecursiveTask<String> {

    public static final long THRESHOLD = 5;

    private final String chain;

    public ForkJoinReverseStringText(String chain){
        this.chain = chain;
    }



    @Override
    protected String compute() {
        int length = chain.length();
        if (length <= THRESHOLD) {
            return reverseString();
        }

        ForkJoinReverseStringText leftTask = new ForkJoinReverseStringText(chain.substring(0, chain.length() / 2));
        leftTask.fork();

        ForkJoinReverseStringText rigthTask = new ForkJoinReverseStringText(chain.substring(chain.length() / 2));
        String first =  rigthTask.compute();
        String leftResult = leftTask.join();

        return first + leftResult;
    }

    private String reverseString() {

        StringBuilder newValue= new StringBuilder();

        for(int j = chain.length() - 1; j>= 0 ; j--){
            newValue.append(chain.charAt(j));
        }

        return newValue.toString();
    }



    public static String sum(String  value) {
        ForkJoinTask<String> task = new ForkJoinReverseStringText(value);
        return new ForkJoinPool().invoke(task);
    }

}
