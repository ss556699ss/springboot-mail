package com.mark.springbootmall.service;

import com.mark.springbootmall.model.Product;
import org.springframework.stereotype.Component;

@Component
public interface ProductService {

    Product getProductById(Integer productId);

}
