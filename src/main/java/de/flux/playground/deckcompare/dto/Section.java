package de.flux.playground.deckcompare.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;
import lombok.Getter;

@Data
@XmlType
public class Section {

    @Getter(onMethod = @__(@XmlAttribute) )
    private String name;
    @Getter(onMethod = @__(@XmlElement(name = "card")) )
    private List<Card> cards;

}
