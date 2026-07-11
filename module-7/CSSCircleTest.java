package com.girma.csscircledisplay;

import javafx.scene.shape.Circle;

/**
 * CSSCircleTest
 *
 * This class performs simple, non‑GUI tests to verify that:
 *  1. A JavaFX Circle can have a CSS style class applied.
 *  2. A JavaFX Circle can have an ID applied.
 *  3. The CSS file (mystyle.css) exists in the correct project location.
 *
 * These tests do NOT launch a JavaFX window. They only print PASS/FAIL
 * results to the console. This makes it useful for quick validation
 * without needing to run the full JavaFX application.
 */
public class CSSCircleTest {

    public static void main(String[] args) {

        /**
         * Create a Circle object with radius 50.
         * This Circle exists only in memory and is not displayed.
         * JavaFX allows creating nodes without starting the GUI runtime,
         * which makes this kind of testing possible.
         */
        Circle testCircle = new Circle(50);

        /**
         * Apply a CSS style class named "whiteBlack".
         * This corresponds to a selector in mystyle.css:
         *
         *      .whiteBlack { ... }
         *
         * Style classes allow multiple nodes to share the same styling.
         */
        testCircle.getStyleClass().add("whiteBlack");

        /**
         * Assign an ID to the Circle.
         * This corresponds to a selector in mystyle.css:
         *
         *      #redCircle { ... }
         *
         * IDs are unique and used when you want to style one specific node.
         */
        testCircle.setId("redCircle");

        /**
         * Test 1: Verify that the style class was applied.
         * We check whether "whiteBlack" exists in the Circle's styleClass list.
         */
        System.out.println(
            testCircle.getStyleClass().contains("whiteBlack")
                ? "PASS: Style class applied."
                : "FAIL: Style class missing."
        );

        /**
         * Test 2: Verify that the ID was applied correctly.
         * We compare the Circle's ID with the expected value "redCircle".
         */
        System.out.println(
            "redCircle".equals(testCircle.getId())
                ? "PASS: ID applied correctly."
                : "FAIL: ID not applied."
        );

        /**
         * Test 3: Verify that the CSS file exists in the project.
         *
         * This checks the physical file path:
         *      src/main/resources/mystyle.css
         *
         * NOTE:
         * During an actual JavaFX application run, CSS files are loaded
         * from the classpath, not directly from the filesystem.
         * This test simply confirms that the file is present in the project.
         */
        java.io.File css = new java.io.File("src/main/resources/mystyle.css");

        System.out.println(
            css.exists()
                ? "PASS: CSS file found."
                : "FAIL: CSS file missing."
        );
    }
}

