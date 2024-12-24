package modern.chap05;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

/**
 * 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정렬하시오
 * 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오
 * 3. 케임브리지에서 근무하는 모든 도거래자를 찾아서 이름 순으로 정렬하시오
 * 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
 * 5. 밀라노에 거래자가 있는가?
 * 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오
 * 7. 전체 트랜잭션 중 최댓값은 얼마인가?
 * 8. 전체 트랜잭션 중 최솟값은 얼마인가?
 */
public class Chap5Practice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        quiz1(transactions);
        quiz2(transactions);
    }

    // 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정렬하시오
    public static void quiz1(List<Transaction> transactions) {
        List<Transaction> results = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .toList();
        System.out.println(results);
    }

    // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오
    public static void quiz2(List<Transaction> transactions) {
        Set<String> cities = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .collect(toSet());
        System.out.println(cities);
    }

    // 3. 케임브리지에서 근무하는 모든 도거래자를 찾아서 이름 순으로 정렬하시오
    public static void quiz3(List<Transaction> transactions) {
        final String cambridge = "Cambridge";
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> cambridge.equals(trader.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .toList();
        System.out.println(traders);
    }

    // 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
    public static void quiz4(List<Transaction> transactions) {
        String traderStr = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

        String traderStr2 = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println(traderStr);
        System.out.println(traderStr2);
    }

    // 5. 밀라노에 거래자가 있는가?
    public static void quiz5(List<Transaction> transactions) {
        boolean milanBased = transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader()
                                .getCity().equals("Milan"));
        System.out.println(milanBased);
    }

    // 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오
    public static void quiz6(List<Transaction> transactions) {
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    // 7. 전체 트랜잭션 중 최댓값은 얼마인가?
    public static void quiz7(List<Transaction> transactions) {
        Optional<Integer> highestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
    }

    // 8. 전체 트랜잭션 중 최솟값은 얼마인가?
    public static void quiz8(List<Transaction> transactions) {
        Optional<Transaction> smallestTransaction = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);

        Optional<Transaction> smallestTransaction2 = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue));
    }
}
