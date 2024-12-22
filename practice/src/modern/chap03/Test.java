package modern.chap03;

public class Test {
    public static void main(String[] args) {
        int variable = 1; // 이렇게 복사됨

        // Heap 영역에 Runnable 객체의 인스턴스가 생성되고
        // 여기서 외부에 있는 변수에 접근하려고 할 때, variable의 복사본을 Heap 영역에 복사함
        // int variable 앞에 final이 붙음, 이 때 인스턴스 변수가 되는 셈
        Runnable r = () -> { // 람다 캡처링
            System.out.println(variable);
        };
    }
}
