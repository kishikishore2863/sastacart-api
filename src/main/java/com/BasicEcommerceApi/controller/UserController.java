package com.BasicEcommerceApi.controller;

import com.BasicEcommerceApi.model.Product;
import com.BasicEcommerceApi.model.User;
import com.BasicEcommerceApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<User> getProfileInfo() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getProfileInfo(email);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(userService.getAllProduct());
    }
}