package modern.chap06;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;
import static modern.chap06.Dish.menu;

/**
 * 리듀싱으로 문자열 연결하기
 * joining 컬렉터를 6.2.3절에서 사용한 reducing 컬렉털로 올바르게 바꾼 코드를 모두 선택
 */
public class Quiz_6_1 {
    public static void main(String[] args) {
        String shortMenu = menu.stream().map(Dish::getName).collect(joining());
        String shortMenu1 = menu.stream().map(Dish::getName).collect(reducing((s1, s2) -> s1 + s2)).get();
//        String shortMenu2 = menu.stream().collect(reducing((d1, d2) -> d1.getName() + d2.getName())).get();
        String shortMenu3 = menu.stream().collect(reducing("", Dish::getName, (a, b) -> a + b));

        System.out.println("shortMenu = " + shortMenu);
        System.out.println("shortMenu1 = " + shortMenu1);
        System.out.println("shortMenu3 = " + shortMenu3);
    }
}
