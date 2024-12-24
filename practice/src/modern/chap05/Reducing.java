package modern.chap05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * reduce는 두 개의 인수를 가짐
 * - 초깃값 0
 * - 두 요소를 조합해서 새로운 값을 만드는 BinaryOperator<T>
 * 예제에서는 람다 표현식 (a, b) -> a + b를 사용
 */
public class Reducing {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 요소의 합 - 일반적인 코드
        int sum = 0; // sum 변수의 초기값
        for (int x : numbers) {
            sum += x;// 리스트의 모든 요소를 조합하는 연산 (+)
        }

        // 위 코드를 복사 & 붙여넣기 하지 않고 모든 숫자를 곱하는 연산을 구현할 수 있나?
        int sum1 = numbers.stream().reduce(0, (a, b) -> a + b);

        int product = numbers.stream().reduce(1, (a, b) -> a * b);

        // 메서드 참조
        int sum2 = numbers.stream().reduce(0, Integer::sum);

        // 초깃값을 받지 않도록 오버로드된 reduce
        // 초깃값이 없으므로 reduce는 합계를 반환할 수 없음 -> Optional 객체로 감싼 결과를 반환
        Optional<Integer> sum3 = numbers.stream().reduce((a, b) -> (a + b));

        // 최댓값과 최솟값
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
    }
}
