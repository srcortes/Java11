package MODERNJAVA.PART1;

public class AppleHeavyWeightPredicate extends Apple implements ApplePredicate{


    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
