package modern.chap05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 숫자 리스트가 주어졌을 때 각 숫자의 제곱근으로 이루어진 리스트를 반환하시오
 * 예를들어 [1,2,3,4,5]가 주어지면 [1,4,9,16,25]를 반환해야 한다
 *
 * 두 개의 숫자 리스트가 있을 때 모든 숫자 쌍의 리스트를 반환하시오. 
 * 예를 들어 두 개의 리스트 [1, 2, 3], [3, 4]가 주어지면 [(1, 3), (1, 4), (2, 4), (3, 3), (3, 4)]
 * 를 반환해야 한다
 */
public class Quiz_5_2 {
    public static void main(String[] args) {
        quiz1();
        quiz2();
        System.out.println();
        quiz3();
    }

    /**
     * 숫자 리스트가 주어졌을 때 각 숫자의 제곱근으로 이루어진 리스트를 반환하시오
     * 예를들어 [1,2,3,4,5]가 주어지면 [1,4,9,16,25]를 반환해야 한다
     */
    public static void quiz1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> results = numbers.stream()
                .map(number -> number * number) // 기본 산술 연산
                .toList();
        System.out.println(results);
    }

    /**
     * 두 개의 숫자 리스트가 있을 때 모든 숫자 쌍의 리스트를 반환하시오.
     * 예를 들어 두 개의 리스트 [1, 2, 3], [3, 4]가 주어지면 [(1, 3), (1, 4), (2, 4), (3, 3), (3, 4)]
     * 를 반환해야 한다
     */
    public static void quiz2() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);
        // 스트림 사용하기 전 풀이
        List<Integer[]> answer1 = quiz2_1(list1, list2);
        for (Integer[] arr : answer1) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
        List<int[]> answer2 = quiz2_2(list1, list2);
        for (int[] arr : answer2) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static List<Integer[]> quiz2_1(List<Integer> list1, List<Integer> list2) {
        List<Integer[]> answer = new ArrayList<>();
        for (Integer v1 : list1) {
            for (Integer v2 : list2) {
                Integer[] arr = new Integer[2];
                arr[0] = v1;
                arr[1] = v2;
                answer.add(arr);
            }
        }
        return answer;
    }

    public static List<int[]> quiz2_2(List<Integer> list1, List<Integer> list2) {
        return list1.stream()
                .flatMap(i -> list2.stream()
                        .map(j -> new int[]{i, j}))
                .toList();
    }

    /**
     * 이전 예제에서 합이 3으로 나누어떨어지는 쌍만 반환하려면 어떻게 해야 할까?
     * 예를 들어 (2, 4), (3, 3)을 반환해야 한다
     */
    public static void quiz3() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);

        List<int[]> answer = list1.stream()
                .flatMap(i -> list2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .toList();
        for (int[] arr : answer) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
