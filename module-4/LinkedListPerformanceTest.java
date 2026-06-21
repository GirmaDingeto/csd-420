
package com.girma.linkedlistperformancetest;

/**
 * Girma Dingeto
 * CSD420 Module 4.2 Assignment
 * Date 06/21/2026
 */
import java.util.LinkedList;
import java.util.ListIterator;
/**
 * Program Performance Test: LinkedList Traversal
 * Explanation of Results
 * ------------------------
 * 1.Iterator Approach:
 *  -The iterator achieves O(N) linear time complexity
 *  -It maintains an internal pointer to the current node.
 *  Moving to the next element takes O(1) constant time.
 *  -Because of this, it scales smoothly and finishes almost instantly for
 *  both 50,000 and 500,000 elements.
 *
 * 2.get(index) Approach:
 *  -The get(index) method on a LinkedList exhibits O(N^2) quadratic time
 *  complexity when used in the loop.
 *  -LinkedList does not support random access. Every single get(index) call must
 *  start from the head (or tail) of the list and traverse step-by-step to that index.
 *  -For 50,000 elements, this requires roughly 1.25 billion operations, causing
 *  a noticeable delay.
 *  -For 500,000 elements, the workload multiplies by 100*(around 1.25 billion operations).
 *  This will cause the program to hang for a significant period or freeze entirely.
 */
public class LinkedListPerformanceTest {
    public static void main(String[] args) {
        // Test with 50,000 integers
        runPerformanceTest(50000);

        System.out.println("\n----------------------------");

        // Test with 500,000
        runPerformanceTest(500000);
    }
    /**
     * Measures and displays traversal times using an Iterator vs get(index)
     * @param size Number of integers to store and traverse
     */
    public static void runPerformanceTest(int size) {
        System.out.println("Initializing LinkedList with " + size + "integers...");
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0; i < size; i++) {
            list.add(i);
        }
        //---Test 1: Iterator Traversal----
        System.out.println("Starting Iterator traversal test...");
        long startTimeIterator = System.currentTimeMillis();

        ListIterator<Integer> iterator = list.listIterator();
        long sumIterator = 0;
        while (iterator.hasNext()) {
            sumIterator += iterator.next();
        }
        long endTimeIterator = System.currentTimeMillis();
        long durationIterator = endTimeIterator - startTimeIterator;
        System.out.println("Iterator time:" + durationIterator + "ms (Checksum:" + sumIterator +")");

        //---Test 2: get(index) Traversal---
        System.out.println("Starting get(index) traversal test...(This may take a while for large sizes)");
        long startTimeGet = System.currentTimeMillis();

        long sumGet = 0;
        for (int i = 0; i < size; i++) {
            sumGet += list.get(i);

           
        }
        long endTimeGet = System.currentTimeMillis();
        long durationGet = endTimeGet - startTimeGet;
        System.out.println("get(index) time: " +durationGet + "ms (Checksum:" + sumGet + ")");

    }
}