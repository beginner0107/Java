package modern.chap06;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static modern.chap06.Dish.menu;

public class CollectorsExample {
    public static void main(String[] args) {
        CollectorsExample instance = new CollectorsExample();
        instance.ex7();
        instance.ex8();
    }

    // toList: 스트림의 모든 항목을 리스트로 수집
    public void ex1() {
        Stream<Dish> menuStream = menu.stream();
        List<Dish> dishes = menuStream.toList();
    }

    // toSet: 스트림의 모든 항목을 중복이 없는 집합으로 수집
    public void ex2() {
        Stream<Dish> menuStream = menu.stream();
        Set<Dish> dishes = menuStream.collect(toSet());
    }

    // toCollection: 스트림의 모든 항목을 발행자가 제공하는 컬렉션으로 수집
    public void ex3() {
        Stream<Dish> menuStream = menu.stream();
        Collection<Dish> dishes = menuStream.collect(Collectors.toCollection(ArrayList::new));
    }

    // counting: 스트림의 항목 수 계산
    public void ex4() {
        Stream<Dish> menuStream = menu.stream();
        Long howManyDishes = menuStream.collect(counting());
    }

    // summingInt: 스트림의 항목에서 정수 프로퍼티 값을 더함
    // mapToInt: IntStream 지원하는 함수, 매개변수 ToIntFunction 의 시그니처 -> T -> int 반환
    public void ex5() {
        Stream<Dish> menuStream = menu.stream();
//        int totalCalories = menuStream.collect(summingInt(Dish::getCalories));
        int totalCalories = menuStream.mapToInt(Dish::getCalories).sum();
    }

    // averagingInt: 스트림 항목의 정수 프로퍼티의 평균값 계산
    public void ex6() {
        Stream<Dish> menuStream = menu.stream();
        double avgCalories = menuStream.collect(averagingInt(Dish::getCalories));
    }

    // summarizingInt: 스트림 내 항목의 최대값, 최솟값, 합계, 평균 등의 정수 정보 통계 수집
    public void ex7() {
        Stream<Dish> menuStream = menu.stream();
        IntSummaryStatistics menuStatics = menuStream.collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatics);
    }

    // joining: 스트림의 각 항목에 toString 메서드를 호출한 결과 문자열 연결
    public void ex8() {
        String menuNames = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(menuNames);
    }

    // maxBy: 주어진 비교자를 이용해서 스트림의 최댓값 요소를 Optional로 감싼 값을 반환
    public void ex9() {
        Optional<Dish> fattest = menu.stream()
                .collect(maxBy(comparingInt(Dish::getCalories)));

        Optional<Dish> fattest2 = menu.stream()
                .max(comparingInt(Dish::getCalories));

        Dish fattestDish = menu.stream()
                .collect(collectingAndThen(
                        maxBy(comparingInt(Dish::getCalories))
                        , Optional::get));
    }

    // minBy: 주어진 비교자를 이용해서 스트림의 최솟값 요소를 Optional로 감싼 값을 반환
    public void ex10() {
        Optional<Dish> lightest = menu.stream()
                .collect(minBy(comparingInt(Dish::getCalories)));

        Optional<Dish> lightest2 = menu.stream()
                .min(comparingInt(Dish::getCalories));

        Dish lightestDish = menu.stream()
                .collect(collectingAndThen(
                        minBy(comparingInt(Dish::getCalories))
                        , Optional::get
                ));
    }

    // reducing: 누적자를 초깃값으로 설정한 다음에 BinaryOperator로 스트림의
    // 각 요소를 반복적으로 누적자와 합쳐 스트림을 하나의 값으로 리듀싱
    public void ex11() {
        Optional<Integer> totalCalories = menu.stream()
                .map(Dish::getCalories)
                .collect(reducing(Integer::sum));

        Integer totalCalories2 = menu.stream()
                .collect(reducing(0, Dish::getCalories, Integer::sum));

        Integer totalCalories3 = menu.stream().map(Dish::getCalories)
                .reduce(0, Integer::sum);
    }

    // collectingAndThen: 다른 컬렉터를 감싸고 그 결과에 변환 함수 적용
    public void ex12() {
        int howManyDishes = menu.stream()
                .collect(collectingAndThen(
                        toList()
                        , List::size
                ));
    }

    // groupingBy: 하나의 프로퍼티값을 기준으로 스트림 항목을 그룹화하며
    // 기준 프로퍼티값을 결과 맵의 키로 사용
    public void ex13() {
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
                .collect(groupingBy(Dish::getType));
    }

    // partitioningBy: predicate를 스트림 각 항목에 적용한 결과로 항목 분할
    public void ex14() {
        Map<Boolean, List<Dish>> vegetarianDishes = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));
    }
}
