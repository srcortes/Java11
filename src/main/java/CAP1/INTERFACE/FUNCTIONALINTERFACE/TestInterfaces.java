package CAP1.INTERFACE.FUNCTIONALINTERFACE;


interface CanWalk{
    default void walk(){
    }

    private void testWalk(){
    }
}

interface CanRun{
    abstract public void run();
    private void testWalk(){}
    default void walk(){
        System.out.println("....");
    }
}

interface CanSprint extends CanWalk, CanRun{

    @Override
    default void run() {

    }

    @Override
    default void walk() {
        CanWalk.super.walk();
    }
}

public interface TestInterfaces {
}
