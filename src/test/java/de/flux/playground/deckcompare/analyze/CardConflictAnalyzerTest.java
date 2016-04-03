package de.flux.playground.deckcompare.analyze;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.flux.playground.deckcompare.Deckcompare;
import de.flux.playground.deckcompare.dto.Card;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Deckcompare.class)
public class CardConflictAnalyzerTest {

    @Autowired
    private CardConflictAnalyzer cardAnalyzer;
    private Card emptyCard = new Card("1", "value");
    private Card cardQuantityTwo = new Card("2", "First Card");
    private Card cardQuantityOne = new Card("2", "First Card");
    private Card otherCardQuantityTwo = new Card("3", "Second Card");

    @Before
    public void before() {
        cardQuantityTwo.setQuantity(2);
        cardQuantityOne.setQuantity(1);
        otherCardQuantityTwo.setQuantity(2);
    }

    @Test
    public void emptyCardsAreNotConflicted() {
        boolean conflicted = cardAnalyzer.conflicted(emptyCard, emptyCard);
        assertThat(conflicted, is(false));
    }

    @Test
    public void twoEqualCardsWithOverallQuantityOfThreeAreNotConflicted() {

        boolean conflicted = cardAnalyzer.conflicted(cardQuantityTwo, cardQuantityOne);
        assertThat(conflicted, is(false));
    }

    @Test
    public void twoEqualCardsWithOverallQuantityOfFourAreConflicted() {

        boolean conflicted = cardAnalyzer.conflicted(cardQuantityTwo, cardQuantityTwo);
        assertThat(conflicted, is(true));
    }

    @Test
    public void twoDifferentCardsWithOverallQuantityOfFourAreNotConflicted() {

        boolean conflicted = cardAnalyzer.conflicted(cardQuantityTwo, otherCardQuantityTwo);
        assertThat(conflicted, is(false));
    }

}
