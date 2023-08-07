package de.lubowiecki.springsteps;

import java.time.LocalDate;

public class Product {

    private int id;

    private String name;

    private double price;

    private int amount;

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

    public void setAvailableSince(LocalDate availableSince) {
        this.availableSince = availableSince;
    }
}
