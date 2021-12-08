package CAP1.NESTED_CLASSES.STATICINNERCLASS;

interface TestStaticInnerClass{
    String message = "from interface";
}

class TestStaticInnerClassExtends{
    String message1 = "from class extends";
}

public class TestOneStaticClass {
    static int value = 30;
    public static String valueNew = new Inner().otherValue;

    public static class Inner extends TestStaticInnerClassExtends implements TestStaticInnerClass{
      int valueInner = value;
      static String otherValue = "value from Inner static class";
    }

    public static void main(String[] args) {
        TestOneStaticClass t1 = new TestOneStaticClass();
        TestOneStaticClass.Inner t = new TestOneStaticClass.Inner();
        String value = new TestOneStaticClass.Inner().otherValue;

        System.out.println(t.valueInner);
        System.out.println(t.message);
        System.out.println(t.message1);
        System.out.println(t1.valueNew);
        System.out.println(value);
    }
}
