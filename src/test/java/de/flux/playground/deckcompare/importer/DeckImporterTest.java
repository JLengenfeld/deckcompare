package de.flux.playground.deckcompare.importer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Test;

import de.flux.playground.deckcompare.dto.Deck;

public class DeckImporterTest {

    private static final int FIRST_SECTION = 0;
    private static final int SECOND_SECTION = 1;

    @Test
    public void importDeck() throws Exception {
        DeckImporter importer = new DeckImporter();

        File deckFile = obtainDeckFile("the-fun-ends-here-shl-jinteki-edition-1st-.o8d");
        Deck deck = importer.importDeck(deckFile);

        assertThat(deck.getGame(), is("0f38e453-26df-4c04-9d67-6d43de939c77"));
        assertSections(deck);
        assertThat(deck.getNotes(), is(not("")));
    }

    private void assertSections(Deck deck) {
        assertThat(deck.getSection().size(), is(2));
        assertIdentity(deck);
        assertCardsOfDeck(deck);
    }

    private void assertIdentity(Deck deck) {
        assertThat(deck.getSection().get(FIRST_SECTION).getCard().size(), is(1));
        // TODO: add more asserts for the identity
    }

    private void assertCardsOfDeck(Deck deck) {
        assertThat(deck.getSection().get(SECOND_SECTION).getCard().size(), is(24));
        // TODO: add more asserts for the cards of the deck
    }

    private File obtainDeckFile(String fileName) throws URISyntaxException {
        URL url = DeckImporterTest.class.getResource(fileName);
        return new File(url.toURI());
    }

}
