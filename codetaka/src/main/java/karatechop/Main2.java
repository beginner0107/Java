package karatechop;

public class Main2 {
    
    // 방법 2 : 반복문
    public static int binarySearch(int[] array, int target) {
        if (array.length == 0) return -1;
        int answer = 0;

        int lt = 0;
        int rt = array.length;

        int mid;
        while (lt <= rt && lt < array.length && rt >= 0) {
            mid = (lt + rt) / 2;
            if (array[mid] == target) {
                answer = mid;
                break;
            }
            if (array[mid] < target) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        if (lt > rt || lt >= array.length || rt < 0) {
            return -1;
        }
        return answer;
    }
}
