package com.BasicEcommerceApi.Request;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity;
}
