package com.fintech.lite.interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CoreJavaSolutions {

    // 1. Reverse String
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // 2. Palindrome
    public static boolean isPalindrome(String s) {
        return s.contentEquals(new StringBuilder(s).reverse());
    }

    // 3. First non-repeated
    public static Optional<Character> firstNonRepeated(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
    }

    // 11. Second Largest
    public static OptionalInt secondLargest(int[] arr) {
        return Arrays.stream(arr).distinct().sorted().skip(Math.max(0, Arrays.stream(arr).distinct().count() - 2)).findFirst();
    }
    
    // Better Second Largest for testing
    public static int getSecondLargest(int[] arr) {
        return Arrays.stream(arr).boxed()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .orElseThrow();
    }

    // 21. Frequency using Streams
    public static <T> Map<T, Long> elementFrequency(List<T> list) {
        return list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // 27. Group employees (Using record from doc)
    public record Employee(String name, String dept, double salary) {}
    
    public static Map<String, List<Employee>> groupByDept(List<Employee> emps) {
        return emps.stream().collect(Collectors.groupingBy(Employee::dept));
    }
}
