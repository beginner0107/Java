package codingTest;

public class Main {
    public static void main(String[] args) {
        CustomMath math = new CustomMath();
        math.remainingOperations();
        print();

        math.setOperations();
        print();

        print(math.getDivisors(18));
        print();

        print(math.isPrime(7));
        print(math.isPrime(8));
        print();

        print(math.getGcd(12, 8));
        print(math.getLcm(12, 8));
        print();

        print(math.getPrimes(60));
        print(math.getPrimes(57));
        print();

        print(math.isPrimeEratosthenes(20));
        print(math.isPrimeEratosthenes(2));
        print();

        print(math.gcd(12, 8));
        print();
    }

    public static void print() {
        System.out.println();
    }

    public static <T> void print(T value) {
        System.out.println(value);
    }
}
