package de.flux.playground.deckcompare.importer;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import de.flux.playground.deckcompare.dto.Deck;

public class DeckImporter {

    public Deck importDeck(File file) {
        Deck deck = new Deck();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Deck.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            deck = (Deck) jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return deck;
    }

}
