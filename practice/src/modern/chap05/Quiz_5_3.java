package modern.chap05;

import static modern.chap05.Dish.menu;

/**
 * map과 reduce 메서드를 이용해서 스트림의 요리 개수를 계산하시오.
 */
public class Quiz_5_3 {
    public static void main(String[] args) {
        // 스트림의 각 요소를 1로 매핑한 다음에 reduce 로 이들의 합계를 계산하는 방식
        // 맵 리듀스 (map-reduce 패턴)
        int count =
                menu.stream()
                        .map(_ -> 1)
                        .reduce(0, Integer::sum);

        long count2 = menu.size();
    }
}
