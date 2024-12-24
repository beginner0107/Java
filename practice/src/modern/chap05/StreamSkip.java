package modern.chap05;

import java.util.List;

import static modern.chap05.Dish.menu;

/**
 * 요소 건너뛰기
 *
 * skip(n) 메서드: n개 이하의 요소를 포함하는 스트림에 skip(n)을 호출하면 빈 스트림이 반환
 */
public class StreamSkip {
    public static void main(String[] args) {
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .toList();
    }
}
