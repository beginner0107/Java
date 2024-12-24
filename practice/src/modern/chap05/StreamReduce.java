package modern.chap05;

import java.util.Arrays;
import java.util.List;

/**
 * 스트림 축소
 */
public class StreamReduce {
    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER)
        );

        // filter + limit 조합, 소스가 정렬되어 있지 않다면 정렬되지 않은 상태로 반환
        List<Dish> dishes = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .toList();
    }
}
