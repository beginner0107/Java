package modern.chap03;

import java.util.Comparator;

/**
 * 형식 추론
 * 
 * 1번: 명시적으로 형식 포함
 * 2번: 형식 제거
 * 3번: Comparator 의 정적메서드에 매개변수에 함수형 인터페이스를 넣어주어 더 간단하게 구현
 */
public class Lambdas5 {
    public static void main(String[] args) {
        Comparator<Apple> c = (Apple a1, Apple a2) -> Integer.compare(a1.getWeight(), a2.getWeight());
        Comparator<Apple> c2 = (a1, a2) -> Integer.compare(a1.getWeight(), a2.getWeight());
        Comparator<Apple> c3 = Comparator.comparingInt(Apple::getWeight);
    }
}
