package com.girma.cardgameassignment;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main extends Application {

    private final List<String> cardDeck = new ArrayList<>();
    private final HBox cardBox = new HBox(15);
    private final Button btnRefresh = new Button("Refresh");

    @Override
    public void start(Stage primaryStage) {

        // Load filenames 1.png, 2.png, ..., 52.png
        for (int i = 1; i <= 52; i++) {
            cardDeck.add(i + ".png");
        }

        cardBox.setAlignment(Pos.CENTER);
        cardBox.setPadding(new Insets(20));

        btnRefresh.setOnAction(e -> drawFourCards());
        btnRefresh.setStyle("-fx-font-size: 16px; -fx-padding: 10 20;");

        drawFourCards();

        BorderPane root = new BorderPane();
        root.setCenter(cardBox);
        root.setBottom(btnRefresh);
        BorderPane.setAlignment(btnRefresh, Pos.CENTER);
        BorderPane.setMargin(btnRefresh, new Insets(0, 0, 20, 0));

        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("Random Card Dealer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawFourCards() {
        cardBox.getChildren().clear();

        Collections.shuffle(cardDeck);

        for (int i = 0; i < 4; i++) {
            String fileName = cardDeck.get(i);

            Image image = new Image(getClass().getResource("/images/" + fileName).toString());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(100);
            imageView.setPreserveRatio(true);

            cardBox.getChildren().add(imageView);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
