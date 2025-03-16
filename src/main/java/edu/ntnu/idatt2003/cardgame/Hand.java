package edu.ntnu.idatt2003.cardgame;

import java.util.List;

public interface Hand {
    void addCard(PlayingCard card);
    boolean isFlush();
    String getHandAsString();
    List<PlayingCard> getCards();
}
