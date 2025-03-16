package edu.ntnu.idatt2003.cardgame;

import java.util.List;

public interface Deck {
    void shuffle();
    PlayingCard drawCard();
    List<PlayingCard> dealHand(int n);
    int getDeckSize();

}
