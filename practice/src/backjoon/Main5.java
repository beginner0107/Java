package backjoon;

import java.io.*;

import static java.lang.System.lineSeparator;

public class Main5 {

    static StringBuilder sb;
    static BufferedWriter bw;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        sb.append((int)Math.pow(2, n) -1).append(lineSeparator());
        hanoiRecursive(n, 1, 2, 3);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    /**
     * @param n : 원판의 개수
     * @param start : 출발지
     * @param mid : 옮기기 위해 이동해야 하는 장소
     * @param to : 목적지
     */
    private static void hanoiRecursive(int n, int start, int mid, int to) {
        if (n == 1) {
            sb.append(start).append(" ").append(to).append(lineSeparator());
            return;
        }

        hanoiRecursive(n - 1, start, to, mid);
        sb.append(start).append(" ").append(to).append(lineSeparator());
        hanoiRecursive(n - 1, mid, start, to);
    }
}
