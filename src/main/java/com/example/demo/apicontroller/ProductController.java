package com.example.demo.apicontroller;

import com.example.demo.model.Product;
import com.example.demo.model.ProductDto;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable("productId") int productId) {
        return productService.getProduct(productId);
    }

    @PostMapping
    public String addProduct(@RequestBody Product product) {
        String s = productService.addProduct(product);
        return s;
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable int productId, @RequestBody ProductDto productDto) {
        String s = productService.updateProduct(productId, productDto);
        return s;
    }

    @DeleteMapping("{productId}")
    public String deleteProduct(@PathVariable int productId) {
        String s = productService.deleteProduct(productId);
        return s;
    }

}
