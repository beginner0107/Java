package modern.chap03;

import java.util.List;
import java.util.function.*;

public class Lambdas2 {
    public static void main(String[] args) {

        // 1번 람다 표현식 구현
        Runnable r = () -> System.out.println("Hello World!");
        r.run();

        // 2번 Function 을 사용한 람다
        Function<Integer, Integer> f = (n) -> n * n;
        System.out.println(f.apply(5));
        
        // 3번 BFunction 을 이용한 람다
        BiFunction<Integer, Integer, String> bif = (a, b) -> String.valueOf(a + b);
        System.out.println(bif.apply(3, 7));

        // 4번 Predicate 를 사용한 람다
        Predicate<String> checkLength = (s) -> s.length() >= 5;
        System.out.println(checkLength.test("Hello"));
        System.out.println(checkLength.test("Hi"));

        // 5번 Consumer 와 Stream 활용
        Consumer<List<Integer>> consumer = list -> {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        };
        consumer.accept(List.of(1, 2, 3, 4, 5));

        // 6번 Supplier 와 랜덤 값 생성
        Supplier<Integer> supplier = () -> (int) (Math.random() * 100) + 1;
        System.out.println(supplier.get());

        // 7번 함수형 인터페이스 구현
        System.out.println(runProcess((a, b) -> a * b));
    }

    public static int runProcess(CustomFunctional c) {
        return c.process(3, 7);
    }

    @FunctionalInterface
    public interface CustomFunctional {
        int process(int a, int b);
    }
}
