package CAP1.NESTED_CLASSES.INNERCLASS;


interface TestingExampleTwo{
    String name();
}

class ExtendsClass{
    public int edad = 41;
}

public class InnerClassExampleTwo {
    private String name = "John";
    private String apellido = new InnerExampleTwo().value;

    class InnerExampleTwo extends ExtendsClass implements  TestingExampleTwo{
        private String value = "Alumno";
        private int age = this.edad;

        /**
         * HERE REMEMBER THE INNER CLASS ONLY CAN HAVE VARIABLES KIND OF STATIC FINAL
         */
        private static final int h = 5;

        @Override
        public String name() {
            return name  + " Jairo";
        }
    }

    public static void main(String[] args) {
        //FIRST WAY
        InnerClassExampleTwo innerClassExampleTwo = new InnerClassExampleTwo();
        InnerExampleTwo innerExampleTwo = innerClassExampleTwo.new InnerExampleTwo();
        System.out.println(innerExampleTwo.name() + " - "+ innerExampleTwo.age +" - "+ innerExampleTwo.value);

        //SECOND WAY
        InnerClassExampleTwo.InnerExampleTwo innerExampleTwo1 = new InnerClassExampleTwo().new InnerExampleTwo();
        System.out.println(innerExampleTwo1.name() + " " + innerExampleTwo1.age +" "+innerExampleTwo1.value );
    }
}
