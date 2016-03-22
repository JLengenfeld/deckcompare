package de.flux.playground.deckcompare.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Section {

    @XmlAttribute
    private String name;
    @XmlElement(name = "card")
    private List<Card> cards;

}
