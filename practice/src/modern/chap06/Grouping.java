package modern.chap06;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static modern.chap06.Dish.menu;

public class Grouping {
    public enum CaloricLevel {DIET, NORMAL, FAT}

    public static void main(String[] args) {
        // 메뉴를 그룹화 해보자
        // groupingBy -> 분류 함수 (classification function)
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));

        System.out.println(dishesByType);

        // 400칼로리 이하를 'diet', 400~700칼로리 'normal', 700 칼로리 초과를 'fat'
        // 혼자 만든 함수..
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
                .collect(groupingBy(a -> a.getCalories() <= 400 ? CaloricLevel.DIET :
                        a.getCalories() <= 700 ? CaloricLevel.NORMAL : CaloricLevel.FAT));
        System.out.println(dishesByCaloricLevel);

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel2 = menu.stream()
                .collect(groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }));
        System.out.println(dishesByCaloricLevel2);
        
        // 500칼로리만 넘는 요리만 필터링해보자
        Map<Dish.Type, List<Dish>> caloricDishesByType = menu.stream()
                .filter(dish -> dish.getCalories() > 500)
                .collect(groupingBy(Dish::getType));
        System.out.println(caloricDishesByType);

        Map<Dish.Type, List<Dish>> caloricDishesByType2 = menu.stream()
                .collect(groupingBy(
                        Dish::getType,
                        filtering(
                                dish -> dish.getCalories() > 500, // 조건
                                Collectors.toList()               // 조건을 만족하는 요소만 리스트로 수집
                        )
                ));
        System.out.println(caloricDishesByType2);
        
        // 다수준 그룹화
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(
                groupingBy(Dish::getType,
                        groupingBy(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        }))
        );
        System.out.println(dishesByTypeCaloricLevel);
    }
}
