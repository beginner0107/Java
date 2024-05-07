package karatechop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static karatechop.Main.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("binarySearch")
    void testBinarySearch() {
        assertEquals(-1, binarySearch(new int[]{}, 3, 0, 0));
        assertEquals(-1, binarySearch(new int[]{1}, 3, 0, 1));
        assertEquals(0, binarySearch(new int[]{1}, 1, 0, 1));

        assertEquals(0, binarySearch(new int[]{1, 3, 5}, 1, 0, 3));
        assertEquals(1, binarySearch(new int[]{1, 3, 5}, 3, 0, 3));
        assertEquals(2, binarySearch(new int[]{1, 3, 5}, 5, 0, 3));
        assertEquals(-1, binarySearch(new int[]{1, 3, 5}, 0, 0, 3));
        assertEquals(-1, binarySearch(new int[]{1, 3, 5}, 2, 0, 3));
        assertEquals(-1, binarySearch(new int[]{1, 3, 5}, 4, 0, 3));
        assertEquals(-1, binarySearch(new int[]{1, 3, 5}, 6, 0, 3));

        assertEquals(0, binarySearch(new int[]{1, 3, 5, 7}, 1, 0, 4));
        assertEquals(1, binarySearch(new int[]{1, 3, 5, 7}, 3, 0, 4));
        assertEquals(2, binarySearch(new int[]{1, 3, 5, 7}, 5, 0, 4));
        assertEquals(3, binarySearch(new int[]{1, 3, 5, 7}, 7, 0, 4));
        assertEquals(-1, binarySearch(new int[]{1, 3, 5, 7}, 0, 0, 4));
        assertEquals(-1, binarySearch(new int[]{1, 3, 5, 7}, 2, 0, 4));
        assertEquals(-1, binarySearch(new int[]{1, 3, 5, 7}, 4, 0, 4));
        assertEquals(-1, binarySearch(new int[]{1, 3, 5, 7}, 6, 0, 4));
        assertEquals(-1, binarySearch(new int[]{1, 3, 5, 7}, 8, 0, 4));
    }
}
