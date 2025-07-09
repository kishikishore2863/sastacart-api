package com.BasicEcommerceApi.controller;

import com.BasicEcommerceApi.Request.ProductRequest;
import com.BasicEcommerceApi.model.Product;
import com.BasicEcommerceApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody ProductRequest productRequest){
        String result = productService.addProduct(productRequest);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Product>> getProd(){
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delProduct(@PathVariable("id") Long productId) {
        String result = productService.deleteProduct(productId);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") Long productId, @RequestBody Product updatedProduct) {
        String result = productService.updateProduct(productId, updatedProduct);
        return ResponseEntity.ok(result);
    }

}
