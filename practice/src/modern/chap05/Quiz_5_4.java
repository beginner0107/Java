package modern.chap05;

import java.util.stream.Stream;

/**
 * 피보나치수열 집합
 * 
 * iterator 메서드를 이용해서 피보나치 수열의 집합을 20개 만드는 것
 */
public class Quiz_5_4 {
    public static void main(String[] args) {
        Stream.iterate(new int[]{0, 1}, (arr) -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));
    }
}
