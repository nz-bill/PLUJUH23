package com.example.UnitTestExempel1;

import jakarta.persistence.Entity;

@Entity
public class Order {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
