package modern.chap05;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static modern.chap05.Dish.menu;

public class StreamExample3 {
    public static void main(String[] args) {
        // 프레디케이트로 필터링
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        // 고유 요소 필터링
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
}
