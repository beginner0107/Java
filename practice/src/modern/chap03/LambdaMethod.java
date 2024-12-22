package modern.chap03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class LambdaMethod {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
          new Apple(120, Color.RED),
          new Apple(12, Color.GREEN),
          new Apple(30, Color.RED),
          new Apple(90, Color.GREEN)
        );

        // 1단계 코드 전달
        apples.sort(new AppleComparator()); 
        
        // 2단계 익명 클래스 사용
        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });

        // 3단계 람다 표현식 활용
        apples.sort((o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight()));

        // 4단계 메서드 참조 활용
//        ToIntFunction<Apple> toIntFunction = (apple) -> apple.getWeight();
        apples.sort(comparingInt(Apple::getWeight));
    }
}

class AppleComparator implements Comparator<Apple> {
    public int compare(Apple a1, Apple a2) {
        return Integer.compare(a1.getWeight(), a2.getWeight());
    }
}
