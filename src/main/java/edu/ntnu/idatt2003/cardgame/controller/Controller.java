package edu.ntnu.idatt2003.cardgame.controller;

import edu.ntnu.idatt2003.cardgame.model.DeckOfCards;
import edu.ntnu.idatt2003.cardgame.model.HandOfCards;
import edu.ntnu.idatt2003.cardgame.model.PlayingCard;
import edu.ntnu.idatt2003.cardgame.view.View;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * The controller for the card game application.
 * Manages the interaction between the model and the view.
 */
public class Controller {
    private DeckOfCards deck;
    private View view;
    private boolean flushFound = false;

    /**
     * Constructs a new controller with the given view.
     *
     * @param view the view to be controlled
     */
    public Controller(View view) {
        this.view = view;
        this.deck = new DeckOfCards();
        this.deck.shuffle();

        // Add event handlers
        view.getDealButton().setOnAction(e -> {
            if (!flushFound) {
                dealCards();
            }
        });
    }

    /**
     * Deals a hand of cards and updates the view.
     * If the deck has fewer than 5 cards, a new deck is created and shuffled.
     */
    private void dealCards() {
        if (deck.getDeckSize() < 5) {
            deck = new DeckOfCards();
            deck.shuffle();
        }

        view.getCardGrid().getChildren().clear(); // Clear previous cards

        List<PlayingCard> handCards = deck.dealHand(5);
        HandOfCards hand = new HandOfCards(handCards);

        for (int i = 0; i < handCards.size(); i++) {
            PlayingCard card = handCards.get(i);

            VBox cardSlot = new VBox(5);
            cardSlot.setAlignment(Pos.CENTER);
            cardSlot.getStyleClass().add("card-slot");

            ImageView cardImage = getCardImage(card);
            cardSlot.getChildren().add(cardImage);

            TextField cardInfoField = new TextField(card.getAsString());
            cardInfoField.setEditable(false);
            cardInfoField.setAlignment(Pos.CENTER);
            cardInfoField.getStyleClass().add("card-textfield");

            cardSlot.getChildren().add(cardInfoField);

            view.getCardGrid().add(cardSlot, i, 0);
        }

        view.getSumOfFacesField().setText(String.valueOf(hand.getTotalValue()));
        view.getCardsOfHeartsField().setText(hand.getHearts());
        view.getQueenOfSpadesField().setText(hand.hasQueenOfSpades() ? "Yes" : "No");
        view.getFlushField().setText(hand.isFlush() ? "Yes" : "No");

        if (hand.isFlush()) {
            flushFound = true;
            view.getDealButton().setDisable(true);
        }
    }

    /**
     * Gets the image view for a given playing card.
     *
     * @param card the playing card
     * @return the image view of the card
     */
    private ImageView getCardImage(PlayingCard card) {
        String imagePath = "/images/" + card.getSuit() + ".png";
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(80);
        imageView.setFitHeight(100);
        return imageView;
    }
}
