package modern.chap06;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static modern.chap06.Dish.menu;

/**
 * partitioning function 
 * 프레디케이트를 분류 함수로 사용하는 특수한 그룹화 기능
 */
public class Partitioning {
    public static void main(String[] args) {
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);
        
        // 참 값의 키로 맵에서 모든 채식 요리를 얻을 수 있다
        List<Dish> vegetarianDishes = partitionedMenu.get(true);
        
        // 동일한 결과
        List<Dish> vegetarianDishes2 = menu.stream()
                .filter(Dish::isVegetarian).collect(toList());
        
        // 분할의 장점
        // 함수가 반환하는 참, 거짓 두 가지 요소의 스트림 리스트를 모두 유지한다는 것이 분할의 장점
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

        System.out.println(vegetarianDishesByType);
        
        // 채식 요리와 채식이 아닌 요리 각각의 그룹에서 가장 칼로리가 높은 요리 찾기
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian,
                        collectingAndThen(
                                maxBy(Comparator.comparingInt(Dish::getCalories)),
                                Optional::get
                        )));

        System.out.println(mostCaloricPartitionedByVegetarian);
    }
}
