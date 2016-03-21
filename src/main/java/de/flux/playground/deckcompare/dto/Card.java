package de.flux.playground.deckcompare.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@XmlType
public class Card {

    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 3;
    private int qty = 0;
    private String id = null;
    private String value = null;

    @XmlAttribute(name = "qty")
    public int getQuantity() {
        return qty;
    }

    public void setQuantity(int qty) {
        Validate.inclusiveBetween(MIN_QUANTITY, MAX_QUANTITY, qty);
        this.qty = qty;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card [qty=" + qty + ", id=" + id + ", value=" + value + "]" + System.getProperty("line.separator");
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(value).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        return new EqualsBuilder().append(id, other.id).append(value, other.value).isEquals();
    }

}
