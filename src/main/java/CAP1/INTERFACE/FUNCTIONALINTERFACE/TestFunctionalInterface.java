package CAP1.INTERFACE.FUNCTIONALINTERFACE;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Predicate;

class Person {
    private String name;
    private String lastName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

public class TestFunctionalInterface {

    public static void test(Person person, Predicate<Person> nombre){

        if(nombre.test(person)){
            System.out.println("It's");
        }
    }

    public static void main(String[] args) throws ParseException {
        /*String date = "January 13, 2020 4:01:50 PM EST";

        DateTimeFormatter dt = DateTimeFormatter.ofPattern("MMM d, yyyy h:mm:ss  a",
                Locale.ENGLISH);

        LocalDateTime ajDate = LocalDateTime.parse(date, dt);
        System.out.println(ajDate);*/

        String input = "January 13, 2020 4:01:50 EST";
        SimpleDateFormat parser = new SimpleDateFormat("EEE MMM d, HH:mm:ss zzz");
        Date date = parser.parse(input);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(date);

        System.out.println(formattedDate);


        Person person = new Person();
        person.setName("John");
        person.setLastName("Rodriguez");

        Person person1 = null;

        TestFunctionalInterface.test(person1, Objects::isNull);
    }

}
