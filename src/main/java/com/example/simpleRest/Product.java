package com.example.simpleRest;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Product {

@NotBlank(message = "name cannot be empty")
@Size(min = 2, max = 16, message = "name must be between 2 and 16 characters")
    private String name;

    private long id;
@Min(value = 0,message = "value cannot be negative")
@Max(value = 9999, message = "value cannot exceed 9999kr")
    private double price;
@Min(value = 0, message = "quantity cannot be negative")
    private int quantity;

    public Product(String name, long id, double price, int quantity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
