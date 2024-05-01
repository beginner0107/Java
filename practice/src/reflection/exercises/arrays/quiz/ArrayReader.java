package reflection.exercises.arrays.quiz;

import java.lang.reflect.Array;

/**
 * 인덱스에 맞는 배열 값 가지고 오는 예제
 * 음수 인덱스인 경우 배열의 끝에서부터 카운트
 */
public class ArrayReader {

    public static void main(String[] args) {
        int[] input = new int[]{0, 10, 20, 30, 40};
        String[] names = new String[]{"John", "Michael", "Joe", "David"};
        ArrayReader reader = new ArrayReader();
        System.out.println(reader.getArrayElement(input, -31));
    }

    public Object getArrayElement(Object array, int index) {
        int length = Array.getLength(array);

        Object element;
        if (index < 0) {
            while (index < 0) {
                index = length + index;
            }
            element = Array.get(array, index);
        } else if (index >= length) {
            index %= length;
            element = Array.get(array, index);
        } else {
            element = Array.get(array, index);
        }

        return element;
    }
}
