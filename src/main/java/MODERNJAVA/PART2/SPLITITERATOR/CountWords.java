package MODERNJAVA.PART2.SPLITITERATOR;

import java.util.Objects;
import java.util.Optional;

public class CountWords {
    public static int  count(String value){
        int counter = 0;
        boolean lastSpace = true;
        for(char c : value.toCharArray()){
            if(Character.isWhitespace(c)){
                lastSpace = true;
            }else{
                if(lastSpace) counter++;
                lastSpace= false;
            }
        }
        return counter;
    }


    public static void main(String[] args) {
        System.out.println(CountWords.count("john   jairo"));
    }
}
