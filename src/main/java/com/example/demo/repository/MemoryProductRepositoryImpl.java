package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryProductRepositoryImpl implements ProductRepository{

    private static Map<Integer, Product> productMap = new HashMap<>();
    private static int seq = 0;

    public MemoryProductRepositoryImpl() {
        seq ++;
        Product product = Product.builder()
                        .productId(seq)
                        .productName("제품명1")
                        .maker("오리")
                        .price(10000)
                        .quantity(10)
                        .build();
        productMap.put(seq, product);
        seq ++;
        Product product2 = Product.builder()
                .productId(seq)
                .productName("제품명2")
                .maker("오리")
                .price(20000)
                .quantity(20)
                .build();

        productMap.put(seq, product2);

    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(int productId) {
        return productMap.get(productId);
    }

    @Override
    public Product insert(Product product) {
        product.setProductId(seq);
        Product put = productMap.put(++seq, product);
        return put ;
    }

    @Override
    public Product update(int productId, Product product) {
        Product toBeUpdated = productMap.get(productId);
        if (toBeUpdated != null) {
            toBeUpdated.setQuantity(product.getQuantity());
            productMap.put(productId, toBeUpdated);
        }

        return toBeUpdated;
    }

    @Override
    public Product delete(int productId) {
        Product toBeDeleted = productMap.get(productId);
        productMap.remove(productId);
        return toBeDeleted;
    }
}
