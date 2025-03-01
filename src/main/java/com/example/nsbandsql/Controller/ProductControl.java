package com.example.nsbandsql.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductControl {

    @GetMapping
    public String hello(){
        return "Hello World";
    }
}
