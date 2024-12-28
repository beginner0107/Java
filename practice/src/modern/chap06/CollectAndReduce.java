package modern.chap06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 의미론적인 문제: 
 * - collect 메서드는 도출하려는 결과를 누적하는 컨테이너를 바꾸도록 설계된 메서드
 * - reduce 메서드는 누적자로 사용된 리스트를 변환시키므로 reduce를 잘못 활용한 예
 * 실용적 문제: 
 * - 여러 스레드가 동시에 같은 데이터 구조체를 고치면 리스트 자체가 망가져버려 연산을 병렬로 수핼할 수 없다
 */
public class CollectAndReduce {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();

        List<Integer> numbers = stream.reduce(new ArrayList<>()
                , (List<Integer> l, Integer e) -> {
                    l.add(e);
                    return l;
                }
                , (List<Integer> l1, List<Integer> l2) -> {
                    l1.addAll(l2);
                    return l1;
                });
    }
}
