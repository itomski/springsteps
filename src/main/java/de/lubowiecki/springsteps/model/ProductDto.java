package de.lubowiecki.springsteps.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// DTO = Data Transfer Object
// Es wird immer dann benutzt, wenn die Datenbank-Daten sich von den Formulardaten unterscheiden
public class ProductDto {
    private long id;

    private String name;

    private String description;

    private String availableAt;

    private String price;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailableAt(String availableAt) {
        this.availableAt = availableAt;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPriceDE(String price) {
        this.setPrice(price);
    }

    public Product convert() {
        Product p = new Product();
        p.setId(id);
        p.setName(name);
        p.setDescription(description);
        p.setPrice(Double.parseDouble(price.replace(",", ".")));
        DateTimeFormatter fmt = DateTimeFormatter.ISO_DATE_TIME;
        p.setAvailableAt(LocalDateTime.parse(availableAt, fmt));
        return p;
    }
}
