package com.ecommerce.order_service.feign;

import com.ecommerce.order_service.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "product-service", url = "http://localhost:8082")
public interface ProductClient {

    @GetMapping("/products/{id}")
    ProductDTO getProduct(@PathVariable("id") Long id);

    @PutMapping("/products/{id}")
    ProductDTO updateProduct(@PathVariable("id") Long id, @RequestBody ProductDTO product);
}