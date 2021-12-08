package CAP1.ENUM;

public enum SeasonThree {
    WINTER{
        @Override
        public String getValue(){
            return "...";
        }
    }, SUMMER;

    public String getValue(){
        return "default";
    }
}
