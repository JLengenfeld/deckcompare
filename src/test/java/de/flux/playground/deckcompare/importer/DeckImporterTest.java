package de.flux.playground.deckcompare.importer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Test;

import de.flux.playground.deckcompare.dto.Deck;

public class DeckImporterTest {

    @Test
    public void importDeck() throws Exception {
        DeckImporter importer = new DeckImporter();

        File deckFile = obtainDeckFile("the-fun-ends-here-shl-jinteki-edition-1st-.o8d");
        Deck deck = importer.importDeck(deckFile);

        assertThat(deck.getGame(), is(not("")));
        assertThat(deck.getSection(), is(not(empty())));
        assertThat(deck.getNotes(), is(not("")));
    }

    private File obtainDeckFile(String fileName) throws URISyntaxException {
        URL url = DeckImporterTest.class.getResource(fileName);
        File deckFile = new File(url.toURI());
        return deckFile;
    }

}
