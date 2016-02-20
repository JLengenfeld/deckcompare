package de.flux.playground.deckcompare.analyze;

import de.flux.playground.deckcompare.dto.Card;

// compare two decks
// add qty from intersecting cards (obtain intersection streams lambda)
// filter for qty > 3
// return conflicting cards
public class CardConflictAnalyzer {

    public static boolean conflicted(Card card, Card otherCard) {

        boolean isConflicted = false;

        if (card.equals(otherCard)) {
            int overallQunatity = card.getQty() + otherCard.getQty();
            isConflicted = overallQunatity > 3;
        }

        return isConflicted;
    }

}
