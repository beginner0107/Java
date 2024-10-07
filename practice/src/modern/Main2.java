package modern;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main2 {
    public static void main(String[] args) {
        // 정적 메서드 참조
        Function<String, Integer> parseIntLambda = (x) -> Integer.parseInt(x);
        Function<String, Integer> parseIntMethodRef = Integer::parseInt;

        System.out.println(parseIntLambda.apply("10"));
        System.out.println(parseIntMethodRef.apply("10"));

        // 인스턴스 메서드 참조 (Instant Method Reference with an Argument)
        BiFunction<String, String, Integer> compareLambda = (x, y) -> x.compareTo(y);
        BiFunction<String, String, Integer> compareMethodRef = String::compareTo;

        System.out.println(compareLambda.apply("apple", "banana"));
        System.out.println(compareMethodRef.apply("apple", "banana"));

        // 특정 객체의 인스턴스 메서드 참조 (Instance Method Reference with a Specific Object)
        SomeClass someObject = new SomeClass();

        Consumer<String> doSomethingLambda = (x) -> someObject.doSomething(x);
        Consumer<String> doSomethingMethodRef = someObject::doSomething;

        doSomethingLambda.accept("Hello from lambda");
        doSomethingMethodRef.accept("Hello From lambda");
    }
}

class SomeClass {
    public void doSomething(String message) {
        System.out.println(message);
    }
}
