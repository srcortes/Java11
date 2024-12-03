package FIT.BUSQUEDA_BINARIA;

import java.util.Arrays;
import java.util.Objects;

public class BynarySearchString {

    private static String chainFound = "John";
    private static int position = -1;

    public static int findValue(String[]array){
        int begin = 0;
        int end = array.length - 1;
        int middle = (begin + end) / 2;


        while(begin <= end){

            if (Objects.equals(chainFound, array[middle])) {
               position = middle;
            }

            if(chainFound.length() > array[middle].length()){
                begin = middle + 1;
            } else {
                end = middle - 1;
            }
            middle = (begin + end) / 2;
        }

        return position;

    }

    public static void main(String[] args) {
        String array[] = {"John", "Mariana", "July", "Gaby"};
        Arrays.sort(array);
        System.out.println(chainFound + ", se encuentra en la posicion: " + BynarySearchString.findValue(array));

    }
}
