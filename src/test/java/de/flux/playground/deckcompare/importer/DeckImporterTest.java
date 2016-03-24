package de.flux.playground.deckcompare.importer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Test;

import de.flux.playground.deckcompare.dto.Card;
import de.flux.playground.deckcompare.dto.Deck;
import de.flux.playground.deckcompare.dto.Section;

public class DeckImporterTest {

    private static final int FIRST_SECTION = 0;
    private static final int SECOND_SECTION = 1;
    private DeckImporter importer = new DeckImporter();

    @Test
    public void importDeck() throws Exception {
        URL deckFile = obtainDeckUrl("/decks/the-fun-ends-here-shl-jinteki-edition-1st-.o8d");
        Deck deck = importer.importDeck(deckFile);

        assertThat(deck.getId(), is("0f38e453-26df-4c04-9d67-6d43de939c77"));
        assertSections(deck);
        assertThat(deck.getNotes(), is(not("")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionBecauseUriSchemeIsNotFile() throws Exception {
        importer.importDeck(new URL("http://www.google.de"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionBecauseUrlIsNoValidUri() throws Exception {
        importer.importDeck(new URL("http://www.google.de[]"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionBecauseFileDoesNotExist() throws Exception {
        importer.importDeck(new File("/does/not/exist"));
    }

    @Test(expected = ImportException.class)
    public void exceptionBecauseXmlFileIsMalformed() throws Exception {
        URL malformedFile = obtainDeckUrl("/decks/malformedFile.o8d");
        importer.importDeck(new File(malformedFile.toURI()));
    }

    private void assertSections(Deck deck) {
        assertThat(deck.getSections().size(), is(2));
        assertIdentity(deck);
        assertCardsOfDeck(deck);
    }

    private void assertIdentity(Deck deck) {
        Section identitySection = deck.getSections().get(FIRST_SECTION);
        assertThat(identitySection.getCards().size(), is(1));
        assertThat(identitySection.getName(), is("Identity"));

        Card identityCard = identitySection.getCards().get(0);
        assertThat(identityCard.getId(), is("bc0f047c-01b1-427f-a439-d451eda07029"));
        assertThat(identityCard.getQuantity(), is(1));
        assertThat(identityCard.getValue(), is("MaxX: Maximum Punk Rock"));
    }

    private void assertCardsOfDeck(Deck deck) {
        Section cardsSection = deck.getSections().get(SECOND_SECTION);
        assertThat(cardsSection.getCards().size(), is(24));
        assertThat(cardsSection.getName(), is("R&D / Stack"));

        // assert all values of one card
        Card regularCard = cardsSection.getCards().get(0);
        assertThat(regularCard.getId(), is("bc0f047c-01b1-427f-a439-d451eda01002"));
        assertThat(regularCard.getQuantity(), is(3));
        assertThat(regularCard.getValue(), is("Déjà Vu"));
    }

    private URL obtainDeckUrl(String fileName) throws URISyntaxException {
        return this.getClass().getResource(fileName);
    }

}
