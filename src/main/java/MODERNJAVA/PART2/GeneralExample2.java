package MODERNJAVA.PART2;



import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;



public class GeneralExample2 {

    public static String algoOne(){
     return "true";
    }

    public static String algoTwo(){
        return "false";
    }



    public static void main(String[] args) {

        boolean status = false;

        System.out.println(status ? GeneralExample2.algoOne() :  GeneralExample2.algoTwo());



    }













}
