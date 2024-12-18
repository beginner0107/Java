package modern.chap02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static modern.chap02.FilteringApples.Color.GREEN;
import static modern.chap02.FilteringApples.Color.RED;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, GREEN),
                new Apple(155, GREEN),
                new Apple(120, Color.RED));

        List<Apple> greenApples = filterGreenApples(inventory);
        System.out.println(greenApples);

        List<Apple> greenApples1 = filterApplesByColor(inventory, GREEN);
        List<Apple> redApples = filterApplesByColor(inventory, RED);
        System.out.println(greenApples1);
        System.out.println(redApples);
        
        List<Apple> filterWeight = filterApplesByWeight(inventory, 100);
        System.out.println(filterWeight); // 100보다 낮은 사과를 필터링한다

        // true, false는 어떤 것을 의미하는 것인가?
        List<Apple> greenApples2 = filterApples(inventory, GREEN, 0, true);
        List<Apple> heavyApples = filterApples(inventory, null, 150, false);

        List<Apple> greenApples3 = filter(inventory, new AppleGreenColorPredicate());
        List<Apple> heavyApples2 = filter(inventory, new AppleHeavyWeightPredicate());
        
        // 익명 클래스
        List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return RED.equals(apple.getColor());
            }
        });
        System.out.println(redApples2);

        // 자바 8의 람다 표현식
        List<Apple> result = filter(inventory, apple -> RED.equals(apple.getColor()));
//        List<Apple> result = filter(inventory, (Apple apple) -> RED.equals(apple.getColor()));

        // 리스트 형식으로 추상화
        List<Apple> redApples3 = filter2(inventory, apple -> RED.equals(apple.getColor()));
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumber = filter2(numbers, i -> i % 2 == 0);

    }

    // Predicate 라는 우리가 정의한 조건의 함수를 값처럼 받아서 쓸 수 있다는 점
    // 상황에 맞게 boolean 값을 반환하는 함수를 매개변수(값)로 받아서 사용할 수 있다는 점에서 매우 유연한 구조라고 할 수 있음
    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) result.add(apple);
        }
        return result;
    }
    
    // 더 추상화
    public static <T>List<T> filter2(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) result.add(e);
        }
        return result;
    }

    // 녹색 사과를 필터링하는 메서드
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())) result.add(apple);
        }
        return result;
    }

    // 빨간 사과도 필터링하고 싶다면?
    // 복붙을 해서 사용하기보다는 다양한 색이 추가되었을 경우 대응이 어려움
    // 거의 비슷한 코드가 반복 존재한다면 그 코드를 추상화한다
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) result.add(apple);
        }
        return result;
    }

    // 무게 정보로 필터링 하는 조건이 추가되면?
    // 그렇게 좋은 해결책이 아니다
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) result.add(apple);
        }
        return result;
    }

    // 세 번째 시도: 가능한 모든 속성으로 필터링
    // 형편 없는 코드
    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    enum Color {
        RED,
        GREEN
    }

    public static class Apple {
        private int weight = 0;
        private Color color;

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color='%s', weight=%d}", color, weight);
        }
    }

    // 참 or 거짓을 반환하는 함수 - (Predicate)
    interface ApplePredicate{ // 알고리즘 패밀리
        boolean test(Apple a);
    }
    
    // 다양한 선택 조건을 대표하는 여러 버전의 ApplePredicate 정의 가능
    // 사과를 선택화 하는 다양한 전략
    // ApplePredicate 는 사과 선택 전략을 캡슐화 함
    // 동작 파라미터화, 즉 메서드가 다양한 동작(또는 전략)을 받아서 내부적으로 다양한 동작을 수행할 수 있음
    static class AppleHeavyWeightPredicate implements ApplePredicate { // 무거운 사과만 선택
        @Override
        public boolean test(Apple a) {
            return a.getWeight() > 150;
        }
    }

    static class AppleGreenColorPredicate implements ApplePredicate  { // 녹색 사과만 선택
        @Override
        public boolean test(Apple a) {
            return GREEN.equals(a.getColor());
        }
    }
}
