package modern.chap05;

import java.util.Arrays;
import java.util.List;

import static modern.chap05.Dish.menu;

/**
 * 스트림 매핑: 특정 객체에서 특정 데이터를 선택하는 작업
 */
public class StreamMap {
    public static void main(String[] args) {
        // 이 과정은 변환(transforming), 매핑(mapping) 에 더 가까움
        // '새로운 버전을 만든다'
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .toList();
        
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .toList();
    }
}
