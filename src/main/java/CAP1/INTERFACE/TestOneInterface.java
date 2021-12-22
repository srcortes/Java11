package CAP1.INTERFACE;

import java.util.function.Supplier;

interface TestOneI{
    default String returnValue(){
        return "TestOneInterface";
    }
}

interface TestTwoI {
    public default String returnValue(){
        return "TestOneInterface";
    }
}

public class TestOneInterface implements TestOneI, TestTwoI {

    @Override
    public String returnValue() {
        return TestOneI.super.returnValue();
    }

    public static void main(String[] args) {
        Supplier<TestOneInterface> test = TestOneInterface::new;
        test.get().returnValue();
    }
}
