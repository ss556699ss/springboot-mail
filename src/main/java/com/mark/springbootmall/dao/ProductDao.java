package com.mark.springbootmall.dao;

import com.mark.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
