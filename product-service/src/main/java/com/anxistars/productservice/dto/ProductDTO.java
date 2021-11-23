package com.anxistars.productservice.dto;

public class ProductDTO {

    private String id;
    private String description;
    private Integer price;

    public ProductDTO(){}
    
    public ProductDTO(String descrioption, Integer price) {
        this.description = descrioption;
        this.price = price;
    }

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
        return "ProductDTO [description=" + description + ", id=" + id + ", price=" + price + "]";
    }

}
