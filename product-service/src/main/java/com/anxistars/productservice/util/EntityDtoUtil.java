package com.anxistars.productservice.util;

import com.anxistars.productservice.dto.ProductDTO;
import com.anxistars.productservice.entity.Product;

import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

    public static ProductDTO toDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    public static Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        return product;
    }

}
