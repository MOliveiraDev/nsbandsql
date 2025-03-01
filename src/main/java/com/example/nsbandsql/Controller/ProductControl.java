package com.example.nsbandsql.Controller;


import com.example.nsbandsql.Model.ProductModel;
import com.example.nsbandsql.Repository.ProductRepository;
import com.example.nsbandsql.dtos.ProductDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductControl {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        List<ProductModel> products = productRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @PostMapping
    public ResponseEntity<ProductModel> save(@RequestBody ProductDto dto) {

        var productModel = new ProductModel();
        BeanUtils.copyProperties(dto, productModel);
        ProductModel savedProduct = productRepository.save(productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

}

