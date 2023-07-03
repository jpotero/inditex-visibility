package com.inditex.visibility.controller;

import com.inditex.visibility.ports.api.ProductServicePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private ProductServicePort productServicePort;

    @GetMapping("/get")
    public String getAllProducts() {
        return productServicePort.getProductIds();
    }
}
