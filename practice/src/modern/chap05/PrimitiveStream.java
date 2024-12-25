package modern.chap05;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static modern.chap05.Dish.menu;

/**
 * 기본형 특화 스트림
 */
public class PrimitiveStream {

    public static void main(String[] args) {
        // 숫자 스트림으로 매핑
        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        // 객체 스트림으로 복원
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

        // 기본값: OptionalInt
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        
        int max = maxCalories.orElse(1); // 값이 없을 때 개본 최대값을 명시적으로 설정
    }
}
