package com.fintech.lite.utils;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtility {

    /** 1. Reverse String */
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    /** 2. Palindrome Check */
    public static boolean isPalindrome(String s) {
        if (s == null) return false;
        int i = 0, j = s.length() - 1;
        while (i < j) if (s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }

    /** 3. First Non-Repeated Character */
    public static Optional<Character> firstNonRepeated(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
    }

    /** 4. First Repeated Character */
    public static Optional<Character> firstRepeated(String s) {
        Set<Character> seen = new HashSet<>();
        return s.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !seen.add(c))
                .findFirst();
    }

    /** 5. Character Frequency */
    public static Map<Character, Long> frequency(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /** 6. Anagram Check (Optimal O(n)) */
    public static boolean isAnagram(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) return false;
        int[] count = new int[256]; // Extended ASCII
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i)]++;
            count[b.charAt(i)]--;
        }
        for (int v : count) if (v != 0) return false;
        return true;
    }

    /** 7. Remove Duplicates */
    public static String removeDuplicates(String s) {
        return s.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    /** 8. Longest Substring Without Repeating (Sliding Window) */
    public static int longestUniqueSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) left = Math.max(left, map.get(c) + 1);
            map.put(c, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    /** 9. Contains Only Digits */
    public static boolean onlyDigits(String s) {
        return s != null && !s.isEmpty() && s.chars().allMatch(Character::isDigit);
    }

    /** 10. Capitalize Words */
    public static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return Pattern.compile("\\b(\\w)")
                .matcher(s)
                .replaceAll(m -> m.group().toUpperCase());
    }
}
