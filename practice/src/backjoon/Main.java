package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static StringTokenizer st;
    public static final String SPACES = " ";
    public static final int[] dy = {0, 0, -1, 1};
    public static final int[] dx = {1, -1, 0, 0};
    public static boolean[][] visited;
    public static int[][] place;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), SPACES);
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int answer = 0;

            place = new int[m][n];
            visited = new boolean[m][n];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), SPACES);
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                place[y][x] = 1;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (place[i][j] == 1 && !visited[i][j]) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(answer).append(System.lineSeparator());
        }
        System.out.println(sb);
        br.close();
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < place.length && nx >= 0 && nx < place[0].length){
                if (!visited[ny][nx] && place[ny][nx] == 1) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
