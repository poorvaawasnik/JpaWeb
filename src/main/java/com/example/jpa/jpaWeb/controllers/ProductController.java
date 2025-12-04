package com.example.jpa.jpaWeb.controllers;

import com.example.jpa.jpaWeb.entities.ProductEntity;
import com.example.jpa.jpaWeb.repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final int PAGE_SIZE = 5;
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(


            @RequestParam(required = false) String title,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "1") Integer pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy));

        if (title != null && !title.isEmpty()) {
            return productRepository.findByTitleContainingIgnoreCase(title, pageable);
        }

        return productRepository.findAll(pageable).getContent();
    }
}
