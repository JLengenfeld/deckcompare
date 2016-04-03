package de.flux.playground.deckcompare.analyze;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;

import java.net.URL;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.flux.playground.deckcompare.Deckcompare;
import de.flux.playground.deckcompare.dto.Card;
import de.flux.playground.deckcompare.dto.Deck;
import de.flux.playground.deckcompare.importer.DeckImporter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Deckcompare.class)
public class DeckConflictAnalyzerTest {

    private static final URL DECK_A_URL = DeckConflictAnalyzerTest.class.getResource("/decks/the-fun-ends-here-shl-jinteki-edition-1st-.o8d");

    private static Deck deckA = null;
    private static DeckImporter importer = new DeckImporter();

    @Autowired
    private DeckConflictAnalyzer deckAnalyzer;

    @BeforeClass
    public static void beforeClass() {
        deckA = importer.importDeck(DECK_A_URL);
    }

    @Test
    public void comparingTheSameDeckShouldGenerateConflicts() {
        List<Card> conflictedCards = deckAnalyzer.analyze(deckA, deckA);

        assertThat(conflictedCards, notNullValue());
        assertThat(conflictedCards, is(not(empty())));
        // TODO: add more asserts
    }

}
