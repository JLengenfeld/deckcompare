package de.flux.playground.deckcompare.analyze;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.flux.playground.deckcompare.dto.Card;
import de.flux.playground.deckcompare.dto.Deck;
import lombok.NonNull;

public class DeckConflictAnalyzer {

    private CardConflictAnalyzer cardAnalyzer;

    @Autowired
    public DeckConflictAnalyzer(CardConflictAnalyzer cardConflictAnalyzer) {
        cardAnalyzer = cardConflictAnalyzer;
    }

    public List<Card> analyze(@NonNull Deck deckA, @NonNull Deck deckB) {
        ArrayList<Card> conflictedCards = new ArrayList<Card>();

        for (Card cardA : deckA.getCards()) {
            for (Card cardB : deckB.getCards()) {
                if (cardAnalyzer.conflicted(cardA, cardB)) {
                    conflictedCards.add(new Card(cardA.getId(), cardA.getValue()));
                }
            }
        }

        return conflictedCards;
    }

}
