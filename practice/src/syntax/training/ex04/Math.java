package syntax.training.ex04;

public class Math {
    private Math() {}

    public static int abs(int n) {
        return n < 0 ? -n : n;
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }
}
