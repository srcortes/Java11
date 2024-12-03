package FIT.GENERAL;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@FunctionalInterface
interface CreateFamily<Id, Name, Age, Family>{
    Family apply(Id id, Name name, Age age);
}

class Family{
    private String name;
    private Integer age;
    private Integer Id;

    public Family(Integer id, String name, Integer age) {
        this.name = name;
        this.age = age;
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
public class Example {

    public static Family CreateObject(Integer id, String name, Integer age,
                                      CreateFamily<Integer, String, Integer, Family> createFamily) {
        return createFamily.apply(id, name, age);
    }

    public static List<Family> listFamily(Supplier<List<Family>> family){
        return family.get();
    }

    public static void printInformation(Map<Integer, String> map,
                                        Consumer<Map<Integer, String>> consumer) {
        consumer.accept(map);
    }

    public static void main(String[] args) {
        Family memberOne = Example.CreateObject(63545795, "July Mora", 38, Family::new);
        Family memberTwo = Example.CreateObject(1014567988, "Mariana Mora", 11, Family::new);
        Family memberThree = Example.CreateObject(123456789, "Gabriela Mora", 1, Family::new);
        Family memberFour = Example.CreateObject(80217780, "John Rodriguez", 41, Family::new);

        List<Family> list = Example.listFamily(ArrayList::new);
        list.add(memberOne);
        list.add(memberTwo);
        list.add(memberThree);
        list.add(memberFour);

        Map<Integer, String> mapFamily = list.stream().filter(value -> value.getAge() > 40)
                .collect(Collectors.toMap(Family::getId, Family::getName));
        Example.printInformation(mapFamily, System.out::println);
    }
}
