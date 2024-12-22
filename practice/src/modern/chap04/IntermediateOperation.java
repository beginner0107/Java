package modern.chap04;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static modern.chap04.Dish.menu;

/**
 * 중간 연산
 */
public class IntermediateOperation {
    public static void main(String[] args) {
        List<String> names =
                menu.stream()
                        .filter(dish -> {
                            System.out.println("filtering: " + dish.getName());
                            return dish.getCalories() > 180;
                        })
                        .map(dish -> {
                            System.out.println("mapping: " + dish.getName());
                            return dish.getName();
                        })
                        .limit(3)
                        .collect(toList());
        System.out.println(names);
    }
}
