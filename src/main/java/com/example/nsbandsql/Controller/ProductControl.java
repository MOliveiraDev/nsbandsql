package com.example.nsbandsql.Controller;

import com.example.nsbandsql.Model.ProductModel;
import com.example.nsbandsql.Repository.ProductRepository;
import com.example.nsbandsql.dtos.ProductDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductControl {

    private final ProductRepository productRepository;

    public ProductControl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    Map<String, String> errorResponse = new HashMap<>();
                    errorResponse.put("error", "Product not found");
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
                });
    }

    @PostMapping
    public ResponseEntity<ProductModel> save(@RequestBody ProductDto dto) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(dto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        if (!productRepository.existsById(id)) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Product not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();  // Retorna HTTP 204 (No Content)
    }
}
