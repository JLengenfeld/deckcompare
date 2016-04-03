package de.flux.playground.deckcompare.analyze;

import de.flux.playground.deckcompare.dto.Card;
import lombok.NonNull;

public class CardConflictAnalyzer {

    public boolean conflicted(@NonNull Card card, @NonNull Card otherCard) {

        boolean isConflicted = false;

        if (card.equals(otherCard)) {
            int overallQuantity = card.getQuantity() + otherCard.getQuantity();
            isConflicted = overallQuantity > 3;
        }

        return isConflicted;
    }

}
