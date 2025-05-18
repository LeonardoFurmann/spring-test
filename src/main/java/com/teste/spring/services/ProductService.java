package com.teste.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.spring.exceptions.RequiredException;
import com.teste.spring.exceptions.NotFoundException;
import com.teste.spring.model.Product;
import com.teste.spring.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> getAllProducts(){
         List<Product> listProducts = repository.findAll();
         if (listProducts == null || listProducts.isEmpty()) {
             throw new NotFoundException();
         } 
         return listProducts;
    }

    public void postProduct(Product product) {
      if (product.getName() == null || product.getName().isEmpty()) {
         throw new RequiredException("name");
      }
      repository.save(product);
   }
}
