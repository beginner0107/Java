package modern.chap03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 기본형 특화: 제네릭 파라미터에는 참조형만 사용할 수 있음
 * 참조형: Byte, Integer, Object, List
 * 원시타입 불가능: int, double, long, byte, char
 *
 * 그래서 나온 기능
 * 박싱: boxing
 * 언박싱: unboxing
 * 오토박싱: autoboxing
 */
public class Lambdas3 {
    public static void main(String[] args) {
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> listOfStrings = List.of("test1", "test2", "", "test3", "");
        List<String> notEmpty = filter(listOfStrings, nonEmptyStringPredicate);
        System.out.println(notEmpty);

        forEach(List.of(1, 2, 3, 4, 5), (Integer i) -> System.out.println(i));

        List<Integer> l = map(
                List.of("lambdas", "in", "action"),
                (String s) -> s.length()
        );
        System.out.println(l);
    }

    // Predicate
    public static <T>List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) results.add(t);
        }
        return results;
    }

    // Consumer
    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    // Function
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }
}
