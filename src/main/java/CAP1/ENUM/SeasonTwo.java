package CAP1.ENUM;

public enum SeasonTwo {
    WINTER{
        @Override
        public String getValue(){
            return "8am";
        }
    },SUMMER{
        @Override
        public String getValue(){
            return "12pm";
        }
    }, FALL{
        @Override
        public String getValue() {
            return "5pm";
        }
    },SPRING{
        @Override
        public String getValue() {
            return null;
        }
    };


    public abstract String getValue();
}
