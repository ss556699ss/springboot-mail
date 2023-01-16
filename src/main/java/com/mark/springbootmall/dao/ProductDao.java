package com.mark.springbootmall.dao;

import com.mark.springbootmall.dto.ProductRequest;
import com.mark.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);

    List<Product> getProducts();
}
