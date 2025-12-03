package com.example.jpa.jpaWeb.repositories;

import com.example.jpa.jpaWeb.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
