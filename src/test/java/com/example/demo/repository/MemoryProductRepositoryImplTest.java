package com.example.demo.repository;

import com.example.demo.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryProductRepositoryImplTest {

    ProductRepository productRepository = new MemoryProductRepositoryImpl();

    @Test
    void findAll() {

        List<Product> allProducts = productRepository.findAll();
        System.out.println("allProducts = " + allProducts);
        assertThat(allProducts.size()).isEqualTo(2);

    }

    @Test
    void findById() {
        Product find = productRepository.findById(1);
        assertThat(find.getProductName()).isEqualTo("제품명1");
    }

    @Test
    void insert() {
        Product p = Product.builder().productName("제품명2").maker("테스트").price(20000).quantity(20).build();
        Product insert = productRepository.insert(p);
        assertThat(productRepository.findById(2).getProductName()).isEqualTo(insert.getProductName());
    }

    @Test
    void update() {
        Product p = Product.builder().quantity(100).build();
        Product updated = productRepository.update(1, p);
        assertThat(productRepository.findById(1).getQuantity()).isEqualTo(100);

    }

    @Test
    void delete() {
        Product deleted = productRepository.delete(1);
        assertThat(deleted.getProductName()).isEqualTo("제품명1");
        assertThat(productRepository.findById(1)).isEqualTo(null);
    }

}