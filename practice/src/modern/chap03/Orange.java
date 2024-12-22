package modern.chap03;

public class Orange implements Fruit{
    private int weight = 0;
    private Color color;

    public Orange() {
    }

    public Orange(int weight) {
        this.weight = weight;
    }

    public Orange(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @SuppressWarnings("boxing")
    @Override
    public String toString() {
        return String.format("Orange{color=%s, weight=%d}", color, weight);
    }

}
