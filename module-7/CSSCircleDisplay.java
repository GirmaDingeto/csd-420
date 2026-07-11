/*
 * Create an external CSS style sheet that defines:
 *   - A class for white fill and black stroke
 *   - IDs for red and green fill colors
 *
 * Write a JavaFX program that displays four circles and uses
 * the style class and IDs.
 *
 * Write test code that ensures your code functions correctly.
 *
 * https://media.pearsoncmg.com/ph/php8/sites/ecs_liang_java_12/cw/#web-chapters
 */

package com.girma.csscircledisplay;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CSSCircleDisplay extends Application {

    @Override
    public void start(Stage primaryStage) {

        /** Create an HBox container with spacing and center alignment */
        HBox pane = new HBox(15);
        pane.setAlignment(Pos.CENTER);

        /** Create circle #1 and apply the shared CSS class */
        Circle c1 = new Circle(50);
        c1.getStyleClass().add("whiteBlack");

        /** Create circle #2 and apply the shared CSS class */
        Circle c2 = new Circle(50);
        c2.getStyleClass().add("whiteBlack");

        /** Create circle #3, apply class, and assign red ID */
        Circle c3 = new Circle(50);
        c3.getStyleClass().add("whiteBlack");
        c3.setId("redCircle");

        /** Create circle #4, apply class, and assign green ID */
        Circle c4 = new Circle(50);
        c4.getStyleClass().add("whiteBlack");
        c4.setId("greenCircle");

        /** Add all circles to an HBox layout */
        HBox root = new HBox(20, c1, c2, c3, c4);

        /** Create a scene and load the external CSS file */
        Scene scene = new Scene(root, 400, 150);
        scene.getStylesheets().add(
            getClass().getResource("/mystyle.css").toExternalForm()
        );

        /** Set up the stage and display the window */
        primaryStage.setTitle("CSS Circle Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /** Launch the JavaFX application */
    public static void main(String[] args) {
        launch(args);
    }
}
