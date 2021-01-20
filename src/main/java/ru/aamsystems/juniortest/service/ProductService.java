package ru.aamsystems.juniortest.service;

import ru.aamsystems.juniortest.model.entity.Product;

import java.util.List;

public interface ProductService {
    void delete(Long id);
    void save(Product p);
    Product getProductById(Long id);
    List<Product> getProductByName(String name);
    void updateProduct(Product p);
    List<Product> getAllProducts();
}
