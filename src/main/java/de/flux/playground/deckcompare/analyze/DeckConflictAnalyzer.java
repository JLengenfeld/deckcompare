package de.flux.playground.deckcompare.analyze;

import java.util.ArrayList;
import java.util.List;

import de.flux.playground.deckcompare.dto.Card;
import de.flux.playground.deckcompare.dto.Deck;
import lombok.NonNull;

public class DeckConflictAnalyzer {

    public static List<Card> analyze(@NonNull Deck deckA, @NonNull Deck deckB) {
        ArrayList<Card> conflictedCards = new ArrayList<Card>();

        for (Card cardA : deckA.getCards()) {
            for (Card cardB : deckB.getCards()) {
                if (CardConflictAnalyzer.conflicted(cardA, cardB)) {
                    conflictedCards.add(new Card(cardA.getId(), cardA.getValue()));
                }
            }
        }

        return conflictedCards;
    }

}
