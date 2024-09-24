package backjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    static char[][] canvas;

    static void drawStars(int n, int x, int y) {
        if (n == 1) {
            canvas[x][y] = '*';
            return;
        }

        int newSize = n / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    for (int a = 0; a < newSize; a++) {
                        for (int b = 0; b < newSize; b++) {
                            canvas[x + a + (newSize * i)][y + b + (newSize * j)] = ' ';
                        }
                    }
                } else {
                    drawStars(newSize, x + (newSize * i), y + (newSize * j));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        canvas = new char[N][N];

        // 캔버스를 별로 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                canvas[i][j] = '*';
            }
        }

        // 별 패턴 그리기
        drawStars(N, 0, 0);

        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(canvas[i]);
            bw.write('\n');
        }
        bw.flush();
        bw.close();
    }
}
