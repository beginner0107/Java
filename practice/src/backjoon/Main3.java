package backjoon;

import java.io.*;
import java.util.*;

public class Main3 {
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        int[] sortedList = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            list[i] = number;
            sortedList[i] = number;
        }

        // Merge sort 수행
        mergeSort(sortedList, 0, sortedList.length - 1);

        // 중복 제거 및 인덱스 맵핑
        Map<Integer, Integer> indexMap = new HashMap<>();
        int index = 0;
        for (int number : sortedList) {
            if (!indexMap.containsKey(number)) {
                indexMap.put(number, index++);
            }
        }

        // 결과 빌더
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(indexMap.get(list[i])).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        System.arraycopy(array, left, leftArray, 0, leftSize);
        System.arraycopy(array, mid + 1, rightArray, 0, rightSize);

        int leftPointer = 0, rightPointer = 0, k = left;

        while (leftPointer < leftSize && rightPointer < rightSize) {
            if (leftArray[leftPointer] <= rightArray[rightPointer]) {
                array[k++] = leftArray[leftPointer++];
            } else {
                array[k++] = rightArray[rightPointer++];
            }
        }

        while (leftPointer < leftSize) {
            array[k++] = leftArray[leftPointer++];
        }

        while (rightPointer < rightSize) {
            array[k++] = rightArray[rightPointer++];
        }
    }
}
