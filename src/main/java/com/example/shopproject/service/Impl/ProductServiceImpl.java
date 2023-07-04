package com.example.shopproject.service.Impl;

import com.example.shopproject.dto.request.ChangeRq;
import com.example.shopproject.dto.request.ProductRq;
import com.example.shopproject.dto.request.ProductRs;
import com.example.shopproject.model.Category;
import com.example.shopproject.model.Product;
import com.example.shopproject.repository.CategoryRepository;
import com.example.shopproject.repository.ProductRepository;
import com.example.shopproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void addProduct(ProductRq productRq) {
        Product product = new Product();
        product.setName(productRq.getName());
        product.setPrice(productRq.getPrice());
        productRepository.saveAndFlush(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public void productChangeCategory(ChangeRq changeRq) {
        Product byId = productRepository.findProductById(changeRq.getId());
        if (byId != null) {
            Category category = categoryRepository.findCategoryById(changeRq.getCategoryId());
            if (category != null) {
                byId.setCategory(category);
                productRepository.saveAndFlush(byId);
            }
        }
    }

    @Override
    public List<ProductRs> getAllProductsRs() {
        List<ProductRs> productRs = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            ProductRs productRs1 = new ProductRs();
            productRs1.setId(product.getId());
            if (product.getCategory() != null) {
                productRs1.setCategory(product.getCategory().getId());
            }
            productRs1.setName(product.getName());
            productRs1.setPrice(product.getPrice());
            productRs.add(productRs1);
        }
        return productRs;
    }
}
