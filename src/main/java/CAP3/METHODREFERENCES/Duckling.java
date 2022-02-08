package CAP3.METHODREFERENCES;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

interface getObject{
    Duckling getDuckling(String sound);
}

@FunctionalInterface
interface getString{
    void testMethod(String value);
}

@FunctionalInterface
interface VerifyFirtLetter{
    boolean startWithValue(String j);
}

public class Duckling {

    private String sound;

    public Duckling(String sound){
        this.sound = sound;
    }

    static void staticTest(String value){
        System.out.println(value);
    }

    @Override
    public String toString(){
        return sound;
    }

    public static void main(String[] args) {
        getObject duckling = Duckling::new;
        var d = duckling.getDuckling("...");

        List<Integer> number = new ArrayList<>();
        number.add(1);
        number.add(5);
        number.add(2);

        LearntoSpeak learntoSpeak = System.out::println;
        learntoSpeak.speak("hola");
        System.out.println(number);
        System.out.println(d);

        //Consumer<List<Integer>> consumer = Collections::sort;
        //consumer.accept(number);
        Consumer<List<Integer>> consumer = i -> Collections.sort(i);
        consumer.accept(number);
        System.out.println(number);

        Consumer<String> ducklingConsumer = Duckling::staticTest;
        ducklingConsumer.accept("hello my friend");

        getString h = Duckling::staticTest;
        h.testMethod("hello my friend 2");
        getString h1 = i -> Duckling.staticTest(i);
        h1.testMethod("hello my friend 3");

        String value = "john jairo";
        /*VerifyFirtLetter verifyFirtLetter = t -> value.startsWith(t);
        boolean responde = verifyFirtLetter.startWithValue("u");*/

        /*VerifyFirtLetter verifyFirtLetter = value::startsWith;
        boolean responde = verifyFirtLetter.startWithValue("j");*/

        /*Function<String, Boolean> function = value::startsWith;
        boolean responde = function.apply("j");*/

        /*Consumer<Boolean> consumer1 = System.out::println;
        consumer1.accept(responde);*/

    }
}
