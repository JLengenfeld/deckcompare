package de.flux.playground.deckcompare.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import org.apache.commons.lang3.Validate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = { "quantity" })
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Card {

    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 3;

    @XmlAttribute(name = "qty")
    private int quantity = 0;
    @NonNull
    @XmlAttribute
    private String id;
    @NonNull
    @XmlValue
    private String value;

    public void setQuantity(int quantity) {
        Validate.inclusiveBetween(MIN_QUANTITY, MAX_QUANTITY, quantity);
        this.quantity = quantity;
    }

}
