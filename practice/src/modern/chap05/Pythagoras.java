package modern.chap05;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 피타고라스 스트림을 만들어 보자
 * a * a + b * b = c * c
 */
public class Pythagoras {
    public static void main(String[] args) {
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );
        pythagoreanTriples.limit(5)
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        // 개선
        Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                                .filter(t -> t[2] % 1 == 0)); // 세 수의 세 번째 요소는 반드시 정수여야 함
        pythagoreanTriples2.limit(5)
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        // flatMap 을 사용해야 하는 이유
        Stream<Stream<int[]>> streamStream = IntStream.rangeClosed(1, 100).boxed()
                .map(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );

        // 불필요하게 두 번의 forEach를 사용해야만 내부의 int[] 값에 접근할 수 있음
        streamStream.forEach(innerStream ->
                innerStream.forEach(array ->
                        System.out.println(array[0] + ", " + array[1] + ", " + array[2])
                )
        );
    }
}
