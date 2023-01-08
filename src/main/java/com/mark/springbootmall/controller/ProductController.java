package com.mark.springbootmall.controller;


import com.mark.springbootmall.dto.ProductRequest;
import com.mark.springbootmall.model.Product;
import com.mark.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
         Product product = productService.getProductById(productId);
         if(product != null){
             return ResponseEntity.status(HttpStatus.OK).body(product);
         }else{
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
    }


    @PostMapping("/products")
    public ResponseEntity<Product> greatProduct(@RequestBody @Valid ProductRequest productRequest){
      Integer producId =   productService.createProduct(productRequest);

        Product product = productService.getProductById(producId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
