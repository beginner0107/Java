package modern.chap05;

import org.json.JSONArray;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 예시: 중첩된 JSON 데이터 플래트닝
 * 시나리오: JSON 데이터에서 중첩된 배열 필드를 플래트닝하여 단일 리스트로 변환.
 */
public class StreamFlatten3 {
    public static void main(String[] args) {
        // JSON 데이터
        String jsonString = """
                [
                    {"id": 1, "tags": ["java", "stream"]},
                    {"id": 2, "tags": ["flatmap", "example"]},
                    {"id": 3, "tags": ["java", "code"]}
                ]
                """;

        // JSON 파싱
        JSONArray jsonArray = new JSONArray(jsonString);

        List<String> tags = jsonArray.toList().stream()
                .map(obj -> ((Map<?, ?>) obj).get("tags"))
                .flatMap(tagList -> ((List<String>) tagList).stream())
                .distinct()
                .toList();

        System.out.println(tags);
    }
}
