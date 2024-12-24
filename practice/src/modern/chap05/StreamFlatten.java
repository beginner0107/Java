package modern.chap05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 스트림 평면화
 * 
 * ["Hello", "World"] 리스트가 있다면 이를 ["H", "e", "l", "o", "W", "r", "d"] 리스트를 반환하자
 */
public class StreamFlatten {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World");
        List<String[]> wordsArray = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .toList();
        for (String[] word : wordsArray) {
            for (String w : word) System.out.print(w + " ");
            System.out.println();
        } // 원하는 결과가 아님, String[] -> X

        // 문자열을 받아 스트림을 만드는 방법
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        
        // flatMap을 사용하여 문제 해결
        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split("")) // 각 단어를 개별 문자를 포함하는 배열로 변환
                .flatMap(Arrays::stream) // 생성된 스트림을 하나의 스트림으로 평면화
                .distinct()
                .toList();
    }
}
