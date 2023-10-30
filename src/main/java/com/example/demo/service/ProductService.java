package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.ProductDto;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts;
    }

    public Product getProduct(int productId) {
        Product product = productRepository.findById(productId);
        return product;
    }

    public String addProduct(Product product) {
        String message = "";
        Product inserted = productRepository.insert(product);
        if (inserted == null)
            message = "새로운 제품 추가 성공";
        else
            message = "새로운 제품 추가 실패";
        return message;
    }
    public String updateProduct(int productId, ProductDto productDto) {
        String message = "";
        Product product = productRepository.findById(productId);
        product.setQuantity(productDto.getQuantity());
        Product updated = productRepository.update(productId, product);
        if (updated != null)
            message = "제품 수정 성공";
        else
            message = "제품 수정 실패";
        return message;
    }

    public String deleteProduct(int productId) {
        String message = "";
        Product deleted = productRepository.delete(productId);
        if (deleted != null)
            message = "제품 삭제 성공";
        else
            message = "제품 삭제 실패";
        return message;
    }
}
