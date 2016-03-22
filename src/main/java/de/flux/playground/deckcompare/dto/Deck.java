package de.flux.playground.deckcompare.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class Deck {

    private String id;
    private List<Section> sections;
    private String notes;

    @XmlAttribute(name = "game")
    public String getId() {
        return id;
    }

    @XmlElement(name = "section")
    public List<Section> getSections() {
        return sections;
    }

}
