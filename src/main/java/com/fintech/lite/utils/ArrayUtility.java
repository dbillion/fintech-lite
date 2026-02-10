package com.fintech.lite.utils;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayUtility {

    /** 11. Second Largest (Single Pass) */
    public static int secondLargest(int[] arr) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int n : arr) {
            if (n > first) {
                second = first;
                first = n;
            } else if (n > second && n != first) {
                second = n;
            }
        }
        return second;
    }

    /** 12. Missing Number 1..n (XOR approach) */
    public static int missingNumber(int[] arr, int n) {
        int xor = 0;
        for (int i = 1; i <= n; i++) xor ^= i;
        for (int num : arr) xor ^= num;
        return xor;
    }

    /** 13. Find Duplicates */
    public static List<Integer> findDuplicates(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        return Arrays.stream(arr)
                .filter(n -> !seen.add(n))
                .boxed()
                .distinct()
                .toList();
    }

    /** 14. QuickSort */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) swap(arr, ++i, j);
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /** 15. Pairs with Given Sum */
    public static List<int[]> findPairs(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        List<int[]> pairs = new ArrayList<>();
        for (int n : arr) {
            int complement = target - n;
            if (seen.contains(complement)) pairs.add(new int[]{complement, n});
            seen.add(n);
        }
        return pairs;
    }

    /** 16. Move Zeros to End (Two Pointer) */
    public static void moveZeros(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j++] = temp;
            }
        }
    }

    /** 17. Min/Max Single Iteration (Record Pattern) */
    public record MinMax(int min, int max) {}
    public static MinMax findMinMax(int[] arr) {
        if (arr.length == 0) return new MinMax(0, 0);
        int min = arr[0], max = arr[0];
        for (int n : arr) {
            if (n < min) min = n;
            if (n > max) max = n;
        }
        return new MinMax(min, max);
    }

    /** 18. Rotated Sorted Array Check */
    public static boolean isRotatedSorted(int[] arr) {
        int count = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[(i + 1) % n]) count++;
        }
        return count <= 1;
    }

    /** 19. Array Intersection */
    public static int[] intersection(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        for (int n : a) set.add(n);
        return Arrays.stream(b).filter(set::contains).distinct().toArray();
    }

    /** 20. Kth Largest (Heap) */
    public static int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int n : arr) {
            heap.offer(n);
            if (heap.size() > k) heap.poll();
        }
        return heap.peek();
    }
}
