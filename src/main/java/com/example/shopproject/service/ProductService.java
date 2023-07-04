package com.example.shopproject.service;

import com.example.shopproject.dto.request.ChangeRq;
import com.example.shopproject.dto.request.ProductRq;
import com.example.shopproject.dto.request.ProductRs;
import com.example.shopproject.model.Product;

import java.util.List;

public interface ProductService {
    void addProduct(ProductRq productRq);
    List<Product> getAllProducts();

    void deleteProduct(Integer id);
    void productChangeCategory(ChangeRq changeRq);
    List<ProductRs> getAllProductsRs();
}
