package com.mark.springbootmall.dao;

import com.mark.springbootmall.constant.ProductCategory;
import com.mark.springbootmall.dto.ProductQueryParams;
import com.mark.springbootmall.dto.ProductRequest;
import com.mark.springbootmall.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);

    List<Product> getProducts(ProductQueryParams productQueryParams);
}
