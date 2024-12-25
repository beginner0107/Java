package modern.chap06;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.summarizingInt;
import static modern.chap06.Dish.menu;

public class Summarizing {
    public static void main(String... args) {
        System.out.println("Nr. of dishes: " + howManyDishes());
        System.out.println("The most caloric dish is: " + findMostCaloricDish());
        System.out.println("The most caloric dish is: " + findMostCaloricDishUsingComparator());
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Average calories in menu: " + calculateAverageCalories());
        System.out.println("Menu statistics: " + calculateMenuStatistics());
        System.out.println("Short menu: " + getShortMenu());
        System.out.println("Short menu comma separated: " + getShortMenuCommaSeparated());
    }

    private static long howManyDishes() {
//        return menu.stream().collect(Collectors.counting());
        return menu.stream().count();
    }

    private static Dish findMostCaloricDish() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream()
                .max(dishCaloriesComparator);
        return mostCalorieDish.get();
    }

    private static Dish findMostCaloricDishUsingComparator() {
        return null;
    }

    private static int calculateTotalCalories() {
        return 0;
    }

    private static Double calculateAverageCalories() {
        double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        return avgCalories;
    }

    private static IntSummaryStatistics calculateMenuStatistics() {
        IntSummaryStatistics menuStatics = menu.stream().collect(summarizingInt(Dish::getCalories));
        return menuStatics;
    }

    private static String getShortMenu() {
        return null;
    }

    private static String getShortMenuCommaSeparated() {
        return null;
    }
}
