package com.example.shopproject.controller;

import com.example.shopproject.dto.request.CategoryRq;
import com.example.shopproject.dto.request.ChangeRq;
import com.example.shopproject.dto.request.ProductRq;
import com.example.shopproject.service.CategoryService;
import com.example.shopproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final CategoryService categoryService;
    private final ProductService productService;
    @GetMapping("/admin")
    public String pageAdmin(Model model){
        model.addAttribute("products",productService.getAllProductsRs());
        model.addAttribute("category",categoryService.getAllCategory());
        return "admin";
    }
    @PostMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
        return "redirect:/admin";
    }
    @PostMapping("/admin/product/delete/{id}")
    public String removeProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return "redirect:/admin";
    }
    @PostMapping("/admin/product/change")
    public String changeCategory(ChangeRq changeRq){
        productService.productChangeCategory(changeRq);
        return "redirect:/admin";
    }
    @PostMapping("/admin/product/add")
    public String createProduct(ProductRq productRq) {
        productService.addProduct(productRq);
        return "redirect:/admin";
    }
    @PostMapping("/admin/category/add")
    public String createCategory(CategoryRq categoryRq) {
        categoryService.addCategory(categoryRq);
        return "redirect:/admin";
    }
    @GetMapping("/admin/product/delete/{id}")
    public String removeProducts(@PathVariable int id){
        productService.deleteProduct(id);
        return "redirect:/admin";
    }
    @GetMapping("/category/delete/{id}")
    public String deleteCategories(@PathVariable int id){
        categoryService.deleteCategory(id);
        return "redirect:/admin";
    }
}
