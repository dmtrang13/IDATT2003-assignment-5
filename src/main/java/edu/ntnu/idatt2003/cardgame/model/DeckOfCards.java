package edu.ntnu.idatt2003.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Represents a deck of playing cards.
 */
public class DeckOfCards {
    private final char[] suit = { 'S', 'H', 'D', 'C' };
    private List<PlayingCard> deck;

    /**
     * Constructs a new deck of cards with all suits and faces.
     */
    public DeckOfCards() {
        deck = new ArrayList<PlayingCard>();
        for (char s : suit) {
            for (int face = 1; face <= 13; face++) {
                deck.add(new PlayingCard(s, face));
            }
        }
    }

    /**
     * Shuffles the deck of cards.
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Returns the number of remaining cards in the deck.
     *
     * @return the size of the deck
     */
    public int getDeckSize() {
        return deck.size();
    }

    /**
     * Deals a hand of n cards from the deck.
     *
     * @param n the number of cards to deal
     * @return a list of dealt cards
     * @throws IllegalArgumentException if the number of cards to deal is less than 1 or greater than the size of the deck
     * @throws IllegalStateException if the deck is empty
     * */
    public List<PlayingCard> dealHand(int n) {
        if (n < 1 || n > deck.size()) {
            throw new IllegalArgumentException("Number of hands must be between 1 and " + deck.size());
        }
        List<PlayingCard> hand = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            if (deck.isEmpty()) {
                throw new IllegalStateException("Deck is empty");
            }
            hand.add(deck.remove(rand.nextInt(deck.size())));
        }
        return hand;
    }
}
