package modern.chap03;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 생성자 참조
 */
public class ConstructorReference {

    static Map<String, Function<Integer, Fruit>> map = new HashMap<>();
    static {
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }

    public static void main(String[] args) {
        Supplier<Apple> c1 =  Apple::new; // Supplier 의 get 메서드를 호출해서 새로운 Apple 객체 생성
        Apple a1 = c1.get();

        Function<Integer, Apple> c2 = Apple::new; // Apple(Integer weight)의 생성자 참조
        Apple a2 = c2.apply(110);

        // Integer 를 포함하는 리스트의 각 요소를 저의했던 map 같은 메서드를 이용해서 Apple 생성자로 전달
        // 결과적으로 다양한 무게를 포함하는 사과 리스트가 만들어짐
        List<Integer> weights = Arrays.asList(6, 3, 2, 1);

        List<Apple> apples = weights.stream()
                .map(Apple::new)
                .toList();

        System.out.println(apples);

        List<Apple> apples2 = map(weights, Apple::new);
        System.out.println(apples2);

        // 인스턴스화 하지 않고 생성자에 접근할 수 있음
        BiFunction<Integer, Color, Apple> c3 = Apple::new;
        Apple a3 = c3.apply(110, Color.GREEN);

        Orange orange = (Orange) giveMeFruit("orange", 110);
        System.out.println(orange);

        Apple apple = (Apple) giveMeFruit("apple", 110);
        System.out.println(apple);
    }

    public static Fruit giveMeFruit(String fruit, Integer weight) {
        return map.get(fruit.toLowerCase())
                .apply(weight);
    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer i : list) {
            result.add(f.apply(i));
        }
        return result;
    }
}
