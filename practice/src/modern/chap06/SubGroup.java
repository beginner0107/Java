package modern.chap06;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import static modern.chap06.Dish.menu;
import static modern.chap06.Grouping.*;
import static modern.chap06.Grouping.CaloricLevel.*;

/**
 * 서브그룹으로 데이터 수집
 */
public class SubGroup {
    public static void main(String[] args) {
        Map<Dish.Type, Long> typesCount = menu.stream().collect(
                groupingBy(Dish::getType, counting())
        );
        System.out.println(typesCount);
        
        // 요리의 종류를 분류하는 컬렉터로 메뉴에서 가장 높은 칼로리를 가진 요리를 찾는 프로그램 구현
        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream().collect(
                groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories)))
        );
        System.out.println(mostCaloricByType);
        
        // 컬렉션 결과를 다른 형식에 적용하기
        Map<Dish.Type, Dish> mostCaloricByType2 = menu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(
                                maxBy(comparingInt(Dish::getCalories)),
                                Optional::get
                        )));

        Map<Dish.Type, Dish> mostCaloricByType3 = menu.stream()
                .collect(toMap(Dish::getType, Function.identity(), BinaryOperator.maxBy(comparingInt(Dish::getCalories))));

        // groupingBy와 함께 사용하는 다른 컬렉터 예제
        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
                .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        
        // 각 요리 형식에 존재하는 모든 CaloricLevel 값을 알고 싶다고 가정
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream()
                .collect(groupingBy(Dish::getType, mapping(dish -> {
                    if (dish.getCalories() <= 400) return DIET;
                    else if (dish.getCalories() <= 700) return NORMAL;
                    else return FAT;
                }, toSet())));
        System.out.println(caloricLevelsByType);

        Map<Dish.Type, HashSet<CaloricLevel>> caloricLevelsByType2 = menu.stream().collect(
                groupingBy(Dish::getType, mapping(dish -> {
                    if (dish.getCalories() <= 400) return DIET;
                    else if (dish.getCalories() <= 700) return NORMAL;
                    else return FAT;
                }, toCollection(HashSet::new)))
        );
        System.out.println(caloricLevelsByType2);
    }
}
