package modern.chap03;

/**
 * 지역변수와 람다 캡처링 (Lambda capturing)
 * 람다식은 인스턴스 변수, 지역 변수를 사용할 수 있음
 * 다만, 지역변수는 final이 붙은 것과 동일하게 작동
 */
public class CapturingLambda {
    public static void main(String[] args) {
        int portNumber = 32;
        Runnable r = () -> System.out.println(portNumber);
//        portNumber = 311338; // 에러!
    }
}
