package MODERNJAVA;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.stream.IntStream;
import org.apache.commons.lang3.ObjectUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

/**
 * Ejemplo uso IntFunction<R> devuelve el valor especificado en el
 * operador <> y recibe unicamente un valor entero
 */

enum c{
    ENERO, FEBRERO, MARZO, ABRIL, MAYO
}

class PassengerDTO{

  private List<DocumentInfoDTO> documents;

  public List<DocumentInfoDTO> getDocuments() {
    return documents;
  }

  public void setDocuments(List<DocumentInfoDTO> documents) {
    this.documents = documents;
  }
}

class DocumentInfoDTO{
  private String nationality;

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }
}


public class GeneralExample {

    private static String gg;

    private static final String CLEAN_NUMBER_EXP = "^[0]*";
    private static final Pattern CLEAN_NUMBER_PATTERN =
            Pattern.compile(CLEAN_NUMBER_EXP, Pattern.MULTILINE);


    public static String cleanNumber(String seatNumber) {
        AtomicReference<String> result = new AtomicReference<>();
        Optional.ofNullable(seatNumber)
                .ifPresent(
                        sn -> {
                            final Matcher matcher = CLEAN_NUMBER_PATTERN.matcher(sn);
                            result.set(matcher.replaceAll(""));
                        });

        return result.get();
    }

    public static List<String> algoTest(c enums){
        List<String> newList  = new ArrayList<>();
        switch (enums){
            case ENERO:
                newList.add(c.ENERO.toString());
            break;
            case FEBRERO:
                newList.add(c.FEBRERO.toString());
            break;
            case MARZO:
                newList.add(c.MARZO.toString());
            break;

        }

        return  newList;
    }

    public String convertFirstLetterUpperCase(String name) {
        return name.toUpperCase().charAt(0) + (name.substring(1, name.length()));
    }

    public static void pruebaOptional(String value){
        if("ERROR".equals(Optional.ofNullable(value).map(String::toUpperCase).orElse(null))){
            throw new RuntimeException("ERROR2");
        }


    }

    public static void algo(){
        System.out.println("hola firts");
    }

  public static void validateNationality(String passenger) {
    Optional.ofNullable(passenger)
        .filter(passengerNationality -> !passengerNationality.isEmpty())
        .orElseThrow(
            () ->
               new RuntimeException("error"));
  }

  public static LocalDate birthdayPassengerOnDepartureYear(LocalDate dateOfBirth, LocalDate departure) {
    final int yearLastDeparture = departure.get(ChronoField.YEAR);
    return LocalDate.of(
        yearLastDeparture,
        dateOfBirth.get(ChronoField.MONTH_OF_YEAR),
        dateOfBirth.get(ChronoField.DAY_OF_MONTH));
  }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("John", 38);
        map1.put("July", 42);
        map1.put("Mariana", 12);
        map1.put("Gabriela", 34);
        boolean d2 = map1.entrySet().stream().noneMatch(x -> x.getValue() >= 43);
        System.out.println(d2);

        Consumer<Object> print = System.out::println;

        List<Integer> list = Arrays.asList(15,85,74,98,45,12,98,56,458,452);

       ToIntFunction<List<Integer>> toIntFunction = (val)-> val.stream().mapToInt(x->x).sum();
       print.accept(toIntFunction.applyAsInt(list));

        List<Double> list2 = Arrays.asList(15.5,85.95,74.5,98.789,405.12,12.856,98.12,56.1,458.1458,452.12456);
        ToDoubleFunction<List<Double>> toDoubleFunction = val -> val.stream().mapToDouble(x->x).sum() / val.size();
        print.accept(toDoubleFunction.applyAsDouble(list2));

        BiFunction<String, String, Integer> biFunction = (val1, val2) -> {
            BiPredicate<Integer, Integer> biPredicate = (v1, v2) -> {
                if(v1 + v2 == 10){
                    return true;
                } else {
                    return false;
                }
            };

            if(biPredicate.test(val1.length(), val2.length())) {
                return val1.length() + val2.length();
            } else {
                return 0;
            }
        };

        Function<Integer, Integer> function = val3 -> {
            BooleanSupplier booleanSupplier = () -> val3.equals(10);
            if(booleanSupplier.getAsBoolean()) {
                return val3 + 1;
            } else {
                return 9999;
            }
        };

        String firstChainToEvaluate = "JohnJ";
        String secondChainToEvalueate = "JohnJ";
        int outcome = biFunction.andThen(function).apply(firstChainToEvaluate, secondChainToEvalueate);
        System.out.println("::::" + outcome);




        IntSupplier intSupplier = firstChainToEvaluate::length;
        System.out.println(intSupplier.getAsInt());

        String number = "0532";

        String value = GeneralExample.cleanNumber(number);
        print.accept(value);



        List<String> letters = Arrays.asList("John", "Mariana", "July", "Gabriela", "Juan Pablo");

        GeneralExample generalExample = new GeneralExample();
        letters.stream().map(generalExample::convertFirstLetterUpperCase)
                .sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
        UnaryOperator<String> test = String::toUpperCase;
        Consumer<String> prints =  System.out::print;
        prints.accept( test.apply("john"));

        UnaryOperator<Integer> f = x -> x+1;
        UnaryOperator<Integer> g = x -> x*2;
        Function<Integer, Integer> h = f.compose(g);
        int result = h.apply(1);
        System.out.println(result);

        System.out.println("*********************");

        String a = "b";

        GeneralExample.pruebaOptional(null);

        DocumentInfoDTO documentInfoDTO = new DocumentInfoDTO();
        documentInfoDTO.setNationality("Peruvian");
        List<DocumentInfoDTO> documentInfoDTOS = new ArrayList<>();
        documentInfoDTOS.add(documentInfoDTO);

        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setDocuments(documentInfoDTOS);



        List<PassengerDTO> passengerDTOList = new ArrayList<>();
        passengerDTOList.add(passengerDTO);

        /*Optional.ofNullable(passengerDTOList.stream().map(PassengerDTO::getDocuments)
                .flatMap(Collection::stream).)
            .filter(n -> !n.isEmpty()).orElseThrow(() -> new RuntimeException("1223"));*/

       List<String> list1 = Arrays.asList("A", "B", "C");
       List<String> list3 = Arrays.asList("D", "E", "F");

       if(list1.size() == list3.size()){
         IntStream.range(0, list1.size()).forEach((j) ->{
           System.out.println(list1.get(j)  + " - "+ list3.get(j));
         } );
       }else {
         System.out.println("nno se puedes");
       }

       GeneralExample.validateNationality("...");












    }


}
