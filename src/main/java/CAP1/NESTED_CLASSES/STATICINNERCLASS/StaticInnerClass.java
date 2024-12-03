package CAP1.NESTED_CLASSES.STATICINNERCLASS;

interface pruebaStaticInnerClass{
    String values = "Hello";
}

class testStaticInnerClass{
    static String name = "John";
}

public class StaticInnerClass {
    private static int value = 15;
    private static int value2 = Nested.internal;

    static class Nested extends testStaticInnerClass implements pruebaStaticInnerClass{
        private static int price = value;
        private static int internal = 20;
    }

    public static void main(String[] args) {
        System.out.println(Nested.values);
        System.out.println(Nested.name);
    }
}
