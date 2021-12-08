package CAP1.NESTED_CLASSES.INNERCLASS;

interface OuterTest{
    int a = 5;
}
class OuterTest2{
    String test = "from class extends";
}
public class Outer {
    private String greeting = "Hi";
    private int jj = new Inner().j;
    int a = 10;

    class Inner extends  OuterTest2 {
        public int repeat = 3;
        public int j = a;
        public final static String k = "522";


        public void testOne(){
            test();
        }

        public void go() {
            for (int i = 0; i < repeat; i++)
                System.out.println(greeting);

        }
    }

    public void test(){
        System.out.println("inside method");
    }

    public void callInner() {
        Inner inner = new Inner();
        inner.go();
    }

    public static void main(String[] args) {
        //Outer.Inner outer = new Outer().new Inner();
        Outer outer1 = new Outer();
        Inner outer = outer1.new Inner();
        int h = outer.j;
        String u = outer.test;
        System.out.println(h+"   "+u);
        outer.testOne();
    }
}
