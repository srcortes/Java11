package CAP1.INTERFACE;

interface TestOneI{
    default String returnValue(){
        return "TestOneInterface";
    }
}

interface TestTwoI {
    default String returnValue(){
        return "TestOneInterface";
    }
}

public class TestOneInterface implements TestOneI, TestTwoI {

    @Override
    public String returnValue() {
        return String.valueOf(1);
    }
}
