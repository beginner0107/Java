package modern.chap06;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingTransactions {

  public static List<Transaction> transactions = Arrays.asList(
    new Transaction(Currency.EUR, 1500.0),
    new Transaction(Currency.USD, 2300.0),
    new Transaction(Currency.GBP, 9900.0),
    new Transaction(Currency.EUR, 1100.0),
    new Transaction(Currency.JPY, 7800.0),
    new Transaction(Currency.CHF, 6700.0),
    new Transaction(Currency.EUR, 5600.0),
    new Transaction(Currency.USD, 4500.0),
    new Transaction(Currency.CHF, 3400.0),
    new Transaction(Currency.GBP, 3200.0),
    new Transaction(Currency.USD, 4600.0),
    new Transaction(Currency.JPY, 5700.0),
    new Transaction(Currency.EUR, 6800.0)
  );

  public static void main(String... args) {
    groupImperatively();
    groupFunctionally();
  }

  // 통화별로 트랜잭션을 그룹화한 코드(명령형 버전)
  private static void groupImperatively() {
    // 그룹화한 트랜잭션을 저장할 맵을 생성
    Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();

    for (Transaction transaction : transactions) {
      // 트랜잭션의 통화를 추출한다
      Currency currency = transaction.getCurrency();
      List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
      if (transactionsForCurrency == null) {
        transactionsForCurrency = new ArrayList<>();
        transactionsByCurrencies.put(currency, transactionsForCurrency);
      }
      transactionsForCurrency.add(transaction);
    }
    System.out.println(transactionsByCurrencies);
  }

  private static void groupFunctionally() {
    Map<Currency, List<Transaction>> transactionsByCurrencies = transactions.stream()
            .collect(Collectors.groupingBy(Transaction::getCurrency));
    System.out.println(transactionsByCurrencies);
  }

  public static class Transaction {

    private final Currency currency;
    private final double value;

    public Transaction(Currency currency, double value) {
      this.currency = currency;
      this.value = value;
    }

    public Currency getCurrency() {
      return currency;
    }

    public double getValue() {
      return value;
    }

    @Override
    public String toString() {
      return currency + " " + value;
    }

  }

  public enum Currency {
    EUR, USD, JPY, GBP, CHF
  }

}
