package SOLID.LISKOV;

public class ServicesSub extends Services{
    public void doSomething(ClassArgSuper classArgSuper){
        System.out.println(classArgSuper.getClass());

    }
}
