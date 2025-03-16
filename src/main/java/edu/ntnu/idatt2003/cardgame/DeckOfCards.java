package edu.ntnu.idatt2003.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckOfCards implements Deck {
    private final char[] suit = { 'S', 'H', 'D', 'C' };
    private List<PlayingCard> deck;

    public DeckOfCards() {
        deck = new ArrayList<PlayingCard>();
        for (char s : suit) {
            for (int face = 1; face <= 13; face++) {
                deck.add(new PlayingCard(s, face));
            }
        }
    }

    @Override
    public void shuffle() {
        Collections.shuffle(deck);
    }

    @Override
    public PlayingCard drawCard() {
        return deck.isEmpty() ? null : deck.removeFirst();
    }

    @Override
    public int getDeckSize() {
        return deck.size();
    }

    public List<PlayingCard> getDeck() {
        return new ArrayList<>(deck);
    }

    @Override
    public List<PlayingCard> dealHand(int n) {
        if (n < 1 || n > deck.size()) {
            throw new IllegalArgumentException("Number of hands must be between 1 and " + deck.size());
        }
        List<PlayingCard> hand = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            hand.add(deck.remove(rand.nextInt(deck.size())));
        }
        return hand;
    }
}
