package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.MemoryProductRepositoryImpl;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductServiceTest {

    ProductRepository productRepository = new MemoryProductRepositoryImpl();
    ProductService productService = new ProductService(productRepository);

    @Test
    void add() {
        Product product = Product.builder().productName("test1").maker("test").price(15000).quantity(100).build();
        String s = productService.addProduct(product);
        assertThat(s).isEqualTo("새로운 제품 추가 성공");
    }
}