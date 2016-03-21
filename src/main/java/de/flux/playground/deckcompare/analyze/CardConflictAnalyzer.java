package de.flux.playground.deckcompare.analyze;

import de.flux.playground.deckcompare.dto.Card;

public final class CardConflictAnalyzer {
    
    private CardConflictAnalyzer() {
    }

    public static boolean conflicted(Card card, Card otherCard) {

        boolean isConflicted = false;

        if (card.equals(otherCard)) {
            int overallQunatity = card.getQuantity() + otherCard.getQuantity();
            isConflicted = overallQunatity > 3;
        }

        return isConflicted;
    }

}
