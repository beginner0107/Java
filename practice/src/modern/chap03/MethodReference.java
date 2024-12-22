package modern.chap03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * 메서드 참조
 */
public class MethodReference {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>(List.of(
                new Apple(40, Color.RED),
                new Apple(120, Color.GREEN),
                new Apple(10, Color.GREEN),
                new Apple(90, Color.RED)
        ));

        // 기존 코드
        inventory.sort((Apple a1, Apple a2) -> Integer.compare(a1.getWeight(), a2.getWeight()));

        // 타입 추론
        inventory.sort((a1, a2) -> Integer.compare(a1.getWeight(), a2.getWeight()));

        // 메서드 참조
        inventory.sort(Comparator.comparingInt(Apple::getWeight));

        // predicate 메서드 참조
        List<String> words = List.of("a", "b", "A", "B");

        MethodReference methodReference = new MethodReference();
        List<String> filteringWords = filter(words, methodReference::isValidName);
        System.out.println(filteringWords);
    }

    public static <T> List<T> filter(List<T> words, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T word : words) {
            if (p.test(word)) result.add(word);
        }
        return result;
    }

    public boolean isValidName(String string) {
        return Character.isUpperCase(string.charAt(0));
    }
}
