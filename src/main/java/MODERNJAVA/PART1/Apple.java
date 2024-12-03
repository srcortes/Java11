package MODERNJAVA.PART1;

public class Apple {

    private Color color;
    private Integer weight;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return color.toString() + " - "+ weight;
    }
}
