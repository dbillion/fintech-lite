package com.fintech.lite.interview;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class CoreJavaSolutionsTest {

    @Test
    void testReverse() {
        assertEquals("atad", CoreJavaSolutions.reverse("data"));
    }

    @Test
    void testPalindrome() {
        assertTrue(CoreJavaSolutions.isPalindrome("racecar"));
        assertFalse(CoreJavaSolutions.isPalindrome("java"));
    }

    @Test
    void testFirstNonRepeated() {
        assertEquals('j', CoreJavaSolutions.firstNonRepeated("java").get());
    }

    @Test
    void testSecondLargest() {
        int[] nums = {10, 20, 4, 45, 99};
        assertEquals(45, CoreJavaSolutions.getSecondLargest(nums));
    }

    @Test
    void testElementFrequency() {
        List<String> items = List.of("apple", "apple", "banana");
        Map<String, Long> freq = CoreJavaSolutions.elementFrequency(items);
        assertEquals(2, freq.get("apple"));
        assertEquals(1, freq.get("banana"));
    }

    @Test
    void testGroupByDept() {
        var e1 = new CoreJavaSolutions.Employee("A", "IT", 1000);
        var e2 = new CoreJavaSolutions.Employee("B", "HR", 2000);
        var e3 = new CoreJavaSolutions.Employee("C", "IT", 3000);
        
        var grouped = CoreJavaSolutions.groupByDept(List.of(e1, e2, e3));
        assertEquals(2, grouped.get("IT").size());
        assertEquals(1, grouped.get("HR").size());
    }
}
