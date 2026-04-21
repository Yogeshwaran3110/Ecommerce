package com.ecommerce.product_service.controller;

import com.ecommerce.product_service.entity.Product;
import com.ecommerce.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public void createProduct(@RequestBody Product product){
        productService.save(product);
    }

    @GetMapping("/getAllProduct")
    public List<Product> findAllProduct(){
        return productService.getAll();
    }

    @PutMapping("/updateProduct/{id}")
    public void updateProduct(@PathVariable Long id,@RequestBody Product product){
        productService.updateById(id,product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    //delete is for delete product
    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteById(id);
    }
}
