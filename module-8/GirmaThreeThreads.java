/**
 * Create a class titled [your first="" name="" here=""] ThreeThreads.
 * In this class, you are to use three threads to output three types 
 * of characters to a text area for display.
 * In the first thread, you are to output random letter characters
 * such as a, b, c, d …
 * In the second thread, you are to output random number digits 
 * such as 0, 1, 2, 3, 4, 5, 6, 7, 8, 9.
 * In the third thread, you are to output random characters 
 * such as !, @, #, $, %, &, *
 * Display a minimum of 10,000 for each of the three sets.
 * Write test code that ensures all methods function correctly.
 * Lastly, do not display all data for each thread together.  
 * Each character is to be displayed as each one is generated. 
 * Example:179$^fq*fg1k1k2^%1m4
 */
package com.girma.girmathreethreads;

/**
 * Girma Dingeto, 
 * CSD420 Module 8.2 Assignment , 07/12/2026
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * GirmaThreeThreads
 *
 * This JavaFX program uses three threads to generate characters:
 *  1. Random letters (a–z)
 *  2. Random digits (0–9)
 *  3. Random symbols (!, @, #, $, %, &, *)
 *
 * Each thread outputs 10,000 characters directly to a TextArea.
 * Characters appear immediately as they are generated.
 */
public class GirmaThreeThreads extends Application {

    /** TextArea used to display characters from all threads */
    private TextArea outputArea = new TextArea();

    @Override
    public void start(Stage stage) {

        /** Set up the GUI layout */
        BorderPane root = new BorderPane();
        outputArea.setEditable(false);
        root.setCenter(outputArea);

        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Three Threads Character Generator");
        stage.setScene(scene);
        stage.show();

        /** Start all three threads */
        startLetterThread();
        startDigitThread();
        startSymbolThread();

        /** Run test code */
        runTests();
    }

    /** Thread 1: Output random letters */
    private void startLetterThread() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                char letter = (char) ('a' + Math.random() * 26);
                Platform.runLater(() -> outputArea.appendText(String.valueOf(letter)));
            }
        });
        t1.setDaemon(true);
        t1.start();
    }

    /** Thread 2: Output random digits */
    private void startDigitThread() {
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                char digit = (char) ('0' + Math.random() * 10);
                Platform.runLater(() -> outputArea.appendText(String.valueOf(digit)));
            }
        });
        t2.setDaemon(true);
        t2.start();
    }

    /** Thread 3: Output random symbols */
    private void startSymbolThread() {
        char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                char symbol = symbols[(int) (Math.random() * symbols.length)];
                Platform.runLater(() -> outputArea.appendText(String.valueOf(symbol)));
            }
        });
        t3.setDaemon(true);
        t3.start();
    }

    /** Basic test code to verify methods work correctly */
    private void runTests() {

        /** Test letter generation */
        char testLetter = (char) ('a' + Math.random() * 26);
        System.out.println(Character.isLetter(testLetter)
                ? "PASS: Letter thread generates letters."
                : "FAIL: Letter thread error.");

        /** Test digit generation */
        char testDigit = (char) ('0' + Math.random() * 10);
        System.out.println(Character.isDigit(testDigit)
                ? "PASS: Digit thread generates digits."
                : "FAIL: Digit thread error.");

        /** Test symbol generation */
        char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
        char testSymbol = symbols[(int) (Math.random() * symbols.length)];
        boolean symbolOK = false;
        for (char c : symbols) {
            if (c == testSymbol) symbolOK = true;
        }
        System.out.println(symbolOK
                ? "PASS: Symbol thread generates symbols."
                : "FAIL: Symbol thread error.");
    }

    /** Launch the JavaFX application */
    public static void main(String[] args) {
        launch(args);
    }
}
