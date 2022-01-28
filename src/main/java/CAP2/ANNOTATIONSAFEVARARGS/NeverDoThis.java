package CAP2.ANNOTATIONSAFEVARARGS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class example{
    public void test(Integer...i){

    }
}

public class NeverDoThis extends example {


    @SafeVarargs
    private void tests(Integer... i){

    }

    @SafeVarargs
    final int thisIsUnSafe(List<Integer>...carrot){
        Object[] stick = carrot;
        stick[0] = Arrays.asList("nope");
        return carrot[0].get(0);
    }

    public static void main(String[] args) {
        var carrot = new ArrayList<Integer>();
        new NeverDoThis().thisIsUnSafe(carrot);
    }
}
