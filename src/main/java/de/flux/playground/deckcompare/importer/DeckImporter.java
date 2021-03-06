package de.flux.playground.deckcompare.importer;

import static java.lang.String.format;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import de.flux.playground.deckcompare.dto.Deck;
import lombok.NonNull;

public class DeckImporter {

    public Deck importDeck(@NonNull URL url) {
        try {
            return importDeck(new File(url.toURI()));
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(format("The provided URL '%s' cannot be converted to a URI.", url), e);
        }
    }

    public Deck importDeck(@NonNull File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(format("File '%s' does not exist!", file));
        }

        Deck deck = new Deck();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Deck.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            deck = (Deck) jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            throw new ImportException("Could not import deck", e);
        }

        return deck;
    }

}
