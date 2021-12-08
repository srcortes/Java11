package CAP1.ENUM;

public enum Season {
    WINTER("winter"), SPRING("spring"), SUMMER("summer"), FALL("fall");

    private final String expectedVisitor;

    Season(String expectedVisitor){
        this.expectedVisitor = expectedVisitor;
    }

    public void printExpectedVisitor(){
        System.out.println(expectedVisitor);
    }
}
