package com.grupo8.app.galaxygames.controller;


import java.io.IOException;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.grupo8.app.galaxygames.model.Product;
import com.grupo8.app.galaxygames.model.User;
import com.grupo8.app.galaxygames.service.ProductService;
import com.grupo8.app.galaxygames.service.UploadFileService;


@Controller
@RequestMapping("/product")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private UploadFileService upload;

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
    public String save(Product product, @RequestParam("img") MultipartFile file) throws IOException{
        LOGGER.info("Este es el objeto producto: {}", product);
        User user = new User(1,"","","","","","", "");
        product.setUser(user);
        //imagen
        if(product.getId() == null){ //Cuando se crea el producto
            String imageName = upload.saveImage(file);
            product.setImage(imageName);
        } else {
           
        }

        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Product product = new Product();
        Optional<Product> optionalProduct = productService.get(id);
        product = optionalProduct.get();

        LOGGER.info("Producto buscado: {}", product);
        model.addAttribute("product", product);

        return "products/edit";
    }

    @PostMapping("/update")
    public String update(Product product,  @RequestParam("img") MultipartFile file) throws IOException{

        Product p = new Product();
        p = productService.get(product.getId()).get();

        if(file.isEmpty()){ //Cuando se edita el producto y no se cambia la imagen

            product.setImage(p.getImage());
        } else{ //Cuando se edita la imagen
    
            //Eliminar cuando no sea la imagen por defecto
            if(!p.getImage().equals("default.jpg")){
                upload.deleteImage(p.getImage());
            }

            String imageName = upload.saveImage(file);
            product.setImage(imageName); //Cuando se edita el producto y se cambia la imagen    
        }
        product.setUser(p.getUser());
        productService.update(product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){

        Product p = new Product();
        p = productService.get(id).get();

        //Eliminar cuando no sea la imagen por defecto
        if(!p.getImage().equals("default.jpg")){
            upload.deleteImage(p.getImage());
        }

        productService.delete(id);
        return "redirect:/product";
    }

}
