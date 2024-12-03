package SOLID.LISKOV;

public class Test {
    public static void main(String[] args) {
        Services services = new Services();
        ServicesSub servicesSub = new ServicesSub();

        ClassArgSuper classArgSuper = new ClassArgSuper();
        ClassArg classArg = new ClassArg();

        services.doSomething(classArg);
        servicesSub.doSomething(classArg);
    }
}
