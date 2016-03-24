package de.flux.playground.deckcompare.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Deck {

    private static final int DEFAULT_SECTIONS = 2;
    private static final int CARDS_SECTION = 1;

    @XmlAttribute(name = "game")
    private String id;
    @XmlElement(name = "section")
    private List<Section> sections;
    private String notes;

    public List<Card> getCards() {
        List<Card> cards = new ArrayList<Card>();

        if (sections.size() >= DEFAULT_SECTIONS) {
            cards = sections.get(CARDS_SECTION).getCards();
        }

        return cards;
    }

}
