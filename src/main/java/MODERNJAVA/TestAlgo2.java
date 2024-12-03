package MODERNJAVA;


import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class  Passenger{
    private String passengerId;
    private Integer passengerIndex;

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public Integer getPassengerIndex() {
        return passengerIndex;
    }

    public void setPassengerIndex(Integer passengerIndex) {
        this.passengerIndex = passengerIndex;
    }
}

class AssociatedPassengerEntity{
    private String firstName;
    private Integer index;
    private String lastName;
    private String type;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AssociatedPassengerEntity{" +
                "firstName='" + firstName + '\'' +
                ", index=" + index +
                ", lastName='" + lastName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
public class TestAlgo2 {

    public static String prueba(List<Passenger> passengers, AssociatedPassengerEntity associatedPassenger){
          return passengers.stream().map(passenger -> {
              String id = "";
              if(passenger.getPassengerIndex().equals(associatedPassenger.getIndex())){
                 id = passenger.getPassengerId();
              }

              return id;
          }).collect(Collectors.joining());

    }

    public static void main(String[] args) {


        AssociatedPassengerEntity associatedPassenger1 = new AssociatedPassengerEntity();
        associatedPassenger1.setFirstName("Edgar");
        associatedPassenger1.setIndex(2);
        associatedPassenger1.setLastName("Bonilla");
        associatedPassenger1.setType("AD");

        Passenger passenger = new Passenger();
        passenger.setPassengerId("ADT_1");
        passenger.setPassengerIndex(5);

        Passenger passenger1 = new Passenger();
        passenger1.setPassengerId("ADT_2");
        passenger1.setPassengerIndex(2);

        List<Passenger> list = new ArrayList<>();
        list.add(passenger);
        list.add(passenger1);



        System.out.println(TestAlgo2.prueba(list, associatedPassenger1));

        List<BigDecimal> list1 = Arrays.asList(new BigDecimal(1.0), new BigDecimal(-4.0));

        BigDecimal list2 = list1.stream()

            .reduce(BigDecimal.ZERO, BigDecimal::add);
        UnaryOperator<BigDecimal> cal = BigDecimal::abs;
        System.out.println(cal.apply(list2));
        System.out.println(list2);





    }
}

