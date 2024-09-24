package backjoon;

import java.io.*;
import java.util.*;

import static java.lang.System.lineSeparator;

// 재귀 연습
public class Main6 {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringTokenizer st;
    public static StringBuilder answer;
    public static int N;
    public static int M;
    public static int[] arrList;
    public static boolean[] isVisited;
    public static Set<String> set;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        set = new LinkedHashSet<>();
        answer = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];
        arrList = new int[N];
        isVisited = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arrList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrList);

        recursive(0, arr);

        for (String s : set) {
            answer.append(s);
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void recursive(int number, int[] arr) {
        if (number == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append(lineSeparator());
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[number] = arrList[i];
            recursive(number + 1, arr);
        }
    }
}
