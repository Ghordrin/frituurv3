package com.royalgreys.frituurv3.controller;

import com.royalgreys.frituurv3.model.Product;
import com.royalgreys.frituurv3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping(value ="/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/all")
    public @ResponseBody Iterable<Product> getProducts(){
        return productRepository.findAll();
    }

    @GetMapping(value ="/{id}")
    public @ResponseBody Optional<Product> getProductById(@PathVariable("id") int id){
        return productRepository.findById(id);
    }

}
