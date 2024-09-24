package backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Default {
    public static StringTokenizer st;
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static String SPACE = " ";
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), SPACE);
        sb = new StringBuilder();
    }
}
