package com.example.jpa.jpaWeb;

import com.example.jpa.jpaWeb.entities.ProductEntity;
import com.example.jpa.jpaWeb.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaWebApplicationTests {

    @Autowired
    ProductRepository productRepository;

	@Test
	void contextLoads() {
	}
    @Test
    void testRepository(){
        ProductEntity productEntity = ProductEntity.builder()
                .sku("nestle234")
                .title("Nestle Chocolate")
                .price(BigDecimal.valueOf(123.45))
                .quantity(12)
                .build();
        ProductEntity savedProductEntity = productRepository.save(productEntity);
        System.out.println(savedProductEntity);

    }
    @Test
    void getRepository(){
      //  List<ProductEntity> entities = productRepository.findByCreatedAtAfter(
        //        LocalDateTime.of(2024, 1,1,0,0,0));
     //   List<ProductEntity> entities = productRepository.findByQuantityGreaterThanAndPriceLessThan(4, BigDecimal.valueOf(23.45));
       List<ProductEntity> entities = productRepository.findByTitle("CHoco",null);
        System.out.println(entities);
    }
    @Test
    void getSingleFromRepositry(){
        Optional<ProductEntity> productEntity = productRepository
                .findByTitleAndPrice("Pepsi coco", BigDecimal.valueOf(14.4));
        productEntity.ifPresent(System.out::println);
    }

}
