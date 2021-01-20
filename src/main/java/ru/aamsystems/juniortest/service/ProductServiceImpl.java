package ru.aamsystems.juniortest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aamsystems.juniortest.model.entity.Product;
import ru.aamsystems.juniortest.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{


    private ProductRepository repository;


    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void updateProduct(Product p) {
        repository.save(p);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void save(Product p) {
        repository.save(p);
    }

    @Override
    public Product getProductById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<Product> getProductByName(String name) {
        return repository.findByName(name);
    }
}
