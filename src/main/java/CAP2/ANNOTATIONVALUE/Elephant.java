package CAP2.ANNOTATIONVALUE;



public abstract class Elephant {
    @Injured(value="Legs", age=25) public void fallDown(){}
    @Injured("Legs") public abstract int trip();
    @Injured("arms") String injuries[];
}
