package com.grupo8.app.galaxygames.controller;


import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo8.app.galaxygames.model.Product;
import com.grupo8.app.galaxygames.model.User;
import com.grupo8.app.galaxygames.service.ProductService;


@Controller
@RequestMapping("/product")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String show(org.springframework.ui.Model model){
        model.addAttribute("products", productService.findAll());
        return "products/show";
    }

    @GetMapping("/create")
    public String create(){
        return "products/create";
    }

    @PostMapping("/save")
    public String save(Product product){
        LOGGER.info("Este es el objeto producto: {}", product);
        User user = new User(1,"","","","","","", "");
        product.setUser(user);
        productService.save(product);
        return "redirect:/product";
    }

}
