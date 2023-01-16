package com.mark.springbootmall.controller;


import com.mark.springbootmall.constant.ProductCategory;
import com.mark.springbootmall.dto.ProductQueryParams;
import com.mark.springbootmall.dto.ProductRequest;
import com.mark.springbootmall.model.Product;
import com.mark.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search
            ){

        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);

        List<Product> productList = productService.getProducts(productQueryParams);
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }


    //查詢
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
         Product product = productService.getProductById(productId);
         if(product != null){
             return ResponseEntity.status(HttpStatus.OK).body(product);
         }else{
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
    }

    //新增
    @PostMapping("/products")
    public ResponseEntity<Product> greatProduct(@RequestBody @Valid ProductRequest productRequest){
      Integer productId =   productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    //修改
    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest){
        //檢查 product是否存在
        Product product = productService.getProductById(productId);

        if(product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        //修改商品數據
        productService.updateProduct(productId,productRequest);
        Product updateproduct = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.OK).body(updateproduct);
    }

    //刪除
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){

        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
