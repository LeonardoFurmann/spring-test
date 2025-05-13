package com.teste.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.teste.spring.model.Product;
import com.teste.spring.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;
    
    @GetMapping
    public ResponseEntity getAllProducts(){
        try{
             List<Product> listProducts = service.getAllProducts();
             return ResponseEntity.status(HttpStatus.OK).body(listProducts);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity postProduct(@RequestBody Product product){
        try{
             service.postProduct(product);
             return ResponseEntity.status(HttpStatus.OK).body("Cadastro realizado com sucesso");
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
