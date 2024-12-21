package modern.chap03;

import java.util.Comparator;

public class Lambdas {
    public static void main(String[] args) {
        // 람다 식 이전 기존 코드
        Comparator<Apple> byWeight = new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return Integer.compare(a1.getWeight(), a2.getWeight());
            }
        };

        // 람다식을 이용한 코드
        Comparator<Apple> byWeight2 = (Apple a1, Apple a2) -> Integer.compare(a1.getWeight(), a2.getWeight());

        Runnable r1 = () -> System.out.println("Hello world");
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world2");
            }
        }; // 익명 클래스

        process(r1); // 람다식
        process(r2); // 익명 클래스
        process(() -> System.out.println("Hello world3")); // 직접 전달한 람다 표현식
    }

    public static void process(Runnable r) {
        r.run();
    }
}
