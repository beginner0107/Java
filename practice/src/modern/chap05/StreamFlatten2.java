package modern.chap05;

import java.util.Arrays;
import java.util.List;

/**
 * 예시: 파일에서 단어 추출 및 병합
 * 시나리오: 여러 파일에서 텍스트를 읽고, 모든 단어를 단일 리스트로 추출하여 처리하려고 합니다.
 */
public class StreamFlatten2 {
    public static void main(String[] args) {
        List<String> fileContents = List.of(
                "Java is great",
                "Stream API is powerful",
                "FlatMap makes life easier"
        );

        List<String> words = fileContents.stream()
                .map(word -> word.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .toList();

        System.out.println(words);
    }
}
