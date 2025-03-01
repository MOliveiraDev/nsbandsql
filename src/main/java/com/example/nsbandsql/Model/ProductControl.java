package com.example.nsbandsql.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ProductControl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public String name;
    public Long price;

    public ProductControl() {
    }

    public ProductControl(Integer id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
