package MODERNJAVA.PART2.COLLECTORS;

public class Department {
    private String nameDeparment;

    public String getNameDeparment() {
        return nameDeparment;
    }

    public void setNameDeparment(String nameDeparment) {
        this.nameDeparment = nameDeparment;
    }

    @Override
    public String toString() {
        return "Department{" +
                "nameDeparment='" + nameDeparment + '\'' +
                '}';
    }
}
