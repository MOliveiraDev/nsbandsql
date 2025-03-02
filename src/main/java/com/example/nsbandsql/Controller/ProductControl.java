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
import java.util.Optional;

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

    @GetMapping("/{id}")
    public Object getProductById(@PathVariable Integer id) {
        Optional<ProductModel> product = productRepository.findById(id);
        if (product.isEmpty()){
        return ResponseEntity.status((HttpStatus.NOT_FOUND)).body("Product not found");
        }

        return product.map(value -> ResponseEntity.status(HttpStatus.FOUND).body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @PostMapping
    public ResponseEntity<ProductModel> save(@RequestBody ProductDto dto) {

        var productModel = new ProductModel();
        BeanUtils.copyProperties(dto, productModel);
        ProductModel savedProduct = productRepository.save(productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        Optional<ProductModel> product = productRepository.findById(id);
        if (product.isEmpty()){
            return ResponseEntity.status((HttpStatus.NOT_FOUND)).body("Product not found");
        }
        productRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody ProductDto dto) {
        Optional<ProductModel> product = productRepository.findById(id);
        if (product.isEmpty()){
            return ResponseEntity.status((HttpStatus.NOT_FOUND)).body("Product not found");
        }

        var productModel = new ProductModel();
        BeanUtils.copyProperties(dto, productModel);
        productModel.setId(id);
        productRepository.save(productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel).toString());
    }

}

