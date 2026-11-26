package SortingAlgorithms;

import ComparatorInterface.Student;
import java.util.Arrays;
import java.util.Comparator;

public class GenericSort {

    public static <E extends Comparable<E>> void insertionSort(E[] list) {
        for (int i = 1; i < list.length; i++) {
            E current = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k].compareTo(current) > 0; k--) {
                list[k + 1] = list[k];
            }
            list[k + 1] = current;
        }
    }

    public static <E> void bubleSort(E[] list, Comparator<? super E> comparator) {
        int n = list.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (comparator.compare(list[j - 1], list[j]) > 0) {
                    E temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Insertion Sort");

        Integer[] nums = {64, 34, 25, 1, 22, 11, 2};
        System.out.println("Original Integers: " + Arrays.toString(nums));
        insertionSort(nums);
        System.out.println("Sorted Integers:   " + Arrays.toString(nums));

        String[] names = {"Charlie", "Bob", "Eve", "Alice", "Diana"};
        System.out.println("\nOriginal Strings: " + Arrays.toString(names));
        insertionSort(names);
        System.out.println("Sorted Strings:   " + Arrays.toString(names));

        Double[] gpas = {3.2, 3.8, 2.9, 3.9, 3.5};
        System.out.println("\nOriginal Doubles: " + Arrays.toString(gpas));
        insertionSort(gpas);
        System.out.println("Sorted Doubles:   " + Arrays.toString(gpas));

        System.out.println("\n Bubble Sort");

        Integer[] nums2 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original Integers:      " + Arrays.toString(nums2));
        bubleSort(nums2, Comparator.reverseOrder());
        System.out.println("Sorted descending:      " + Arrays.toString(nums2));

        String[] words = {"kiwi", "banana", "fig", "apple", "cherry"};
        System.out.println("\nOriginal Strings:       " + Arrays.toString(words));
        bubleSort(words, Comparator.comparingInt(String::length));
        System.out.println("Sorted by length:       " + Arrays.toString(words));

        Student[] students = {
            new Student(105, "Samar", 3.2, 20, "Computer Science"),
            new Student(102, "Talha", 3.8, 22, "Mathematics"),
            new Student(103, "Jake", 3.9, 19, "Computer Science"),
            new Student(101, "Leo", 3.5, 21, "Physics")
        };

        System.out.println("\nStudents sorted by name:");
        bubleSort(students, Comparator.comparing(Student::getName));
        Arrays.stream(students).forEach(System.out::println);

        System.out.println("\nStudents sorted by GPA (highest first):");
        bubleSort(students, Comparator.comparing(Student::getGpa).reversed());
        Arrays.stream(students).forEach(System.out::println);

        System.out.println("\nStudents sorted by ID:");
        bubleSort(students, Comparator.comparing(Student::getId));
        Arrays.stream(students).forEach(System.out::println);
    }
}
