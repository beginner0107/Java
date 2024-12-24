package modern.chap05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static modern.chap05.Dish.menu;

/**
 * allMatch, anyMatch, noneMatch, findFirst, findAny
 *
 * allMatch, anyMatch, noneMatch -> 스트림 쇼트서킷 기법, 자바의 &&, || 와 같은 연산 활용
 */
public class StreamUtil {
    public static void main(String[] args) {
        // Predicate 적어도 한 요소와 일치하는지 확인
        if(menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        // Predicate 모든 요소와 일치하는지 확인
        boolean isHealthy = menu.stream()
                .allMatch(d -> d.getCalories() >= 1000);

        // NONE MATCH -> ALL MATCH 의 반대 연산
        boolean isHealthy2 = menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);

        // findAny
        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();

        // Optional이란?
        // null은 쉽게 에러를 일으킬 수 있으므로 나온 자바8의 기법
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));

        // 리스트 또는 정렬된 연속 데이터로부터 생성된 스트림처럼 일부 스트림에는 논리적인 아이템 순서가 정해져 있을 수 있다
        // 이런 스트림에서 첫 번째 요소를 찾으려면 어떻게 해야 할까?
        // 숫자 리스트에서 3으로 나누어떨어지는 첫 번째 제곱값을 반환하는 코드를 짜보자
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();
    }
}
