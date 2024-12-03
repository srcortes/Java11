package MODERNJAVA.PART2.OPTIONAL;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.xml.datatype.DatatypeConfigurationException;
import java.util.*;
import java.util.stream.Collectors;
enum Status {
    PENDING,
    ERROR,
    READY;
}

class PersonInscription{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private Status status;


}
class MessageAlternative {
    private String message;



    public MessageAlternative(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


public class ExampleOptional {

    private static String company;

    public Set<String> getInsuranceNames(List<Person> persons) {
         Set<String> stream = persons.stream().map(Person::getCar).map(j->j.flatMap(Car::getInsurance))
                .map(u->u.map(Insurance::getName)).flatMap(Optional::stream).collect(Collectors.toSet());


        return null;
    }

    public static Optional<String> verifyNullOrEmpty(Optional<Person> person){
        return person.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName);
    }

    public static void showMessage(PersonInscription personInscription){
        System.out.println(personInscription.getName() + " - " + personInscription.getStatus());
    }


    public static void evaluate(String name){
        company = name.toUpperCase();
        System.out.println(company);
    }


    public static void evaluateEmpty(String name) {
        company = name;
        System.out.println(company);
    }



    public static void main(String[] args) throws DatatypeConfigurationException {
        Person person = new Person();
        person.setAge(20);
        Person person2 = null;
        Car car = new Car();
        Car car2 = null;
        Optional<Car> optionalCar = Optional.ofNullable(car);

        Insurance insurance = new Insurance();
        insurance.setName(null);
        insurance.setPrice(15.0);
        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
        car.setInsurance(optionalInsurance);
        person.setCar(optionalCar);

        /**
         *  THERE ARE THREE WAYS TO CREATE A OPTIONAL
         *  Optional.empty()
         *  Optional.of(Object)
         *  Optional.ofNullable(Object)
         */
        Optional<Person> optPerson = Optional.of(person);
        /**
         * Method get() to obtain the optional value, if optional is empty
         * a exception is throw.
         */
        optPerson.get();

        /**
         * orElse method allow us to get a default value when optional doesn't contains a value
         */
        Double op = optPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getPrice)
                .orElse(0.0);
        System.out.println(op +  " - " + System.currentTimeMillis());

        String nameInsurance = optPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Insurance does not contain name");
        System.out.println(nameInsurance);
        System.out.println(optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).isPresent());

        /**
         * orElseGet is only called when the value about Optional,ispresent() is false
         */
        String nameCompany = optPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElseGet(() -> new MessageAlternative("Error controlado").getMessage());
        System.out.println(nameCompany +" - "+ System.currentTimeMillis());

        /**
         * Or it is a method that return other optional, if the original optional is empty
         */
        Optional<String> evaluateData =  optPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName).or(()-> Optional.of("algo"));

        /**
         * To reminder also we can use stream as of optional.
         */
        double total = optionalInsurance.stream().map(Insurance::getPrice).mapToDouble(v->v).sum();
        System.out.println("Use of stream as of optional: " + total);

        /**
         * Checking if exists value, if value don't exists don't do anything
         */
        optPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance).map(Insurance::getName).ifPresent(ExampleOptional::evaluate);


        /**
         * If value don't exists evaluate the second action.
         */
        optPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance).map(Insurance::getName).ifPresentOrElse(ExampleOptional::evaluate
                        , () -> ExampleOptional.evaluateEmpty("NO APLICA"));

        Optional<String> algo = ExampleOptional.verifyNullOrEmpty(Optional.ofNullable(person2));
        System.out.println(algo);

        /**
         * Filter Optional allow us filter information and then perform some operation.
         */
        PersonInscription personInscriptionOne = new PersonInscription();
        personInscriptionOne.setName("John");
        personInscriptionOne.setStatus(Status.ERROR);

        Optional<PersonInscription> optionalPersonInscription = Optional.of(personInscriptionOne);
        optionalPersonInscription.filter(value -> Status.ERROR.equals(value.getStatus()))
                .ifPresent(ExampleOptional::showMessage);

        optionalPersonInscription.filter(ready -> Status.READY.equals(ready.getStatus()))
                .ifPresent(ExampleOptional::showMessage);

        Optional<Person> optionalPerson = Optional.of(person);
        String nameCompanies = optionalPerson.filter(j -> j.getAge() >= 40).flatMap(Person::getCar)
                .flatMap(Car::getInsurance).map(Insurance::getName).orElseGet(() -> "No cumple criterio");
        System.out.println(nameCompanies);

        Map<String, Integer> test = new HashMap<>();
        test.put("Age", 40);
        System.out.println(Optional.ofNullable(test.get("Age")).orElse(0));


        /**
         * orElseThrow allows us throw exception whether optional don't exist
         */
        String nameCompany2 = optPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElseThrow(()->new RuntimeException("Don't contains  name car"));
        System.out.println(nameCompany2);


        List<Double> list = Arrays.asList(0.0);
        OptionalDouble optional = list.stream().mapToDouble(j -> j).max();
        optional.ifPresent(System.out::println);





    }


}
