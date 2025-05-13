package com.teste.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.spring.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {}
