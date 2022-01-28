package CAP2.ANNOTATION;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

enum UnitOfTemp{C, F}
@Documented
@Target({ElementType.TYPE_USE, ElementType.LOCAL_VARIABLE})
@interface Example{
    final int h = 5;

   String nameProd() default "NA";
   String [] category() default "";
   int[] directions () default 1;
   int value() default 1;
   boolean isOk = true;
}

@Documented
@interface DescriptionGeneralClass{

    String value() default "testing annotations";
}

class Test{
    protected void test() {

    }

    static void testuno(){

    }
}

@DescriptionGeneralClass
public class Cheetah extends Test{

    private static int h;

    @Example(directions = 1)
    int idBranch;

    @Override
    @DescriptionGeneralClass("example")
    protected void test() throws RuntimeException{

    }

    static void testuno(){

    }

    @Example(value= 1, nameProd = "The product name is assigned by client",
            category = "GENERAL, FARMACY, GROCERY")
    String product;

    @DescriptionGeneralClass("testing method")
    public String testin(){

       @DescriptionGeneralClass("I think something going to happen")
       var value = "";
       return value;
    }


    public static void main(String[] args) {
        boolean isValue = Example.isOk;
    }
}
