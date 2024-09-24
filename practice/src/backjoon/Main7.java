package backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main7 {
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringBuilder sb;
    public static StringTokenizer st;
    public static int answer;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();

        // 퀸이 n개
        int n = Integer.parseInt(br.readLine());
        answer = 0;
        boolean[][] chess = new boolean[n][n];

        solve(0, n, chess);

        System.out.println(answer);
        bw.write(sb.toString());
        bw.flush();
    }

    private static void solve(int row, int n, boolean[][] chess) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isAvailable(chess, row, col)) {
                chess[row][col] = true; // 퀸을 놓는다.
                solve(row + 1, n, chess);
                chess[row][col] = false; // 백트래킹
            }
        }
    }

    private static boolean isAvailable(boolean[][] chess, int x, int y) {
        // 세로
        for (int i = 0; i < chess.length; i++) {
            if (chess[i][y]) {
                return false;
            }
        }
        // 가로
        for (int j = 0; j < chess[0].length; j++) {
            if (chess[x][j]) {
                return false;
            }
        }
        // 대각선
        // o o o
        // o x o
        // o o o
        // 대각선
        int startLeftCol = x;
        int startLeftRow = y;

        // 좌상-우하 대각선 체크
        while (startLeftCol >= 0 && startLeftRow >= 0) {
            if (chess[startLeftCol][startLeftRow]) {
                return false;
            }
            startLeftCol--;
            startLeftRow--;
        }

        // 우상-좌하 대각선 체크
        startLeftCol = x;
        startLeftRow = y;
        while (startLeftCol >= 0 && startLeftRow < chess[0].length) {
            if (chess[startLeftCol][startLeftRow]) {
                return false;
            }
            startLeftCol--;
            startLeftRow++;
        }



        return true;
    }
}

