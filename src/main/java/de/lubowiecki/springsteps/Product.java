package de.lubowiecki.springsteps;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "products")
public class Product {

    private static DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Id
    @GeneratedValue // Autoincrement
    private int id;

    @Column(length = 100)
    @NotEmpty
    private String name;

    @Positive
    private double price;

    @PositiveOrZero
    private int amount;

    @NotNull(message = "Muss ein gültiges Datum sein")
    @PastOrPresent
    private LocalDate availableSince;

    public Product() {
    }

    public Product(String name, double price, int amount, LocalDate availableSince) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.availableSince = availableSince;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getAvailableSince() {
        return availableSince;
    }
    public String getAvailableSinceDe() {
        return availableSince.format(DATE_FMT);
    }

    public void setAvailableSince(LocalDate availableSince) {
        this.availableSince = availableSince;
    }
}
