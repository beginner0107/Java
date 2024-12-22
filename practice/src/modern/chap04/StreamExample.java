package modern.chap04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 스트림의 특성
 * 딱 한 번만 탐색할 수 있다
 */
public class StreamExample {
    public static void main(String[] args) {
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println); // java.lang.IllegalStateException
    }
}
