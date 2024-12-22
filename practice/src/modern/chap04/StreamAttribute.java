package modern.chap04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 전자의 경우 1부터 10000000의 숫자를 컬렉션 List 에 적재 후
 * 다시 for 문을 통해 10개의 소수를 추출한다
 *
 * 후자의 경우 스트림 기반으로 Stream 에서 범위를 정하고
 * 바로 연산이 이루어지지 않고 filter 와 limit 파이프라인을 구성하고
 * 소수를 찾는 filter 연산이 10번 이루어졌을 때(참) 
 * 숫자 생성을 멈추고 Integer 로 박싱(boxing) 후 
 * List 로 변환한다
 */
public class StreamAttribute {
    public static void main(String[] args) {
        // 컬렉션 기반 소수를 10개 List 로 만드는 예시
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10000000; i++) {
            numbers.add(i);
        }

        List<Integer> decimals = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // 10개만..!
            if (numbers.get(i) % 2 != 0) decimals.add(numbers.get(i));
        }

        // 스트림 기반 소수를 10개 List 로 만드는 예시
        List<Integer> decimals2 = IntStream.range(1, 10000000)
                .filter(i -> i % 2 != 0)
                .limit(10)
                .boxed()
                .toList();
    }
}
