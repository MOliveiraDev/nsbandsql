package com.example.nsbandsql.Repository;

import com.example.nsbandsql.Model.ProductControl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductControl, Integer> {


}
