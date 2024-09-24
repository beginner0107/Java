package syntax.training.ex04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static StringTokenizer st;
    public static int N;
    public static int W;
    public static BufferedReader br;
    public static int[][] matrix;
    public static int answer;
    public static int[] a;
    public static int[] b;
    public static int[] c;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); // (구역의 개수 / 2)
            W = Integer.parseInt(st.nextToken()); // 특수 소대원의 수
            answer = Integer.MAX_VALUE;

            // 시간 배열
            matrix = new int[2][N];
            IntStream.range(0, 2).forEach(Main::fillArray);

            // a, b, c 배열
            a = new int[N];
            b = new int[N];
            c = new int[N + 1];

            a[0] = 1;
            b[0] = 1;
            c[0] = 0;

            solve(0);

            answer = Math.min(answer, c[N]);

            if (N > 1) {
                if (matrix[0][0] + matrix[0][N - 1] <= W && matrix[1][0] + matrix[1][N - 1] <= W) {
                    a[1] = 1;
                    b[1] = 1;
                    c[1] = 0;
                    solve(1);
                    answer = Math.min(answer, c[N - 1] + 2);
                }

                if (matrix[0][0] + matrix[0][N - 1] <= W) {
                    a[1] = 2;
                    b[1] = matrix[1][0] + matrix[1][1] > W ? 2 : 1;
                    c[1] = 1;
                    solve(1);
                    answer = Math.min(answer, b[N - 1] + 1);
                }

                if (matrix[1][0] + matrix[1][N - 1] <= W) {
                    a[1] = matrix[0][0] + matrix[0][1] > W ? 2 : 1;
                    b[1] = 2;
                    c[1] = 1;
                    solve(1);
                    answer = Math.min(answer, a[N - 1] + 1);
                }
            }

            System.out.println(answer);
        }
    }

    /**
     * 최소 부대를 구하는 DP 구현
     * @param num
     */
    public static void solve(int num) {
        for (int i = num; i < N; i++) {
            c[i + 1] = Math.min(a[i] + 1, b[i] + 1);

            // c 하나 점령 했을 때
            if (matrix[0][i] + matrix[1][i] <= W) {
                c[i + 1] = Math.min(c[i + 1], c[i] + 1);
            }

            // 특이 케이스
            if (i > 0 && matrix[0][i] + matrix[0][i - 1] <= W && matrix[1][i] + matrix[1][i - 1] <= W) {
                c[i + 1] = Math.min(c[i + 1], c[i - 1] + 2);
            }

            if (i < N - 1) {
                a[i + 1] = c[i + 1] + 1;
                b[i + 1] = c[i + 1] + 1;

                if (matrix[0][i] + matrix[0][i + 1] <= W) {
                    a[i + 1] = Math.min(a[i + 1], b[i] + 1);
                }
                if (matrix[1][i] + matrix[1][i + 1] <= W) {
                    b[i + 1] = Math.min(b[i + 1], a[i] + 1);
                }
            }
        }
    }

    private static void fillArray(int x) {
        try {
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                matrix[x][i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
