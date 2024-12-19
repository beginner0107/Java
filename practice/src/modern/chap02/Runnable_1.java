package modern.chap02;

public class Runnable_1 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        });
        t.run();

        // 자바 8부터 지원하는 람다 표현식
        Thread t2 = new Thread(() -> System.out.println("Hello World"));
        t2.run();
    }
}
