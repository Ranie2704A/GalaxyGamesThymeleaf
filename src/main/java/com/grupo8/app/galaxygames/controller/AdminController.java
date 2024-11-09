package com.grupo8.app.galaxygames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo8.app.galaxygames.model.Product;
import com.grupo8.app.galaxygames.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String home(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "admin/home";
    }



}
