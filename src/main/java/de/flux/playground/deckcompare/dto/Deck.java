package de.flux.playground.deckcompare.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Deck {

    private String game;
    private List<Section> section;
    private String notes;

    @XmlAttribute
    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    @XmlElement
    public List<Section> getSection() {
        return section;
    }

    public void setSection(List<Section> sections) {
        this.section = sections;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Deck [game=" + game + ", section=" + section + ", notes=" + notes + "]";
    }

}
