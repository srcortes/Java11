package CAP1.NESTED_CLASSES.INNERCLASS;

import java.util.function.Supplier;

public class TestExtendInnerClass extends IneerClassExampleOne.InnerExample{

    public TestExtendInnerClass(IneerClassExampleOne outer){
        outer.super();
    }

    public static void main(String[] args) {
        IneerClassExampleOne ineerClassExampleOne = new IneerClassExampleOne();
        TestExtendInnerClass testExtendInnerClass = new TestExtendInnerClass(ineerClassExampleOne);
        System.out.println(testExtendInnerClass.repeat);
    }
}
