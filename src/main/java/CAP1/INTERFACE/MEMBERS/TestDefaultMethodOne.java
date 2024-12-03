package CAP1.INTERFACE.MEMBERS;

/**
 * AS OF NOW, THERE ARE DEFAULTS METHOS INTO A INTERFACE
 * AS WELL, WE HAVE ALLOW TO CREATE STATIC METHOD
 */
public interface TestDefaultMethodOne {
    int value();
    default String testOne(String value){
        return value;
    }

    static int getAge(){
        return 42;
    }

    default void test(){
        getAge();
    }

    private void testOne(){
        getAge();
    }

    abstract String toString();

}
