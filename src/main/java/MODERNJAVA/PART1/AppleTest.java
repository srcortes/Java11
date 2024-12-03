package MODERNJAVA.PART1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleTest {

    public static List<Apple> filterGreenApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterAppleByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(apple.getColor().equals(color)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        AppleRedAndHeavyPredicate one = new AppleRedAndHeavyPredicate();
        one.setWeight(158);
        one.setColor(Color.RED);


        List<Apple> list = new ArrayList<>();
        list.add(one);

        List<Apple> apple = AppleTest.filterGreenApples(list, j -> j.getWeight() > 150 && j.getColor().equals(Color.RED));
        //List<Apple> appleByColor = AppleTest.filterAppleByColor(list, Color.RED);
        System.out.println(apple);




    }
}
