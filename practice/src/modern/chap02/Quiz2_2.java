package modern.chap02;

/**
 * 코드의 장황함은 나쁜 특성
 * 장황한 코드는 구현하고 유지보수하는 데 시간이 오래 걸릴 뿐만 아니라
 * 읽는 즐거움을 빼앗는 요소
 * 
 * 한 눈에 이해할 수 있어야 좋은 코드
 * 익명 클래스로 인터페이스를 구현하는 여러 클래스를 선언하는 과정을 줄일 수 있지만 여전히 만족스럽지 않음
 */
public class Quiz2_2 {
    public final int value = 4;
    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;
            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value); // this 는 Runnable 을 참조
            }
        };
        r.run();
    }

    public static void main(String[] args) {
        Quiz2_2 quiz2_2 = new Quiz2_2();
        quiz2_2.doIt(); // 이 행의 출력 결과는?
        // 5가 나올 것 같음
    }
}
