package com.anxistars.productservice.controller;

import java.util.concurrent.ThreadLocalRandom;

import com.anxistars.productservice.dto.ProductDTO;
import com.anxistars.productservice.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public Flux<ProductDTO> getAllProduct(){
       return this.productService.getAll();
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<ProductDTO>> getProductById(@PathVariable String id){
        this.randomException();// simulating some randome error to handle such scenario
       return this.productService.getProductById(id)
                                .map(ResponseEntity::ok)
                                .defaultIfEmpty(ResponseEntity.notFound().build());
                            
    }

    @PostMapping
    public Mono<ProductDTO>  insertProduct(@RequestBody Mono<ProductDTO> productDtoMono) {
       return this.productService.insertProduct(productDtoMono);
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<ProductDTO>> updateProduct(@PathVariable String id, @RequestBody Mono<ProductDTO> prodDtoMono) {
        return this.productService.updateProduct(id, prodDtoMono)
                                .map(ResponseEntity::ok)
                                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteProduct(@PathVariable String id){
        return this.productService.deleteProduct(id);
    }

    @GetMapping("price-range")
    public Flux<ProductDTO> getProductsByRange(@RequestParam Integer min, @RequestParam Integer max) {
        return this.productService.getAllProductsByPriceRange(min, max);
    }

    @GetMapping("price-range2")
    public Flux<ProductDTO> getProductsByRange2(@RequestParam Integer min, @RequestParam Integer max) {
        return this.productService.getProductsByPriceRange(min, max);
    }

    public void randomException() {
        int nextInt = ThreadLocalRandom.current().nextInt(1, 10);
        if(nextInt > 5) {
            throw new RuntimeException("Something is wrong");
        }
    }

}
