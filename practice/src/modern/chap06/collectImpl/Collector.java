package modern.chap06.collectImpl;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.stream.Collector.Characteristics;

/**
 * Collector 인터페이스를 만들어보자
 * T 는 수집될 스트림 항목의 제네릭 형식
 * A 는 누적자, 수집 과정에서 중간 결과를 누적하는 객체의 형식
 * R 은 수집 연산 결과 객체의 형식(항상 그런 것은 아니지만 대부분 컬렉션)
 */
public interface Collector<T, A, R> {
    Supplier<A> supplier();
    BiConsumer<A, T> accumulator();
    Function<A, R> finisher();
    BinaryOperator<A> combiner();
    Set<Characteristics> characteristics();
}
