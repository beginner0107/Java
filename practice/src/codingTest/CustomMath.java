package codingTest;

import java.util.*;

import static java.lang.Math.sqrt;

public class CustomMath {

    /**
     * 나머지 연산 예시
     */
    public void remainingOperations() {
        int a = 24;
        int b = 15;
        int c = 7;

        System.out.println((a + b) % c + " " + (a % c + b % c) % c); // 합 분해
        System.out.println((a - b) % c + " " + (a % c - b % c) % c); // 뺄셈 분해
        System.out.println((a * b) % c + " " + ((a % c) * (b % c)) % c); // 곱 분해
    }

    /**
     * union
     * Intersection
     * Difference
     */
    public void setOperations() {
        // 집합 A와 B 정의
        Set<Integer> A = new HashSet<>(); // 1, 2, 3, 4, 5
        Set<Integer> B = new HashSet<>(); // 4, 5, 6, 7, 8

        for (int i = 1; i <= 8; i++) {
            if (i <= 5) A.add(i);
            if (i >= 4) B.add(i);
        }

        // union
        Set<Integer> union = new HashSet<>(A);
        union.addAll(B);
        System.out.println("Union: " + union);

        // intersection
        Set<Integer> intersection = new HashSet<>(A);
        intersection.retainAll(B);
        System.out.println("Intersection: " + intersection);

        // difference
        Set<Integer> difference = new HashSet<>(A);
        difference.removeAll(B);
        System.out.println("A - B: " + difference);
    }

    /**
     * 약수 구하기
     */
    public List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                divisors.add(n / i);
            }
        }
        Collections.sort(divisors);
        return divisors;
    }

    /**
     * 소수 판별하기
     */
    public boolean isPrime(int number) {
        return (getDivisors(number)).size() == 2;
    }

    /**
     * 최대 공약수
     */
    public int getGcd(int a, int b) {
        List<Integer> listA = getDivisors(a);
        List<Integer> listB = getDivisors(b);
        listA.retainAll(listB);
        return listA.stream()
                    .max(Integer::compare)
                    .orElse(-1);
    }

    /**
     * 최소 공배수
     * a * b = 최대공약수 * 최소공배수
     */
    public int getLcm(int a, int b) {
        return (a * b / getGcd(a, b));
    }

    /**
     * 소인수분해 알고리즘
     * 소인수분해는 어떤 수 n을 소수(prime number)의 곱으로만 나타내는 것을 의미
     */
    public List<Integer> getPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while(n % i == 0) {
                primes.add(i);
                n /= i;
            }
        }
        return primes;
    }

    /**
     * 에라토스테네스 체
     */
    public boolean isPrimeEratosthenes(int n) {
        boolean[] isPrimes = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (isPrimes[i]) continue;
            for (int j = i * 2; j <= n; j+=i) {
                isPrimes[j] = true; // 소수가 아닌 값들 체크
            }
        }
        return !isPrimes[n];
    }

    /**
     * 유클리드 알고리즘
     * 최대공약수를 빠르게 구하는 알고리즘
     */
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}