package CAP1.FINALMODIFIER;

class TestFinalModifier{
    final String prueba(){
        return null;
    }
}

class TestFinalModifierExtends extends TestFinalModifier{
    String prueba(String a){
        return "A";
    }
}

/**
 *
 */
public class PolarBear {
    final int age = 10;
    final int fishEaten;
    final String name;
    final static String lastName;
    static String code;

    {
        fishEaten = 10;
    }

    static{
        lastName = "rodriguez";
    }

    public PolarBear(){
        name = "John";

    }
}
