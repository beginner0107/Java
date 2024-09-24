package syntax.training.ex04;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    public static BufferedReader br;
    public static StringTokenizer st;
    public static int N;
    public static int K;
    public static int time[];
    public static int W;
    public static int degree[];
    public static List<ArrayList<Integer>> list;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            time = new int[N + 1]; // 건물 건축 시간
            degree = new int[N + 1]; // 건물 선수 조건이 있는 것을 확인하는 배열
            list = new ArrayList<>(); // 건축 순서

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i <= N; i++) {
                if (i == 0) {
                    list.add(new ArrayList<>());
                    continue;
                }
                time[i] = Integer.parseInt(st.nextToken());
                list.add(new ArrayList<>());
            }

            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                list.get(X).add(Y);

                degree[Y]++;
            }

            W = Integer.parseInt(br.readLine());

            solve(W);
        }
        br.close();
    }

    private static void solve(int W) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            result[i] = time[i];

            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer prev = queue.poll();

            for (int next : list.get(prev)) {
                result[next] = Math.max(result[next], result[prev] + time[next]);
                degree[next]--;
                if (degree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        System.out.println(result[W]);
    }
}
