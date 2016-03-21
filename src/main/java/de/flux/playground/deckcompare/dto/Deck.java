package de.flux.playground.deckcompare.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.Getter;

@Data
@XmlRootElement
public class Deck {

    @Getter(onMethod = @__({ @XmlAttribute(name = "game") }) )
    private String id;
    @Getter(onMethod = @__({ @XmlElement(name = "section") }) )
    private List<Section> sections;
    private String notes;

}
