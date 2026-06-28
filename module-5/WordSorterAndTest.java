/**
 * This is a test program that reads words from a text file and displays 
 * all non-duplicate words in ascending order and then in descending order.
 * The file is to be referenced in the program, not needing to be used as a 
 * command-line reference.
 * The Word file is to be titled collection_of_words.txt and included in your submission.
 * test code that ensures the code functions correctly.
 */
/**
 *CSD 420 Module 5.2 Assignment, 06/28/2026
 *Girma Dingeto
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
public class WordeSorterAndTest {

    // Hardcoded reference to the required file name
    private static final String FILE_NAME = "collection_of_words.text";

    public static void main(String[] args) {
        System.out.println("----Running Main Word Sorter Program----\n");

        try {
            // Process the text file
            List<String> uniqueWords = processFile(FILE_NAME);
            if (uniqueWords.isEmpty()) {
                System.out.println("The file is empty or contains no valid words.");
                return;
            }

            // Display in Ascending Order
            System.out.println("Non-duplicate words in Ascending Order:");
            displayWords(uniqueWords);

            // Display in Descending Order
            System.out.println("\nNon-duplicate words in Descending Order:");
            displayWordsDescending(uniqueWords);

            // Run test code
            runTests(uniqueWords);

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            System.err.println("Please ensure '" + FILE_NAME + "' is in your project root folder");
        }
    }

    // Reads a text file and returns a sorted list of unique words.
    public static List<String> processFile(String fileName) throws IOException {
        TreeSet<String> uniqueSet = new TreeSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String cleaned = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (!cleaned.isEmpty()) {
                        uniqueSet.add(cleaned);
                    }
                }
            }
        }
        return new ArrayList<>(uniqueSet);
    }

    // Prints words sequentially (Ascending).
    public static void displayWords(List<String> words) {
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();
    }

    // Prints words in reverse order (Descending).
    public static void displayWordsDescending(List<String> words) {
        List<String> descendingList = new ArrayList<>(words);
        descendingList.sort(Collections.reverseOrder());
        for (String word : descendingList) {
            System.out.print(word + " ");
        }
        System.out.println();
    }

    // ----------------------------------------------------
    // TEST CODE — Ensures the program functions correctly
    // ----------------------------------------------------
    public static void runTests(List<String> uniqueWords) {
        System.out.println("\n----Running Test Cases----");

        // Test 1: Ensure list is not empty
        System.out.println("Test 1 - File contains words: " +
                (!uniqueWords.isEmpty() ? "PASS" : "FAIL"));

        // Test 2: Ensure duplicates removed
        boolean noDuplicates = uniqueWords.size() ==
                uniqueWords.stream().distinct().count();
        System.out.println("Test 2 - No duplicates: " +
                (noDuplicates ? "PASS" : "FAIL"));

        // Test 3: Ensure ascending order is correct
        List<String> sortedCopy = new ArrayList<>(uniqueWords);
        Collections.sort(sortedCopy);
        boolean ascendingCorrect = sortedCopy.equals(uniqueWords);
        System.out.println("Test 3 - Ascending order correct: " +
                (ascendingCorrect ? "PASS" : "FAIL"));

        // Test 4: Ensure descending order is reverse of ascending
        List<String> descending = new ArrayList<>(uniqueWords);
        descending.sort(Collections.reverseOrder());

        List<String> reversedAscending = new ArrayList<>(uniqueWords);
        Collections.reverse(reversedAscending);

        boolean descendingCorrect = descending.equals(reversedAscending);
        System.out.println("Test 4 - Descending order correct: " +
                (descendingCorrect ? "PASS" : "FAIL"));

        System.out.println("----Testing Complete----");
    }
}
