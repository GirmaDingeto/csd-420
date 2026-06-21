

package com.girma.distinctelements;
/**
 *Girma Dingeto
 *Program to generate a list of Random integers and remove duplicates
 * CSD 420 Module3.2 Assignment
 * Date: June 21,2026 
 */
import java.util.ArrayList;
import java.util.Random;

public class DistinctElements {
    /**
    * Remove duplicate Values from the provided ArrayList.
    * 
    * @param list The original ArrayList with possible duplicates
    * @param<E> The generic type of elements in the list
    * @return A new ArrayList containing only unique values
    */

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> newList = new ArrayList<>();
        for (E element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }
    public static void main(String[] args){
        // Fill the original ArrayList with 50 random values from 1 to 20
        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();

        for (int i=0; i<50; i++) {
            originalList.add(random.nextInt(20) + 1); // Generates 1 to 20
        }
        // Call the removeDuplicates method to get the new list
        ArrayList<Integer> distinctList = removeDuplicates(originalList);

        // Print results to the console
        System.out.println("Original List (" + originalList.size() + "elements):");
        System.out.println(originalList);
        
        System.out.println("\nDistnict List (" + distinctList.size() + " elements):");
        System.out.println(distinctList);
    }
}
