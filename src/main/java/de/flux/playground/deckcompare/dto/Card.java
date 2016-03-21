package de.flux.playground.deckcompare.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import org.apache.commons.lang3.Validate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(exclude = { "quantity" })
@XmlType
public class Card {

    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 3;

    @Getter(onMethod = @__({ @XmlAttribute(name = "qty") }) )
    private int quantity = 0;
    @Getter(onMethod = @__({ @XmlAttribute }) )
    private String id = null;
    @Getter(onMethod = @__({ @XmlValue }) )
    private String value = null;

    public void setQuantity(int quantity) {
        Validate.inclusiveBetween(MIN_QUANTITY, MAX_QUANTITY, quantity);
        this.quantity = quantity;
    }

}
