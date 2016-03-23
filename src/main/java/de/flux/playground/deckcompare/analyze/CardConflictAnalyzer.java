package de.flux.playground.deckcompare.analyze;

import de.flux.playground.deckcompare.dto.Card;
import lombok.NonNull;

public final class CardConflictAnalyzer {

    private CardConflictAnalyzer() {
    }

    public static boolean conflicted(@NonNull Card card, @NonNull Card otherCard) {

        boolean isConflicted = false;

        if (card.equals(otherCard)) {
            int overallQuantity = card.getQuantity() + otherCard.getQuantity();
            isConflicted = overallQuantity > 3;
        }

        return isConflicted;
    }

}
