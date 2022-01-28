package CAP2.ANNOTATIONREPETEABLE;

public class Zoo {
    @Risks({
        @Risk(danger="dangerous"),
        @Risk(danger = "timid", level = 1)
    })
    private Monkey monkey;
    public static class Monkey{
    }


}
