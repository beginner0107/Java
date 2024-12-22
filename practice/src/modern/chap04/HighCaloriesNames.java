package modern.chap04;

import java.util.List;

public class HighCaloriesNames {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;

        List<String> threeHighCaloricDishNames = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .toList();
        System.out.println(threeHighCaloricDishNames);
    }
}
