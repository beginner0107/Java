package modern.chap05;

import java.util.List;

import static modern.chap05.Dish.menu;

/**
 * 스트림을 이용해서 처음 등장하는 두 고기 요리를 필터링하시오.
 */
public class Quiz_5_1 {
    public static void main(String[] args) {
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .limit(2)
                .toList();
    }
}
