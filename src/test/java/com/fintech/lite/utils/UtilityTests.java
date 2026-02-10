package com.fintech.lite.utils;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class UtilityTests {

    @Test
    void testStringReverse() {
        assertEquals("olleh", StringUtility.reverse("hello"));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(StringUtility.isPalindrome("madam"));
        assertFalse(StringUtility.isPalindrome("hello"));
    }

    @Test
    void testAnagram() {
        assertTrue(StringUtility.isAnagram("listen", "silent"));
        assertFalse(StringUtility.isAnagram("hello", "world"));
    }

    @Test
    void testSecondLargest() {
        int[] arr = {1, 5, 3, 9, 7};
        assertEquals(7, ArrayUtility.secondLargest(arr));
    }

    @Test
    void testMissingNumber() {
        int[] arr = {1, 2, 4, 5};
        assertEquals(3, ArrayUtility.missingNumber(arr, 5));
    }

    @Test
    void testStreamFrequency() {
        List<String> list = List.of("a", "b", "a", "c", "b", "a");
        Map<String, Long> freq = StreamUtility.frequency(list);
        assertEquals(3, freq.get("a"));
        assertEquals(2, freq.get("b"));
    }
}
