package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@FunctionalInterface
interface TriConsumer<T, U, V> {
    void accept(T t, U u, V v);
}

public class Test {
    public static StringTokenizer st;
    public static BufferedReader br;
    public static String SPACE = " ";
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        TriConsumer<Long, Long, Long> num = (a, b, c) -> {
            System.out.println(a + b + c);
        };
        st = new StringTokenizer(br.readLine(), " ");
        num.accept(parseLong(st.nextToken()), parseLong(st.nextToken()), parseLong(st.nextToken()));
        br.close();
    }

    private static long parseLong(String s) {
        return Long.parseLong(s);
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }
}
