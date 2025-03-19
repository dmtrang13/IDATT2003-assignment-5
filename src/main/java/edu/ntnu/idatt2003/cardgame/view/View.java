package edu.ntnu.idatt2003.cardgame.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {
    private GridPane cardGrid = new GridPane();
    private Button dealButton = new Button("Deal Hand");

    private TextField sumOfFacesField = new TextField();
    private TextField cardsOfHeartsField = new TextField();
    private TextField queenOfSpadesField = new TextField();
    private TextField flushField = new TextField();

    public void start(Stage primaryStage) {
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);

        // Set text field sizes
        sumOfFacesField.setPrefWidth(100);
        cardsOfHeartsField.setPrefWidth(150);
        queenOfSpadesField.setPrefWidth(80);
        flushField.setPrefWidth(80);

        // Create labels for text fields
        GridPane inputGrid = new GridPane();
        inputGrid.setHgap(10);
        inputGrid.setVgap(5);
        inputGrid.setAlignment(Pos.CENTER);

        inputGrid.add(new Label("Sum of faces:"), 0, 0);
        inputGrid.add(sumOfFacesField, 1, 0);
        inputGrid.add(new Label("Cards of hearts:"), 0, 1);
        inputGrid.add(cardsOfHeartsField, 1, 1);
        inputGrid.add(new Label("Queen of spades?"), 0, 2);
        inputGrid.add(queenOfSpadesField, 1, 2);
        inputGrid.add(new Label("Flush?"), 0, 3);
        inputGrid.add(flushField, 1, 3);

        // Button container
        HBox buttonBox = new HBox(10, dealButton);
        buttonBox.setAlignment(Pos.CENTER);

        // Add everything to root layout
        root.getChildren().addAll(cardGrid, inputGrid, buttonBox);

        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("/cardgame-styles.css").toExternalForm());

        primaryStage.setTitle("Card Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GridPane getCardGrid() {
        return cardGrid;
    }

    public Button getDealButton() {
        return dealButton;
    }

    public TextField getSumOfFacesField() {
        return sumOfFacesField;
    }

    public TextField getCardsOfHeartsField() {
        return cardsOfHeartsField;
    }

    public TextField getQueenOfSpadesField() {
        return queenOfSpadesField;
    }

    public TextField getFlushField() {
        return flushField;
    }
}
