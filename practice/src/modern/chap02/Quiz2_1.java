package modern.chap02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static modern.chap02.FilteringApples.Apple;
import static modern.chap02.FilteringApples.Color.GREEN;

/**
 * 사과 리스트를 인수로 받아 다양한 방법으로 문자열을 생성할 수 있도록 파라미터화된 prettyPrintApple 메서드를 구현하시오
 */
public class Quiz2_1 {

    public static void main(String[] args) {
        List<FilteringApples.Apple> inventory = Arrays.asList(
                new FilteringApples.Apple(80, GREEN),
                new FilteringApples.Apple(155, GREEN),
                new FilteringApples.Apple(120, FilteringApples.Color.RED));

        prettyPrintApple(inventory, (apple) -> "사과의 무게는 " + apple.getWeight() + "\n" + "사과의 색깔은 " + apple.getColor() + " 입니다.");
    }

    // 내가 작성한 코드
    // 매개변수로 Function 함수를 값처럼 받아 기능 구현
    public static void prettyPrintApple (List<Apple> inventory, Function<Apple, String> function) {
        for (Apple apple : inventory) {
            String output = function.apply(apple);
            System.out.println(output);
        }
    }

    public interface AppleFormatter {
        String accept(Apple a);
    }

    public static void prettyPrintApple2 (List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public class AppleFancyFormatter implements AppleFormatter {
        @Override
        public String accept(Apple apple) {
            String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
            return "A " + characteristic + " " + apple.getColor() + " apple";
        }
    }

    public class AppleSimpleFormatter implements AppleFormatter {
        @Override
        public String accept(Apple apple) {
            return "An apple of " + apple.getWeight() + "g";
        }
    }
}
