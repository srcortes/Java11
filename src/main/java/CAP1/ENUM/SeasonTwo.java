package CAP1.ENUM;

public enum SeasonTwo {
   WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");

   private final String expectedVisitor;

    SeasonTwo(String expectedVisitor){
        this.expectedVisitor = expectedVisitor;
    }

    public String getExpectedVisitor() {
        return expectedVisitor;
    }
}
