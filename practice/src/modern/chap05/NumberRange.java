package modern.chap05;

import java.util.stream.IntStream;

/**
 * 숫자 범위
 * 
 * 스트림은 최종연산을 호출될 때까지 데이터를 처리하지 않음
 * 스트림의 지연 처리(lazy evaluation) 때문
 *
 * 중간 연산은 데이터를 처리할 준비만하고, 최종 연산이 호출되기 전까지는 
 * 아무런 연산도 실행하지 않는다
 */
public class NumberRange {
    public static void main(String[] args) {
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());

        // rangeClosed: 1과 100 모두 포함
        IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0).count(); // 짝수 50개

        // range: 1 포함, 100 미포함
        IntStream.range(1, 100).filter(n -> n % 2 == 0).count(); // 짝수 49개
    }
}
