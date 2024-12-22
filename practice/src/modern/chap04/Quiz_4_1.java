package modern.chap04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static modern.chap04.Dish.menu;

/**
 * 스트림 동작을 통해서 리팩토링 하는 문제
 */
public class Quiz_4_1 {
    public static void main(String[] args) {
        List<String> highCaloricDishes = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            if (dish.getCalories() > 300) {
                highCaloricDishes.add(dish.getName());
            }
        }

        List<String> highCaloricDishes2 = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .toList();
    }
}
