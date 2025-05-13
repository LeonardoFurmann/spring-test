package com.teste.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.spring.model.Product;
import com.teste.spring.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> getAllProducts() throws Exception{
         try{
             List<Product> listProducts = repository.findAll();
             return listProducts;
         } catch (Exception e ){
            throw new Exception("Erro ao listar os produtos. " + e.getMessage());
         }
    }

    public void postProduct(Product product) throws Exception {
       try{
            repository.save(product);
         } catch (Exception e ){
            throw new Exception("Erro ao cadastrar um produto " + e.getMessage());
         }
    }
    
}
