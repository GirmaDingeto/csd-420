/* Girma Dingeto, CSD420 Module 7.2 Assignment, 07/12/2026
 *
 * Displays four circles using external CSS.
 * The first circle is inside a vertical black-bordered rectangle.
 * The rectangle width equals the circle diameter so they touch.
 * All circles remain on the same horizontal axis.
 */

package com.girma.csscircledisplay;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;   // REQUIRED
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CSSCircleDisplay extends Application {

    @Override
    public void start(Stage primaryStage) {

        /** Create circle #1 and apply the shared CSS class */
        Circle c1 = new Circle(50);   // diameter = 100
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

        /** Create a vertical bordered box for the first circle */
        VBox borderedBox = new VBox(c1);
        borderedBox.setAlignment(Pos.CENTER);

        /** Make the box width EXACTLY equal to the circle diameter */
        borderedBox.setPrefWidth(100);
        borderedBox.setMinWidth(100);
        borderedBox.setMaxWidth(100);

        /** Make the box tall */
        borderedBox.setPrefHeight(200);

        /** Darker and thicker border */
        borderedBox.setStyle(
            "-fx-border-color: #000000;" +   /* pure black */
            "-fx-border-width: 8px;" +       /* thick border */
            "-fx-border-style: solid;" +
            "-fx-border-insets: 0;"
        );

        /** Put all circles on the same horizontal axis */
        HBox root = new HBox(20, borderedBox, c2, c3, c4);
        root.setAlignment(Pos.CENTER);

        /** Create a scene and load the external CSS file */
        Scene scene = new Scene(root, 600, 250);
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
