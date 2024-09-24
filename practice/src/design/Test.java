package design;

public class Test {
    public static void main(String[] args) {
        Main  main = new Main();
        Main.Hello hello = main.new Hello();
        hello.hi();
    }
}
