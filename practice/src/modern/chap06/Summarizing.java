package modern.chap06;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collector;

import static java.util.stream.Collectors.*;
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
//        long count = menu.stream().count();
        long count = menu.stream().collect(counting());
        return count;
    }

    private static Dish findMostCaloricDish() {
        Optional<Dish> mostCalorieDish = menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        return mostCalorieDish.get();
    }

    private static Dish findMostCaloricDishUsingComparator() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream()
                .max(dishCaloriesComparator);
        return mostCalorieDish.get();
    }

    private static int calculateTotalCalories() {
//        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        // 범용 리듀싱 요역 연산
//        int totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
//        int totalCalories = menu.stream().collect(reducing(0,
//                Dish::getCalories, Integer::sum));
        int totalCalories = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        return totalCalories;
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
        return menu.stream().map(Dish::getName).collect(joining(", "));
    }

    private static String getShortMenuCommaSeparated() {
        return null;
    }

    public static <T>Collector<T, ?, Long> counting() {
        return reducing(0L, _ -> 1L, Long::sum);
    }
}
