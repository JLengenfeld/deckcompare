package de.flux.playground.deckcompare.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import org.apache.commons.lang3.Validate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = { "quantity" })
@XmlType
public class Card {

    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 3;

    private int quantity = 0;
    private String id = null;
    private String value = null;

    public void setQuantity(int quantity) {
        Validate.inclusiveBetween(MIN_QUANTITY, MAX_QUANTITY, quantity);
        this.quantity = quantity;
    }

    @XmlAttribute(name = "qty")
    public int getQuantity() {
        return quantity;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    @XmlValue
    public String getValue() {
        return value;
    }

}
