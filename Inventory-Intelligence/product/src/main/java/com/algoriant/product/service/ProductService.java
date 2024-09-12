package com.algoriant.product.service;

import com.algoriant.product.model.Product;
import com.algoriant.product.model.ProductRequest;
import com.algoriant.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product createProducts(ProductRequest request) {
        repository.insertProduct(request.getProductId(),request.getProductName(),request.getCategory(),request.getDescription(),request.getPrice());
        return Product.toEntity(request);
    }

    public List<Product> getAllProducts() {
        return repository.getAllProducts();
    }

    public Product getProductById(BigInteger productId) {
        return repository.getProductById(productId);
    }

    public void deleteProductById(BigInteger productId) {
        repository.deleteProductById(productId);
    }
    public void updateProduct(BigInteger productId,String productName, String description, BigDecimal price, String category) {
        repository.updateProduct(productId,productName, description, price, category);
    }


}
