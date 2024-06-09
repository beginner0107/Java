package syntax.training.ex01;

public class Main {
    public static void main(String[] args) {
        int age = 10;
        Human adam = new Human();
        increaseAge(adam, age);
        System.out.println();
    }

    public static void increaseAge(Human human, int age) {
        human.increaseAge(human, age);
    }
}
