package edu.ntnu.idatt2003.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HandOfCards implements Hand {
    private final List<PlayingCard> hand;

    public HandOfCards() {
        this.hand = new ArrayList<>();
    }

    public HandOfCards(List<PlayingCard> cards) {
        this.hand = new ArrayList<PlayingCard>(cards);
    }

    @Override
    public void addCard(PlayingCard card) {
        hand.add(card);
    }

    @Override
    public boolean isFlush() {
        if (hand.size() < 5) {
            return false;
        }
        return hand.stream()
                .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()))
                .values().stream().anyMatch(count -> count >= 5);
    }

    @Override
    public String getHandAsString() {
        return hand.stream()
                .map(PlayingCard::getAsString)
                .collect(Collectors.joining(" "));
    }

    @Override
    public List<PlayingCard> getCards() {
        return new ArrayList<>(hand)  ;
    }
}
