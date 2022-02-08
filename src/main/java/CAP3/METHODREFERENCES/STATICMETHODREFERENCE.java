package CAP3.METHODREFERENCES;


import java.util.function.Consumer;
import java.util.function.Function;

class Person{
    private String id;
    private String nombre;
    private static String cargo;

    public Person(String id, String nombre){
        this.nombre = nombre;
        this.id = id;
    }

    @Override
    public String toString(){
        return id +" - "+ nombre + " - " + cargo;
    }

    public static String getCargo() {
        return cargo;
    }

    public static void setCargo(String cargo) {
        Person.cargo = cargo;
    }

    public static String rol(String rol){
        cargo = rol;
        return cargo;
    }
}

@FunctionalInterface
interface GetPerson{
    Person person(String id, String nombre);
}

@FunctionalInterface
interface SetRol{
    String assignRol(String rol);
}

@FunctionalInterface
interface Print{
    void valuePrint(String value);
}

public class STATICMETHODREFERENCE {

    public static void printValue(String h){
        System.out.println(h);
    }


    public static void main(String[] args) {
        GetPerson getPerson = Person::new;
        Person p = getPerson.person("80217780", "John Rodriguez");

        /**
         * Here there is a example about reference method with a funcional interface
         */
        /*SetRol setRol = Person::rol;
        Person.setCargo(setRol.assignRol("Ingeniero software"));*/

        /**
         * Here there is a example about method reference with labmda
         */
        /*SetRol setRol = i -> Person.rol(i);
        Person.setCargo(setRol.assignRol("Tech lead"));*/

        /*Function<String, String> personFunction = Person::rol;
        String rol = personFunction.apply("Ingeniero software expert");
        Person.setCargo(rol);*/

        Function<String, String> person = i -> Person.rol(i);
        person.apply("Tech manager");

        System.out.println(p);

        Print print = STATICMETHODREFERENCE::printValue;
        print.valuePrint("print value....");

        Consumer<String> function = STATICMETHODREFERENCE::printValue;
        function.accept("prnt value2...");

    }
}
