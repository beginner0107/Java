package karatechop;

/**
 * 이진 탐색
 * 정렬된 값 배열에서 값의 위치를 찾는다.
 * 조사할 때마다 고려 중인 항목 수를 절반으로 줄여 효율성을 어느 정도 달성합니다.
 * nlogN
 *
 **/
public class Main {

    // 방법 1 : 재귀
    public static int binarySearch(int[] array, int target, int start, int end) {
        if (array.length == 0 || start >= end) return -1;

        int mid = (start + end) / 2;

        if (array[mid] == target) {
            return mid;
        }

        if (array[mid] > target) {
            return binarySearch(array, target, start, mid);
        } else if (array[mid] < target) {
            return binarySearch(array, target, mid + 1, end);
        }

        return -1;
    }

}
