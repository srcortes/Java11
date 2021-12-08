package CAP1.NESTED_CLASSES.LOCALCLASSES;

import java.util.function.Supplier;

@FunctionalInterface
interface  IFunc{
    void display();
}

public class PrintNumbers {
    private int length = 5;

    IFunc ifunc = ()-> System.out.println("Value of i is " + length);

    public void calculate(){
        final int widtth = 20;
        int h = 50;

        class myLocalClass implements IFunc{
            final static int j = 5;

            public void multiply(){
                System.out.println(length * widtth);
            }

            @Override
            public void display() {
                System.out.println("....");
            }
        }

        Supplier<myLocalClass> myLocalClassSupplier = myLocalClass::new;
        System.out.println(myLocalClassSupplier.get().j);
        myLocalClassSupplier.get().multiply();
    }

    public static void main(String[] args) {
        Supplier<PrintNumbers> printNumbersSupplier = PrintNumbers::new;
        printNumbersSupplier.get().calculate();
    }
}
