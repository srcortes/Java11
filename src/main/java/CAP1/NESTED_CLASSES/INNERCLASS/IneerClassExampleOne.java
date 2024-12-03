package CAP1.NESTED_CLASSES.INNERCLASS;

public class IneerClassExampleOne {
    private String name = "John";

    public class InnerExample{
        public int repeat = 3;

        public void go(){
            for(int j = 0; j < repeat; j++)
                System.out.println(name);
        }
    }

    public void callInner(){
        InnerExample innerExample = new InnerExample();
        innerExample.go();
    }

    public static void main(String[] args) {
        /**
         * HERE WE HAVE THREE WAYS FROM INSTANTIATE AN INNER CLASS
         */
        //IneerClassExampleOne ineerClassExampleOne = new IneerClassExampleOne();
        //ineerClassExampleOne.callInner();

        //IneerClassExampleOne outer = new IneerClassExampleOne();
        //InnerExample innerExample = outer.new InnerExample();

        IneerClassExampleOne.InnerExample innerExample = new IneerClassExampleOne().new InnerExample();
        innerExample.go();
    }
}
