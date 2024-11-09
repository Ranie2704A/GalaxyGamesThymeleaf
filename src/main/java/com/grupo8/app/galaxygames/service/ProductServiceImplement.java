package com.grupo8.app.galaxygames.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo8.app.galaxygames.model.Product;
import com.grupo8.app.galaxygames.repository.ProductRepository;

@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> get(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }

    @Override
    public void update(Product product) {

        productRepository.save(product);

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    
}
