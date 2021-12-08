package CAP1.NESTED_CLASSES.INNERCLASS;

import java.util.function.Supplier;

public class TestExtendInnerClass extends Outer.Inner{

    public TestExtendInnerClass(Outer outer){
        outer.super();
    }

    public static void main(String[] args) {
        Supplier<Outer> outerSupplier = Outer::new;
        TestExtendInnerClass t = new TestExtendInnerClass(outerSupplier.get());
        String valeu = t.k;
        System.out.println(valeu);

    }
}
