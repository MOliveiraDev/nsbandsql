package com.example.nsbandsql.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")

public class ProductC {
    private Integer id;
    private String name;
    private Long price;

    public ProductC(Integer id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductC() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
