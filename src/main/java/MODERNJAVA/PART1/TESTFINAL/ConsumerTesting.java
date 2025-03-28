package MODERNJAVA.PART1.TESTFINAL;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.*;


class CellPhone{
    private String state;
    private String brand;

    private boolean isAvailable;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString(){
        return state + " " + brand + " " + isAvailable;
    }
}

class Students{
    private String name;
    private double qualification;

    public Students(String name, double qualification) {
        this.name = name;
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQualification() {
        return qualification;
    }

    public void setQualification(double qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", qualification=" + qualification +
                '}';
    }
}
public class ConsumerTesting {

    private static final String INITIAL_VALUE = "Send";

    static String fullName = "July";
    int value = 5;

    double  valor = 12.5;



    static String isSend;

    public static void JoinString(String value, Consumer<String> consumer) {
        consumer.andThen(String::toUpperCase).accept(value);

    }

    public static void test(Integer val, IntConsumer intConsumer) {
        intConsumer.accept(val);
    }


    public static void test1(double val, DoubleConsumer intConsumer) {
        intConsumer.accept(val);
    }

    public static void testOne(Double value, DoubleConsumer doubleConsumer) {
        doubleConsumer.accept(value);
    }

    public static void print(Object obj, Consumer<Object> objectConsumer) {
        objectConsumer.accept(obj);
    }

    public static void testValue(String value, Consumer<String> consumer) {
        consumer.accept(value);
    }

    public static String change(String value, Function<String, String> function) {
        return function.apply(value);
    }


    public static void modifyList(List<Integer> list, Consumer<List<Integer>> listConsumer) {
        listConsumer.andThen(System.out::println).accept(list);
    }

    public static boolean verifyString(CellPhone cellPhone, String value, BiPredicate<CellPhone, String> biConsumer){
        return biConsumer.test(cellPhone, value);
    }

    public void testAlgo() {
        ConsumerTesting.print("Third Case", System.out::println);
        ConsumerTesting.test(5, val -> value *= val);
        //ConsumerTesting.test1(5.5, j -> value *= j);
        //ConsumerTesting.print(value, System.out::println);
        System.out.println(value);
    }

    public static void testJohn(String msn){

        if(msn == null){
            throw new RuntimeException("error");
        }

        System.out.println("Continuo");

    }

    public void changeDouble(double value, DoubleConsumer doubleConsumer){
        doubleConsumer.accept(value);
    }



    public static void main(String[] args) {

        ConsumerTesting.print("Second Case", System.out::println);
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);
        ConsumerTesting.modifyList(list, data -> {
            for (int i = 0; i < data.size(); i++)
                data.set(i, 2 * data.get(i));
        });

        ConsumerTesting consumerExampleOne = new ConsumerTesting();
        consumerExampleOne.testAlgo();

        ConsumerTesting.print("Fourth Case", System.out::println);
        ConsumerTesting.print(isSend, val -> {
            Predicate<String> isNull = Objects::isNull;
            Predicate<String> isEmpty = ""::equals;
            boolean evaluateCondition = isNull.or(isEmpty).test((String) val);
            if (evaluateCondition) {
                isSend = ConsumerTesting.change(isSend, value -> INITIAL_VALUE);
            }
        });
        ConsumerTesting.print(isSend, System.out::println);

        ConsumerTesting.print("Six Case", System.out::println);
        CellPhone cellPhone = new CellPhone();
        cellPhone.setBrand("Motorola");
        Consumer<CellPhone> cellPhoneConsumer = valor -> {
            var response = ConsumerTesting.
                    verifyString(cellPhone, "Motorola", (a, b) -> a.getBrand().equalsIgnoreCase(b));
            if (response) {
               valor.setState("Stock");
            }
        };
        cellPhoneConsumer.accept(cellPhone);
        ConsumerTesting.print(cellPhone, System.out::println);

        ConsumerTesting.print("Seven Case", System.out::println);
        BiConsumer<String, String> biConsumer =  (branch, stock) -> {
            BiPredicate<String, String> biPredicate
                    = (a, b) -> a.equalsIgnoreCase("Motorola") && b.equalsIgnoreCase("Stock");
            if(biPredicate.test(branch, stock)) {
                cellPhone.setAvailable(true);
            }

        };
        biConsumer.accept(cellPhone.getBrand(), cellPhone.getState());
        ConsumerTesting.print(cellPhone, System.out::println);

        ConsumerTesting consumerExampleOne1 = new ConsumerTesting();
        ConsumerTesting.testOne(12.0, val ->  consumerExampleOne1.valor += val );
        System.out.println(consumerExampleOne1.valor);

        List<Integer> list1 = Arrays.asList(2,3,4,5,6,7,8);
        ObjIntConsumer<List<Integer>> objIntConsumer = (val, index) -> {

            val.forEach(a -> System.out.println(":::" + a*index));

        };
        objIntConsumer.accept(list1, 3);

        BiFunction<String, Double, Students> biFunction = Students::new;
        Students students1 = biFunction.apply("John", 2.9);
        Students students2 = biFunction.apply("July", 3.0);

        List<Students> list2 = new ArrayList<>();
        list2.add(students1);
        list2.add(students2);
        System.out.println(list2);

        ObjDoubleConsumer<List<Students>> objIntConsumer1 = (student, index) -> {

           for(int j = 0; j < student.size(); j++){
               if(student.get(j).getQualification() == 2.9) {
                   student.get(j).setQualification(2.9 + index);
               }
           }
        };
        objIntConsumer1.accept(list2, 0.1);
        System.out.println(list2);

        /**
         *
         */
        ConsumerTesting.print("First Case", System.out::println);
        ConsumerTesting.JoinString(fullName, value -> {
            Predicate<String> predicate = Predicate.isEqual("john");
            if(predicate.test(value)) {
                fullName = value.concat(" Rodriguez");
            } else {
                fullName = value.concat(" Mora");
            }
        });
        System.out.println(fullName);

        ConsumerTesting.testJohn(null);



    }
}
