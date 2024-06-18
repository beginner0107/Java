package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br;
    //public static StringTokenizer st;
    public static final String SPACES = " ";
    public static StringBuilder sb;
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int t = getNumber();
        while(t -- > 0) {
            st = new StringTokenizer(br.readLine(), SPACES);
            int x1 = Integer.parseInt(st.nextToken()); // 출발점
            int y1 = Integer.parseInt(st.nextToken()); // 출발점
            int x2 = Integer.parseInt(st.nextToken()); // 도착점
            int y2 = Integer.parseInt(st.nextToken()); // 도착점

            int n =  Integer.parseInt(br.readLine());
            int[][]planets = new int[n][3];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), SPACES);
                planets[i][0] = Integer.parseInt(st.nextToken()); // 중심 x 좌표
                planets[i][1] = Integer.parseInt(st.nextToken()); // 중심 y 좌표
                planets[i][2] = Integer.parseInt(st.nextToken()); // 반지름
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                boolean startInside = isInside(x1, y1, planets[i]);
                boolean endInside = isInside(x2, y2, planets[i]);

                if (startInside != endInside) {
                    count++;
                }
            }
            System.out.println(count);
        }
        br.close();
    }

    private static boolean isInside(int x, int y, int[] planet) {
        int cx = planet[0];
        int cy = planet[1];
        int r = planet[2];

        int dx = x - cx;
        int dy = y - cy;
        int distanceSquared = dx * dx + dy * dy;

        return distanceSquared < r * r;
    }

    private static int getNumber() throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
