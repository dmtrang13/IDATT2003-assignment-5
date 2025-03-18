package edu.ntnu.idatt2003.cardgame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HandOfCards {
    private final List<PlayingCard> cards = new ArrayList<>();


    public HandOfCards(List<PlayingCard> cards) {
        this.cards.addAll(cards);
    }

    public void addCard(PlayingCard card) {
        cards.add(card);
    }

    public boolean isFlush() {
        if (cards.size() < 5) {
            return false;
        }
        return cards.stream()
                .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()))
                .values().stream().anyMatch(count -> count >= 5);
    }

    public int getTotalValue() {
        return cards.stream().mapToInt(PlayingCard::getFace).sum();
    }

    public String getHearts() {
        String hearts = cards.stream().filter(card -> card.getSuit() == 'H').map(PlayingCard::getAsString).collect(Collectors.joining(" "));
        return hearts.isEmpty() ? "No hearts " : hearts;
    }

    public boolean hasQueenOfSpades() {
        return cards.stream().anyMatch(card -> card.getAsString().equals("S12"));
    }
}
