package modern.chap03;

public class Apple implements Fruit{

  private int weight = 0;
  private Color color;
  private String country;

  public Apple() {
  }

  public Apple(int weight) {
    this.weight = weight;
  }

  public Apple(int weight, Color color) {
    this.weight = weight;
    this.color = color;
  }

  public Apple(int weight, Color color, String country) {
    this.weight = weight;
    this.color = color;
    this.country = country;
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

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @SuppressWarnings("boxing")
  @Override
  public String toString() {
    return String.format("Apple{color=%s, weight=%d}", color, weight);
  }

}
