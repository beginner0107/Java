package modern.chap03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 살짝 이해하기 어려웠는데
 * 동작이란?
 * 상황에 맞게 바뀔 수 있음. 다만 타입은 정해져 있음
 * 필요한 매개변수들(인스턴스)는 외부에서 만들어서 사용할 수 있음 (안 사용해도 됨)
 * 
 * 결론은 인터페이스를 선언하고 구현체를 다양하게 하는 기법
 */
public class AroundPattern {
    public static void main(String[] args) throws IOException {
        // 1단계 동작 파라미터화
        // 2단계 함수형 인터페이스를 이용해서 동작 전달
        // 3단계 동작 실행
        // 4단계 람다 전달
        String oneLine = processFile(BufferedReader::readLine);
        String twoLines = processFile(br -> br.readLine() + br.readLine());
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader br) throws IOException;
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }
}
