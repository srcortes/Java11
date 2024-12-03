package MODERNJAVA.PART2.STREAM;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Test  {
    private String pais;
    private String capital;
    private String barrio;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    @Override
    public String toString() {
        return "Test{" +
                "pais='" + pais + '\'' +
                ", capital='" + capital + '\'' +
                ", barrio='" + barrio + '\'' +
                '}';
    }
}
public class StreamExample {

    /**
     *
     * HERE WE HAVE AN EXAMPLE HOW CAN USE STREAM OF
     *
     */
    public static String useStreamOf(String value){
        Stream<String> changeOrderValue = Stream.of(value);

        return changeOrderValue.map(values -> {
            int position = values.length() - 1;
            StringBuilder newValue = new StringBuilder();
            while(position >= 0){
                newValue.append(values.charAt(position));
                position--;
            }

            return newValue.toString();
        }).findFirst().orElseThrow(()-> new RuntimeException("Error in procesing string"));
    }

    /**
     *
     * In order to handle null object from a Stream, we have Stream.ofNullable.
     */
    public static void useStreamOfNullable(String value){
        Stream<String> useStream = Stream.ofNullable(value);
        System.out.println(useStream.findFirst());

    }

    public static void useArraysStream(String[] arrays){
        List<String> list = Arrays.stream(arrays).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(list);

    }

    public static void useStreamFromFiles(){
        try(Stream<String> lines = Files.lines(Paths.get("C:/Users/john.rodriguez/Desktop/File.txt"),
                Charset.defaultCharset())){
            List<Test> list = new ArrayList<>();
            String[] values = lines.toArray(String[]::new);
            for(int i = 0; i < values.length; i++){
               String separateValue[] = values[i].split(",");
               Test test = new Test();
               for(int j = 0; j < separateValue.length; j++){
                   test.setPais(separateValue[0]);
                   test.setCapital(separateValue[1]);
                   test.setBarrio(separateValue[2]);
               }
                list.add(test);
            }
            System.out.println(list);

        }catch (IOException ex){
            System.out.println(ex.getStackTrace());
        }
    }

    public static void useStreamToArrays(int[] array){
        OptionalInt opt = Arrays.stream(array).max();
        opt.ifPresentOrElse(System.out::println, () -> System.out.println("no hay nada"));

    }

    public static void verifyString(String value) {
        Stream<String> stringStream = Stream.of(value);
        String h = stringStream.filter(j -> j.charAt(0) == 'J').map(String::toUpperCase)
                .collect(Collectors.joining());
        System.out.println(h);
    }



    public static void fibonacci(){
        Stream.iterate(new int[]{0,1}, t-> new int[]{t[1],t[0] + t[1]})
                .limit(10).map(t->t[0]).forEach(System.out::println);
    }

    public static void Months(){

    }

    public static void sumNumber(int limit){
        int outcome = Stream.iterate(1, n -> n <= limit, j -> j +1).mapToInt(j -> j).sum();
        System.out.println(outcome);



    }

    public static void abecedario(int limit) {
        int a = 0;
        Stream.iterate(new char[]{'A'}, j -> new char[]{(char) (j[0] + (a + 1))})
                .limit(26)
                .forEach(System.out::println);
    }

    public static void arregloPares(){
        Stream.iterate(new int[]{2, 4},  j -> new int[]{j[0] * 2, j[1] * 2})
                .limit(10).map(j -> j[0]).forEach(System.out::println);
    }

    public static String generateCode(){
        String a = Stream.generate(RandomStringUtils::new)
                .map(j ->  RandomStringUtils.randomAlphabetic(6))
                .limit(1).collect(Collectors.joining());
        return a;
    }

    public static void generateHexa() {

        List<Test> a = Stream.generate(Test::new).peek(j -> {
            j.setBarrio("Cedritos");
            j.setCapital("Boogota");
            j.setPais(generateCode());
        }).limit(3).collect(Collectors.toList());
        System.out.println(a);

    }




    public static void main(String[] args) {
        System.out.println(StreamExample.useStreamOf("Mariana"));
        StreamExample.useStreamOfNullable(null);
        StreamExample.useArraysStream(new String[]{"john","july", "mariana"});
        StreamExample.useStreamFromFiles();
        int[] array = {1980,1983,2021,2011};
        StreamExample.useStreamToArrays(array);
        StreamExample.verifyString("John");
        StreamExample.generateCode();
        StreamExample.fibonacci();
        StreamExample.sumNumber(5);
        StreamExample.abecedario(20);
        StreamExample.arregloPares();
        StreamExample.generateHexa();








    }
}
