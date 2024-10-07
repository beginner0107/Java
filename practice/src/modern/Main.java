package modern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Main {
    public void test() {
        ToIntFunction<String> stringToInt = Integer::parseInt;
        BiPredicate<List<String>, String> contains = List::contains;
        Predicate<String> startsWithNumber = this::startsWithNumber;
    }

    public boolean startsWithNumber(String string) {
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Runnable runnable = main::test;
        runnable.run();

        List<Integer> weights = Arrays.asList(7, 3, 4, 10);

        List<Apple> apples = map(weights, Apple::new);
        apples.stream()
                .map(Apple::getWeight)
                .forEach(System.out::println);

        Function<String, Integer> stringIntegerIntegerBiFunction = Integer::parseInt;
        System.out.println(stringIntegerIntegerBiFunction.apply("123"));
    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer i : list) {
            result.add(f.apply(i));
        }
        return result;
    }
}

class Apple {
    private int weight;

    public Apple(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
