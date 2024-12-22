package modern.chap03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.comparingInt;
import static modern.chap03.Color.GREEN;

/**
 * 람다 표현식을 표현할 수 있는 유용한 메서드
 */
public class LambdaUtilMethod {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple(120, Color.RED, "Brazil"),
                new Apple(12, GREEN, "Korea"),
                new Apple(30, Color.RED, "Japan"),
                new Apple(90, GREEN, "China")
        );

        // 역정렬
        apples.sort(comparingInt(Apple::getWeight).reversed());

        // Comparator 연결
        // 무게로 사과를 비교하고, 두 객체가 같으면 두 번째 비교자에 객체를 전달
        apples.sort(comparingInt(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getCountry));

        // Predicate 조합
        Predicate<Apple> redApple = (apple) -> apple.getWeight() > 150;
        // negate 반전
        Predicate<Apple> notRedApple = redApple.negate(); // 두 Predicate를 연결해서 새로운 객체 만듦

        // and
        Predicate<Apple> redAndHeavyApple = redApple.and(apple -> apple.getWeight() > 150)
                .or(apple -> GREEN.equals(apple.getColor()));

        // Function 조합
        // andThen 메서드는 인수로 주어진 함수를 먼저 실행한 다음에 그 결괴를 외부 함수의 인수로 제공
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        int result = h.apply(1);

        Function<Integer, Integer> z = f.compose(g);
        int result2 = z.apply(1); // 수학적으로는 f(g(x)) 또는 (f o g)(x)
    }
}
