package CAP1.ENUM;

public enum ExamplePersonalTwo {
    BIKE{
        public String hourWorkOut(){
            return "Lunes a Viernes 12 a 1 pm";
        }
    },LIFT, CARDIO{
        public String hourWorkOut(){
            return "Lunes a Viernes 6 a 7 am";
        }
    };

    public String hourWorkOut(){
        return "Lunes a Viernes 7 a 8 om";
    }
}
