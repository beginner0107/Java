package karatechop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static karatechop.Main2.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest2 {

    @Test
    @DisplayName("binarySearch2")
    void testBinarySearch2() {
        assertEquals(-1, binarySearch(new int[]{}, 3));
        assertEquals(-1, binarySearch(new int[]{1}, 3));
        assertEquals(0, binarySearch(new int[]{1}, 1));

        assertEquals(0, binarySearch(new int[]{1, 3, 5}, 1));
        assertEquals(1, binarySearch(new int[]{1, 3, 5}, 3));
        assertEquals(2, binarySearch(new int[]{1, 3, 5}, 5));
        assertEquals(-1, binarySearch(new int[]{1, 3, 5}, 0));
        assertEquals(-1, binarySearch(new int[]{1, 3, 5}, 2));
        assertEquals(-1, binarySearch(new int[]{1, 3, 5}, 4));
        assertEquals(-1, binarySearch(new int[]{1, 3, 5}, 6));

        assertEquals(0, binarySearch(new int[]{1, 3, 5, 7}, 1));
        assertEquals(1, binarySearch(new int[]{1, 3, 5, 7}, 3));
        assertEquals(2, binarySearch(new int[]{1, 3, 5, 7}, 5));
        assertEquals(3, binarySearch(new int[]{1, 3, 5, 7}, 7));
        assertEquals(-1, binarySearch(new int[]{1, 3, 5, 7}, 0));
        assertEquals(-1, binarySearch(new int[]{1, 3, 5, 7}, 2));
        assertEquals(-1, binarySearch(new int[]{1, 3, 5, 7}, 4));
        assertEquals(-1, binarySearch(new int[]{1, 3, 5, 7}, 6));
        assertEquals(-1, binarySearch(new int[]{1, 3, 5, 7}, 8));
    }
}
