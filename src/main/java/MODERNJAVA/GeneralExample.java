package MODERNJAVA;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.stream.IntStream;
import org.apache.commons.lang3.ObjectUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.stream.Stream.concat;

/**
 * Ejemplo uso IntFunction<R> devuelve el valor especificado en el
 * operador <> y recibe unicamente un valor entero
 */




public class GeneralExample {

  public static void main(String[] args) throws Exception {
    final Map<Integer, String> map = new HashMap<>();
    map.put(80217780, "John");
    verify(map);
    System.out.println(map);



  }

  public static Map<Integer, String> verify(Map<Integer, String> map){
    map.put(63545795, "July");
    return map;

  }



}
