package com.mark.springbootmall.dao;

import com.mark.springbootmall.dto.ProductRequest;
import com.mark.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);
}
