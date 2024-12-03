package CAP1.INTERFACE.MEMBERS;


/**
 * IF THE INTERFACE CONTAINS TWO METHOD STATIC WITH THER SAME SIGNATURE, THE CLASS COMPILE WITHOUT MISTAKE
 */
public class TestInterfaceOne implements TestDefaultMethodOne, TestDefaultMethodTwo{

    @Override
    public int value() {
        return 0;
    }

    @Override
    public String testOne(String value) {
        return TestDefaultMethodOne.super.testOne(value);
    }

    public static void main(String[] args) {
        System.out.println(TestDefaultMethodTwo.getAge() + TestDefaultMethodOne.getAge());
    }
}
