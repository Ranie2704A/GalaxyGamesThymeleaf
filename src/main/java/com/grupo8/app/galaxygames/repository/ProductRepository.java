package com.grupo8.app.galaxygames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo8.app.galaxygames.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

    

}
