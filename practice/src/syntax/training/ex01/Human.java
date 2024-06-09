package syntax.training.ex01;

public class Human {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void increaseAge(Human player, int age) {
        player.age += age;
        age = 0;
    }
}
