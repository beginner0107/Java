package modern.chap03;

/**
 * a의 저장 영역
 *
 * b의 저장 영역
 * c의 저장 영역
 * d의 저장 영역
 * testMethod 는 어디에 저장될까?
 */
public class Jvm {
    public static void main(String[] args) {
        System.out.println(Memory.b);
        // b 가 method area 에 저장이 됨 (정적 변수) - 인스턴스를 생성하지 않아도 사용 가능

        Memory memory = new Memory(); // heap 에 생성

        // c의 저장 영역 - Stack 영역에 값 적재
        
        // d의 저장 영역 - Stack 영역에 값 적재

        // testMethod - Method Area 영역에 적재
    }
}

class Memory {
    int a = 1;
    static final int b = 4;

    public void testMethod(int c) {
        int d = 4;
    }
}
