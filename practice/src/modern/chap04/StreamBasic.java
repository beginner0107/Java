package modern.chap04;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamBasic {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;

        // 기존 코드
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }

        // lowCaloricDishes 라는 '가비지 변수' 사용
        
        // 자바 8에서 세부 구현은 라이브러리 내에서 모두 처리
        List<String> lowCaloricDishesName2 =
                menu.stream()
                        .filter(dish -> dish.getCalories() < 400) // 400칼로리 이하
                        .sorted(Comparator.comparingInt(Dish::getCalories)) // 칼로리로 요리 정렬
                        .map(Dish::getName) // 요리명 추출
                        .toList(); // 모든 요리명을 리스트에 저장

        // 멀티코어 아키텍처에서 병렬로 실행할 수 있음
        List<String> lowCaloricDishesName3 =
                menu.parallelStream()
                        .filter(dish -> dish.getCalories() < 400) // 400칼로리 이하
                        .sorted(Comparator.comparingInt(Dish::getCalories)) // 칼로리로 요리 정렬
                        .map(Dish::getName) // 요리명 추출
                        .toList(); // 모든 요리명을 리스트에 저장
        
        // 스트림 API는 매우 비싼 연산
        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));

        System.out.println(dishesByType);
    }
}
