package CAP1.FINALMODIFIER;

class ExampleFinalMethod{
    public String exampleFinal(){
        return "1";
    }
}

public class FinalMethodExample extends ExampleFinalMethod {
    public final String exampleFinal(){
        return "1";
    }

}
