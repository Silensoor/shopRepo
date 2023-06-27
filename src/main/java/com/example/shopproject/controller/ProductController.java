package com.example.shopproject.controller;

import com.example.shopproject.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private List<Product> products = new ArrayList<>();

        @GetMapping("/products")
    public String showProductList(Model model) {
        model.addAttribute("products", products);
            System.out.println("HI");
        return "";
    }


    @PostMapping("/products/create")
    public String createProduct(@RequestParam String name, @RequestParam double price) {
        int id = products.size() + 1;
        Product product = new Product(id, name, price);
        products.add(product);
        return "redirect:/products";
    }


    @PostMapping("/products/edit/{id}")
    public String editProduct(@PathVariable int id, @RequestParam String name, @RequestParam double price) {
        Product product = findProductById(id);
        if (product != null) {
            product.setName(name);
            product.setPrice(price);
        }
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        Product product = findProductById(id);
        if (product != null) {
            products.remove(product);
        }
        return "redirect:/products";
    }

    private Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}