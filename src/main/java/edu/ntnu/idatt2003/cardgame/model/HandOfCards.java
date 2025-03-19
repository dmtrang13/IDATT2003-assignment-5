package edu.ntnu.idatt2003.cardgame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a hand of playing cards.
 */
public class HandOfCards {
    private final List<PlayingCard> cards = new ArrayList<>();

    /**
     * Constructs a hand of cards with the given list of cards.
     *
     * @param cards the list of cards to initialize the hand with
     */
    public HandOfCards(List<PlayingCard> cards) {
        this.cards.addAll(cards);
    }

    /**
     * Adds a card to the hand.
     *
     * @param card the card to add
     */
    public void addCard(PlayingCard card) {
        cards.add(card);
    }

    /**
     * Checks if the hand is a flush (all cards of the same suit).
     *
     * @return true if the hand is a flush, false otherwise
     */
    public boolean isFlush() {
        if (cards.size() < 5) {
            return false;
        }
        return cards.stream()
                .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()))
                .values().stream().anyMatch(count -> count >= 5);
    }

    /**
     * Gets the total value of the cards in the hand.
     *
     * @return the total value of the cards
     */
    public int getTotalValue() {
        return cards.stream().mapToInt(PlayingCard::getFace).sum();
    }

    /**
     * Gets a string representation of all hearts in the hand.
     *
     * @return a string of all hearts, or "No hearts" if there are none
     */
    public String getHearts() {
        String hearts = cards.stream().filter(card -> card.getSuit() == 'H').map(PlayingCard::getAsString).collect(Collectors.joining(" "));
        return hearts.isEmpty() ? "No hearts " : hearts;
    }

    /**
     * Checks if the hand contains the Queen of Spades.
     *
     * @return true if the hand contains the Queen of Spades, false otherwise
     */
    public boolean hasQueenOfSpades() {
        return cards.stream().anyMatch(card -> card.getAsString().equals("S12"));
    }
}
