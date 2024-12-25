package modern.chap05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 스트림 만들기
 */
public class StreamCreate {
    public static void main(String[] args) {
        // 값으로 스트림 만들기
        Stream<String> stream = Stream.of("Modern ", "Java ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
        
        // null이 될 수 있는 객체로 스트림 만들기
        // 자바 9에 추가된 기능
        String homeValue = System.getProperty("home");
        Stream<String> homeValueStream = homeValue == null ? Stream.empty() : Stream.of(homeValue);

        Stream<String> values = Stream.of("config", "home", "user")
                .flatMap(key -> Stream.ofNullable(System.getProperty(key)));

        // 배열로 스트림 만들기
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();

        // 파일로 스트림 만들기
        // 파일에서 고유한 단어 수를 찾는 프로그램
        long uniqueWords = 0;
        try(Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
//            throw new RuntimeException("파일을 찾을 수 없습니다.");
        }

        // 함수로 무한 스트림 만들기
        // 무한 스트림(infinite stream): iterate는 요청할 때마다 값을 생산할 수 있음
        // 언바운드 스트림(unbounded stream)
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
        
        // 자바 9의 iterate 메소드는 프레디케이트를 지원
        // 0에서 시작해서 100보다 크면 숫자 생성을 중단하는 코드를 다음처럼 구현할 수 있다
        IntStream.iterate(0, n -> n < 100, n -> n + 4)
                .forEach(System.out::println);
        
        // 실패하는 코드 - 종료되지 않음
//        IntStream.iterate(0, n -> n + 4)
//                .filter(n -> n < 100)
//                .forEach(System.out::println);

        // 스트림 - takeWhile을 이용하는 것이 해법
        IntStream.iterate(0, n -> n + 4)
                .takeWhile(n -> n < 100)
                .forEach(System.out::println);
        
        // generate 메서드
        // generate 는 Supplier<T>를 인수로 받아서 새로운 값을 생산
        // 0부터 1 사이에서 임의의 더블 숫자 다섯 개를 만드는 예제
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };

        IntStream.generate(fib).limit(10).forEach(System.out::println);
    }
}
