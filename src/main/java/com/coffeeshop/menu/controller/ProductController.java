package com.coffeeshop.menu.controller;

import com.coffeeshop.menu.model.*;
import com.coffeeshop.menu.service.ProductService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/") 
    public String viewHomePage(Model model) {
        model.addAttribute("listProducts", productService.getAllProducts());
        return "menu";  // Thymeleaf template
    }

    @GetMapping("/list") 
    public String listProducts(Model model) {
        model.addAttribute("listProducts", productService.getAllProducts());
        return "menu";
    }

    /*
    @GetMapping("/details/{id}")
    @ResponseBody
    public String getProductDetailsByID(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(product -> "<strong>Requested Product Details: </strong> <hr> Product ID: " 
                        + product.getId() + "<br> Name: " + product.getName() + "<br> Price: $" + product.getPrice())
                .orElse("Product not found!");
    }*/

    @GetMapping("/add")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-new-product";
    }

    @PostMapping("/addNewProduct")
    public String addProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products/list";
    }
}