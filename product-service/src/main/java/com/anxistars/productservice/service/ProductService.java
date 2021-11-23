package com.anxistars.productservice.service;

import com.anxistars.productservice.dto.ProductDTO;
import com.anxistars.productservice.repository.ProductRepository;
import com.anxistars.productservice.util.EntityDtoUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Sinks.Many<ProductDTO> sink;

    public Flux<ProductDTO> getAll() {
        return productRepository.findAll().map(EntityDtoUtil::toDto);
    }

    public Mono<ProductDTO> getProductById(final String id) {
        return productRepository.findById(id).map(EntityDtoUtil::toDto);
    }

    public Mono<ProductDTO> insertProduct(Mono<ProductDTO> productDtoMono) {

        return productDtoMono.map(EntityDtoUtil::toEntity)
                    .flatMap(this.productRepository::insert)
                    .map(EntityDtoUtil::toDto)
                    .doOnNext(this.sink::tryEmitNext);

    }

    public Mono<ProductDTO> updateProduct(String id, Mono<ProductDTO> productDtoMono) {
        return this.productRepository.findById(id)
                .flatMap(product -> productDtoMono.map(EntityDtoUtil::toEntity).doOnNext(entity -> entity.setId(id)))
                .flatMap(this.productRepository::save).map(EntityDtoUtil::toDto);

    }

    public Mono<Void> deleteProduct(String id) {
        return this.productRepository.deleteById(id);
    }

    public Flux<ProductDTO> getAllProductsByPriceRange(Integer min, Integer max) {

        return this.productRepository.findAll()
                                    .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                                    .map(EntityDtoUtil::toDto);
    }

    public Flux<ProductDTO> getProductsByPriceRange(Integer min, Integer max) {
        return this.productRepository.findByPriceBetween(Range.closed(min, max))
                                    .map(EntityDtoUtil::toDto);

    }

}
