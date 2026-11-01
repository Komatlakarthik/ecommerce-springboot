package com.ecommerce.shopzone.controller;

import com.ecommerce.shopzone.entity.Product;
import com.ecommerce.shopzone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String listProducts(@RequestParam(required = false) String search,
                               @RequestParam(required = false) String category,
                               Model model) {
        if (search != null && !search.isEmpty()) {
            model.addAttribute("products", productService.searchProducts(search));
            model.addAttribute("search", search);
        } else if (category != null && !category.isEmpty()) {
            model.addAttribute("products", productService.getProductsByCategory(category));
            model.addAttribute("category", category);
        } else {
            model.addAttribute("products", productService.getAllActiveProducts());
        }
        return "products";
    }

    @GetMapping("/{id}")
    public String productDetail(@PathVariable Long id, Model model) {
        productService.getProductById(id).ifPresent(product -> model.addAttribute("product", product));
        return "product-detail";
    }
}
