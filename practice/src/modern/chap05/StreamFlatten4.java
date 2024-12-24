package modern.chap05;

import java.util.Arrays;
import java.util.List;

/**
 * 로그 파일에서 에러 메시지 추출
 * 시나리오: 여러 로그 파일에서 "ERROR"로 시작하는 메시지를 추출하여 단일 리스트로 병합.
 */
public class StreamFlatten4 {
    public static void main(String[] args) {
        List<String> logs = List.of(
                "INFO: Application started",
                "ERROR: Null pointer exception",
                "INFO: Request received",
                "ERROR: Array index out of bounds"
        );
        
        List<String> errorMessages =
                logs.stream()
                    .filter(line -> line.startsWith("ERROR"))
                    .map(line -> line.split(":")[1].trim())
                    .toList();
        System.out.println(errorMessages);
    }
}
