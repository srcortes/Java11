package CAP1.INTERFACE.MEMBERS;

public interface TestDefaultMethodTwo {
    int value();
    default String testOne(String value){
        getAge();
        this.test("123");
        return value;
    }

    static int getAge(){
        testOne();
        return 41;
    }

    private void test(String value){
        getAge();
    }

    private static void testOne(){

    }
}
