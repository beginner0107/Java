package modern.chap05;

import java.util.Arrays;
import java.util.List;

/**
 * 스트림 슬라이싱
 * 
 * 자바 9: 스트림의 요소를 효과적으로 선택할 수 있도록 takeWhile, dropWhile 메서드 제공
 */
public class StreamSlicing {
    public static void main(String[] args) {
        // takeWhile
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER)
        );

        // 320칼로리 이하의 요리를 선택하는 예제
        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .toList();

        // specialMenu 리스트는 칼로리 순으로 정렬되어 있다
        // 320칼로리보다 크거나 같은 요리가 나왔을 때 반복 작업을 중단할 수 있음
        // takeWhile을 이용하면 무한 스트림을 포함한 모든 스트림에 프레디케이트를 적용해 스트림을 슬라이스 할 수 있음
        List<Dish> slicedMenu = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .toList();


        // DropWhile: 나머지 요소를 선택
        // 계속 탐색하다가 거짓을 반환할 때, 이전 요소들을 버리고 남은 요소를 반환
        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .toList();
    }
}
