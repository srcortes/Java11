package MODERNJAVA.PART1;

public class AppleRedAndHeavyPredicate extends  Apple implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {
        return Color.RED.equals(apple.getColor()) && apple.getWeight()> 150;
    }
}
