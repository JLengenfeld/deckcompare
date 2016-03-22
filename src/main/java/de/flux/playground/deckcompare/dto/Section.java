package de.flux.playground.deckcompare.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@XmlType
public class Section {

    private String name;
    private List<Card> cards;

    @XmlAttribute
    public String getName() {
        return name;
    }

    @XmlElement(name = "card")
    public List<Card> getCards() {
        return cards;
    }

}
