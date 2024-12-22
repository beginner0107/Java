package modern.chap03;

import java.util.function.Consumer;

/**
 * 다음 코드를 컴파일할 수 없는 이유는?
 * Object o = () -> {System.out.println("Tricky example");};
 *
 * Object 는 함수형 인터페이스가 아니기 때문
 */
public class Quiz_3_5 {
    public static void main(String[] args) {
        Runnable o = (Runnable) () -> {System.out.println("Tricky example");};
//        Object o = (Runnable) () -> {System.out.println("Tricky example");};
        o.run();

        Object o2 = (Consumer) (s) -> System.out.println(s);
        Consumer<String> c2 = (Consumer<String>) o2;
        c2.accept("테스트");

//        execute(() -> {}); // 어떤 함수식인지 모름
        execute((Action) () -> {}); // 명시적으로 캐스트
        execute((Runnable) () -> {});
    }

    public static void execute(Runnable runnable) {
        runnable.run();
    }

    public static void execute(Action action) {
        action.act();
    }

    @FunctionalInterface
    interface Action {
        void act();
    }
}
