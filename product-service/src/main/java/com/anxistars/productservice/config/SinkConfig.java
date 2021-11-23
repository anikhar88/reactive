package com.anxistars.productservice.config;

import com.anxistars.productservice.dto.ProductDTO;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class SinkConfig {
    
    @Bean
    public Sinks.Many<ProductDTO> sink() {
      return  Sinks.many().replay().limit(1);
    }

    public Flux<ProductDTO> productBroadcast(Sinks.Many<ProductDTO> sink) {
        return sink.asFlux();
    }

}
