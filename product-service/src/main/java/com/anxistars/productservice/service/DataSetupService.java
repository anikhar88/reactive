package com.anxistars.productservice.service;

import com.anxistars.productservice.dto.ProductDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class DataSetupService implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {
       ProductDTO p1 = new ProductDTO("Mobile", 10000);
       ProductDTO p2 = new ProductDTO("Laptop", 50000);
       ProductDTO p3 = new ProductDTO("Watch", 5000);

       Flux.just(p1,p2,p3)
            .flatMap( p -> this.productService.insertProduct(Mono.just(p)))
            .subscribe(System.out::println);


        
    }

    
    
}
