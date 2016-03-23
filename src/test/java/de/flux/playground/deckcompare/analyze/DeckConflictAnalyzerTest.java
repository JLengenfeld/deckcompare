package de.flux.playground.deckcompare.analyze;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;

import java.net.URL;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import de.flux.playground.deckcompare.dto.Card;
import de.flux.playground.deckcompare.dto.Deck;
import de.flux.playground.deckcompare.importer.DeckImporter;

public class DeckConflictAnalyzerTest {

    private static Deck deckA = null;

    @BeforeClass
    public static void beforeClass() {
        DeckImporter importer = new DeckImporter();
        URL url = DeckConflictAnalyzerTest.class.getResource("/decks/the-fun-ends-here-shl-jinteki-edition-1st-.o8d");
        deckA = importer.importDeck(url);
    }

    @Test
    public void test() {
        List<Card> conflictedCards = DeckConflictAnalyzer.analyze(deckA, deckA);

        assertThat(conflictedCards, is(not(null)));
        assertThat(conflictedCards, is(not(empty())));
    }

}
