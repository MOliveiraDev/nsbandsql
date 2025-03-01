package com.example.nsbandsql.Repository;

import com.example.nsbandsql.Model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {


}
