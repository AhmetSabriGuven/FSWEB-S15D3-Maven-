package org.example;

import org.example.entity.Employee;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));

        System.out.println(findDuplicates(employees));
        System.out.println(findUniques(employees));
        System.out.println(removeDuplicates(employees));
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Map<Employee, Integer> counts = countEmployees(employees);
        List<Employee> duplicates = new LinkedList<>();

        for (Map.Entry<Employee, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniques = new HashMap<>();

        for (Employee employee : employees) {
            if (employee != null) {
                uniques.putIfAbsent(employee.getId(), employee);
            }
        }

        return uniques;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Employee, Integer> counts = countEmployees(employees);
        List<Employee> onlySingles = new LinkedList<>();

        for (Map.Entry<Employee, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                onlySingles.add(entry.getKey());
            }
        }

        return onlySingles;
    }

    private static Map<Employee, Integer> countEmployees(List<Employee> employees) {
        Map<Employee, Integer> counts = new LinkedHashMap<>();

        for (Employee employee : employees) {
            if (employee != null) {
                counts.put(employee, counts.getOrDefault(employee, 0) + 1);
            }
        }

        return counts;
    }
}
