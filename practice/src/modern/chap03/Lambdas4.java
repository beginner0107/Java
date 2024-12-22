package modern.chap03;

import java.security.PrivilegedAction;
import java.util.concurrent.Callable;

/**
 * 같은 람다, 다른 함수형 인터페이스
 */
public class Lambdas4 {
    public static void main(String[] args) {
        Callable<Integer> c = () -> 42;
        PrivilegedAction<Integer> p = () -> 42;
    }
}
