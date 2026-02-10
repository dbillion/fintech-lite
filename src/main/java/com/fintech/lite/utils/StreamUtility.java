package com.fintech.lite.utils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamUtility {

    public record Employee(String name, String dept, double salary) {}

    /** 27. Group by Department */
    public static Map<String, List<Employee>> groupByDept(List<Employee> emps) {
        return emps.stream().collect(Collectors.groupingBy(Employee::dept));
    }

    /** 28. Highest Salary per Department */
    public static Map<String, Optional<Employee>> highestByDept(List<Employee> emps) {
        return emps.stream()
                .collect(Collectors.groupingBy(Employee::dept,
                        Collectors.maxBy(Comparator.comparing(Employee::salary))));
    }

    /** 29. Sum of salaries */
    public static double totalSalary(List<Employee> emps) {
        return emps.stream().mapToDouble(Employee::salary).sum();
    }

    /** 30. Second Highest Number */
    public static Optional<Integer> secondHighest(List<Integer> nums) {
        return nums.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
    }

    /** 21. Frequency using Streams */
    public static <T> Map<T, Long> frequency(List<T> list) {
        return list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /** 22. Find duplicates using Streams */
    public static <T> Set<T> findDuplicates(List<T> list) {
        Set<T> seen = new HashSet<>();
        return list.stream().filter(n -> !seen.add(n)).collect(Collectors.toSet());
    }
}
