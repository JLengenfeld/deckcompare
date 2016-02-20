package de.flux.playground.deckcompare.analyze;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import de.flux.playground.deckcompare.dto.Card;

public class CardConflictAnalyzerTest {

    private Card emptyCard = new Card();
    private Card cardQuantityTwo = new Card();
    private Card cardQuantityOne = new Card();
    private Card otherCardQuantityTwo = new Card();

    @Before
    public void before() {
        cardQuantityTwo.setValue("FirstCard");
        cardQuantityTwo.setQty(2);

        cardQuantityOne.setValue("FirstCard");
        cardQuantityOne.setQty(1);

        otherCardQuantityTwo.setValue("SecondCard");
        otherCardQuantityTwo.setQty(2);
    }

    @Test
    public void emptyCardsAreNotConflicted() {
        boolean conflicted = CardConflictAnalyzer.conflicted(emptyCard, emptyCard);
        assertThat(conflicted, is(false));
    }

    @Test
    public void twoEqualCardsWithOverallQuantityOfThreeAreNotConflicted() {

        boolean conflicted = CardConflictAnalyzer.conflicted(cardQuantityTwo, cardQuantityOne);
        assertThat(conflicted, is(false));
    }

    @Test
    public void twoEqualCardsWithOverallQuantityOfFourAreConflicted() {

        boolean conflicted = CardConflictAnalyzer.conflicted(cardQuantityTwo, cardQuantityTwo);
        assertThat(conflicted, is(true));
    }

    @Test
    public void twoDifferentCardsWithOverallQuantityOfFourAreNotConflicted() {

        boolean conflicted = CardConflictAnalyzer.conflicted(cardQuantityTwo, otherCardQuantityTwo);
        assertThat(conflicted, is(false));
    }

}
