package edu.ntnu.idatt2003.cardgame.controller;

import edu.ntnu.idatt2003.cardgame.model.DeckOfCards;
import edu.ntnu.idatt2003.cardgame.model.HandOfCards;
import edu.ntnu.idatt2003.cardgame.model.PlayingCard;
import edu.ntnu.idatt2003.cardgame.view.View;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.List;

public class Controller {
    private DeckOfCards deck;
    private View view;

    public Controller(View view) {
        this.view = view;
        this.deck = new DeckOfCards();
        this.deck.shuffle();

        // Add event handlers
        view.getDealButton().setOnAction(e -> dealCards());
    }

    private void dealCards() {
        view.getCardGrid().getChildren().clear(); // Clear previous cards

        List<PlayingCard> handCards = deck.dealHand(5);
        HandOfCards hand = new HandOfCards(handCards);

        for (int i = 0; i < handCards.size(); i++) {
            PlayingCard card = handCards.get(i);
            VBox cardSlot = new VBox();
            cardSlot.getStyleClass().add("card-slot");

            ImageView cardImage = getCardImage(card);
            cardSlot.getChildren().add(cardImage);

            view.getCardGrid().add(cardSlot, i, 0);
        }

        view.getSumOfFacesField().setText(String.valueOf(hand.getTotalValue()));
        view.getCardsOfHeartsField().setText(hand.getHearts());
        view.getQueenOfSpadesField().setText(hand.hasQueenOfSpades() ? "Yes" : "No");
        view.getFlushField().setText(hand.isFlush() ? "Yes" : "No");
    }

    private ImageView getCardImage(PlayingCard card) {
        String imagePath = "/images/" + card.getSuit() + ".png";
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(80);
        imageView.setFitHeight(120);
        return imageView;
    }
}
