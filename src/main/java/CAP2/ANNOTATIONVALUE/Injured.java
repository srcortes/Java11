package CAP2.ANNOTATIONVALUE;


public @interface Injured {
    String veterinarian() default "unassigned";
    String value();
    int age() default 5;

}
