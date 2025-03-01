package com.example.nsbandsql.Controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Setter
@Getter
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

}
