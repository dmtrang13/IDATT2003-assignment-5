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

/**
 * Represents the view for the card game application.
 */
public class View {
    private GridPane cardGrid = new GridPane();
    private Button dealButton = new Button("Deal Hand");

    private TextField sumOfFacesField = new TextField();
    private TextField cardsOfHeartsField = new TextField();
    private TextField queenOfSpadesField = new TextField();
    private TextField flushField = new TextField();

    /**
     * Starts the view and sets up the primary stage.
     *
     * @param primaryStage the primary stage for this application
     */
    public void start(Stage primaryStage) {
        VBox root = new VBox(15);
        root.setAlignment(Pos.TOP_CENTER);
        cardGrid.setAlignment(Pos.TOP_CENTER);
        cardGrid.setVgap(10);
        cardGrid.setPrefSize(500, 200);


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

        root.getChildren().addAll(cardGrid, inputGrid, buttonBox);

        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("/cardgame-styles.css").toExternalForm());

        primaryStage.setTitle("Card Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Gets the grid pane for displaying cards.
     *
     * @return the card grid
     */
    public GridPane getCardGrid() {
        return cardGrid;
    }

    /**
     * Gets the button for dealing a hand.
     *
     * @return the deal button
     */
    public Button getDealButton() {
        return dealButton;
    }

    /**
     * Gets the text field for displaying the sum of faces.
     *
     * @return the sum of faces text field
     */
    public TextField getSumOfFacesField() {
        return sumOfFacesField;
    }

    /**
     * Gets the text field for displaying the cards of hearts.
     *
     * @return the cards of hearts text field
     */
    public TextField getCardsOfHeartsField() {
        return cardsOfHeartsField;
    }

    /**
     * Gets the text field for displaying if the hand has the Queen of Spades.
     *
     * @return the Queen of Spades text field
     */
    public TextField getQueenOfSpadesField() {
        return queenOfSpadesField;
    }

    /**
     * Gets the text field for displaying if the hand is a flush.
     *
     * @return the flush text field
     */
    public TextField getFlushField() {
        return flushField;
    }
}
