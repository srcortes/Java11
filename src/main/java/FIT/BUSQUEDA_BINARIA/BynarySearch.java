package FIT.BUSQUEDA_BINARIA;

import java.util.Arrays;
import java.util.function.*;

public class BynarySearch {
    public static void main(String[] args) {
        int[] array = { 14, 19, 10, 26, 27, 42, 44, 31, 33, 35};

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        BinaryOperator<Integer> newMiddle = (val1, val2) -> (val1 + val2) / 2;
        int begin = 0, end = array.length -1, find = 26, middle = newMiddle.apply(begin, end), position = -1;

        while((begin <= end) ){

            IntPredicate intPredicate = val -> find > val;
            UnaryOperator<Integer> sum = val -> val + 1;
            UnaryOperator<Integer> sustract = val -> val - 1;


            if(find == array[middle]){
                position = middle;
                break;
            }


            if(intPredicate.test(array[middle])) {
                begin = sum.apply(middle);
            } else {
                end = sustract.apply(middle);
            }
            middle = newMiddle.apply(begin,end);

        }

        if(position == -1 ){
            System.out.println("The number:" + find + " It was not found");
        } else {
            System.out.println("The number: " + find + " se encuentra en la position:" + position );
        }

    }
}
