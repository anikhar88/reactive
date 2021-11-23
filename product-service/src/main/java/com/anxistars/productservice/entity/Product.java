package com.anxistars.productservice.entity;

import org.springframework.data.annotation.Id;

public class Product {

    @Id
    private String id;
    private String description;
    private Integer price;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product [description=" + description + ", id=" + id + ", price=" + price + "]";
    }

    
    
    
}
