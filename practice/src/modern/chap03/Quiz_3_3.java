package modern.chap03;

import java.util.concurrent.Callable;

public class Quiz_3_3 {
    public static void main(String[] args) {
        Quiz_3_3 quiz33 = new Quiz_3_3();
        quiz33.execute(() -> {}); // 익명 함수의 시그니처 Runnable 과 일치

//        Predicate<Apple> p = a -> a.getWeight();  틀린 예시
    }
    
    public Callable<String> fetch() { // String 반환하는 Callable 함수
        return () -> "Tricky example ;-)";
    }

    public void execute(Runnable r) {
        r.run();
    }
}

