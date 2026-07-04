/**
 * This program uses two following generic methods: 
 * The first method sorts the elements using the Comparable interface, 
 * and the second uses the Comparator interface.
 * Write test code that ensures your code functions correctly.
 */

/**
 *CSD 420 Module 6.2 Assignment 07/05/2026
 * Girma Dingeto
 */

import java.util.Arrays;
import java.util.Comparator;

/*
 * A utility class providing generic bubble sort implementations.
 * Includes methods for sorting via the Comparable interface and the Comparator interface
 */
public class GenericBubbleSort {

    /**
     * Sorts an array of elements that implement the Comparable interface.
     * Elements are sorted into ascending order based on their natural ordering
     * @param <E>  the generic type of elements in the array, must extend Comparable
     * @param list the array of elements to be sorted
     */
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean needNextPass = true;

        // Outer loop controls the number of passes through the array
        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;

            // Inner loop performs adjacent comparisons and swaps
            for (int i = 0; i < list.length - k; i++) {
                if (list[i].compareTo(list[i + 1]) > 0) {
                    // Swap list[i] with list[i + 1]
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true;
                }
            }
        }
    }

    /**
     * Sorts an array of elements using a specific Comparator.
     * Elements are sorted based on the ordering defined by the comparator.
     *
     * @param <E>        the generic type of elements in the array
     * @param list       the array of elements to be sorted
     * @param comparator the comparator that determines the order of elements
     */
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean needNextPass = true;

        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;

            for (int i = 0; i < list.length - k; i++) {
                if (comparator.compare(list[i], list[i + 1]) > 0) {
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true;
                }
            }
        }
    }

    /**
     * Test code driver to ensure the bubble sort methods function properly
     */
    public static void main(String[] args) {

        // --- Test 1: Comparable Interface with Integers ---
        System.out.println("--- Test 1: Comparable (Integer Natural Order) ---");
        Integer[] intList = {5, 3, 1, -2, 5, 4, 20, -25, 0, 6, -3};
        System.out.println("Original array: " + Arrays.toString(intList));

        bubbleSort(intList);
        System.out.println("Sorted array: " + Arrays.toString(intList));
        System.out.println();

        // --- Test 2: Comparable Interface with Strings ---
        System.out.println("--- Test 2: Comparable (String Alphabetical Order) ---");
        String[] stringList = {"Generous", "Hardware", "Fraction", "Highland", "Governor", "Server", "Firewall"};
        System.out.println("Original array: " + Arrays.toString(stringList));

        bubbleSort(stringList);
        System.out.println("Sorted array: " + Arrays.toString(stringList));
        System.out.println();

        // --- Test 3: Comparator Interface with Integers (Descending Order) ---
        System.out.println("--- Test 3: Comparator (Integer Descending Order) ---");
        Integer[] intListDesc = {5, 3, 7, -2, 5, 4, 20, -25, 0, 6, -3};
        System.out.println("Original array: " + Arrays.toString(intListDesc));

        bubbleSort(intListDesc, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1); // reverse order
            }
        });
        System.out.println("Sorted array: " + Arrays.toString(intListDesc));
        System.out.println();

        // --- Test 4: Comparator Interface with Strings (Length Order) ---
        System.out.println("--- Test 4: Comparator (String Length Order) ---");
        String[] stringListLen = {"Hippopotamus", "Kangaroo", "Tiger", "Dolphin", "Ostrich", "Puppy"};
        System.out.println("Original array: " + Arrays.toString(stringListLen));

        bubbleSort(stringListLen, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("Sorted array: " + Arrays.toString(stringListLen));
    }
}
