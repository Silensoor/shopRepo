package com.example.shopproject.controller;

import com.example.shopproject.dto.request.ProductRq;
import com.example.shopproject.model.Product;
import com.example.shopproject.service.Impl.ProductServiceImpl;
import com.example.shopproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public String showProductList(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @PostMapping("/products/create")
    public String createProduct(ProductRq productRq) {
        productService.addProduct(productRq);
        return "redirect:/products";
    }


    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
       productService.deleteProduct(id);
        return "redirect:/products";
    }

}