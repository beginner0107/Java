package codingTest.recursive;

import java.util.Arrays;
import java.util.Scanner;

public class Recursive {

    /**
     * @description 1부터 N까지의 합을 재귀로 구하는 함수
     * @param n
     * @return totalSum
     */
    public int sumFromOneToN(int n) {
        // Base Case
        if (n == 1) return 1;

        // Recursive Case
        return n + sumFromOneToN(n - 1);
    }

    /**
     * @description 1부터 N까지의 합을 일반 함수로 구하는
     * @param n
     * @return totalSum
     */
    public int sumFromOneToNByFunction(int n) {
        return (1 + n) * n / 2;
    }

    /**
     * DP 활용해서 피보나치 푸는 풀이
     * @param n
     * @return 피보나치 값
     */
    public int fibonacci(int n) {
        int [] dp = new int[21];
        dp[0] = 0; dp[1] = 1; dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * fibo(x) : 피보나치의 x번째 수를 반환
     *
     * fibo(x) = fibo(x - 1) + fibo(x - 2)
     */
    public int fibo(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        return fibo(x - 1) + fibo(x - 2);
    }

    private int fiboMemorization(int n, int[] arr) {
        if (arr[n] != -1) {
            return arr[n];
        }
        arr[n] = fiboMemorization(n - 1, arr) + fiboMemorization(n - 2, arr);
        return arr[n];
    }

    public void fiboRun() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[22];
        Arrays.fill(arr, -1);
        arr[0] = 0; arr[1] = 1;
        System.out.println(fiboMemorization(n, arr));

        sc.close();
    }

    public static void main(String[] args) {
        Recursive recursive = new Recursive();
        recursive.fiboRun();
    }
}
