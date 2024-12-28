package modern.chap06;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static modern.chap06.Dish.menu;

public class Quiz_6_2 {
    public static void main(String[] args) {
        Map<Boolean, Map<Boolean, List<Dish>>> menu1 = menu.stream().collect(partitioningBy(Dish::isVegetarian,
                partitioningBy(d -> d.getCalories() > 500)));

        // partitioningBy는 불리언을 반환하는 함수, 컴파일 되지 않는 코드
//        menu.stream().collect(partitioningBy(Dish::isVegetarian, partitioningBy(Dish::getType)));

        Map<Boolean, Long> menu2 = menu.stream().collect(partitioningBy(Dish::isVegetarian, counting()));
    }
}
