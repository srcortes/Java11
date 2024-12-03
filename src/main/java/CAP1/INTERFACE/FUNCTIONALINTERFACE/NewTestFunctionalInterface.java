package CAP1.INTERFACE.FUNCTIONALINTERFACE;


import java.time.LocalDate;
import java.util.function.Consumer;

interface Prueba{
  String someExample();
}

class Test{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class NewTestFunctionalInterface {

    public static void newTest(Prueba p) {
        p = () -> "Hello";
    }

    public String prueba(String v){
        if(v.isEmpty()) {
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        String  date = "01/01/1960;";
        boolean newDate = date.contains(";");
        if(newDate) {
            date  = date.replace(";","");
        }

        System.out.println(date);

        NewTestFunctionalInterface n = new NewTestFunctionalInterface();

        System.out.println(n.prueba("") == null);




        /*Prueba p = () -> "Hello";
        Consumer<Test> c = (Test) -> new Test();

        System.out.println(p.someExample());
        NewTestFunctionalInterface.newTest(Prueba);*/

    }
}
