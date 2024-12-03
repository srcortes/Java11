package CAP1.ENUM;

public class TestOneEnum {
    public static void main(String[] args) {

        /**
         * Here we can see, there are two values to Enum name() and value()
          */
        for(Season s : Season.values()){
           System.out.println(s.name() +" - "+ s.ordinal());
       }

        /**
         * HERE WE HAVE AN EXAMPLE ABOUT valueof() with ENUM.
         */
        Season season = Season.valueOf("SUMMER");

        /**
         * EXAMPLE AS USE THE ENUM INSIDE A SWITCH
         */
        Season season1 = Season.WINTER;
        switch (season1){
            case FALL:
                System.out.println("HERE FALL");
                break;
            case WINTER:
                System.out.println("HERE WINTER");
                break;
            default:
                System.out.println("......");
        }
        System.out.println(SeasonTwo.FALL.getExpectedVisitor());
        for(ExamplePersonal p : ExamplePersonal.values()){
            System.out.println(p.name() +" - "+ p.timeDuration());
        }

        for(ExamplePersonalTwo examplePersonalTwo : ExamplePersonalTwo.values()) {
            System.out.println(examplePersonalTwo.name() + " - "+ examplePersonalTwo.hourWorkOut() );
        }
    }
}
