package com.anxistars.orderservice.controller;

import com.anxistars.orderservice.dto.PurchaseOrderRequestDto;
import com.anxistars.orderservice.dto.PurchaseOrderResponseDto;
import com.anxistars.orderservice.service.OrderFulfillmentService;
import com.anxistars.orderservice.service.OrderQueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/order")
public class PurchaseOrderController {

    @Autowired
    private OrderQueryService queryService;

    @Autowired
    private OrderFulfillmentService orderFulfillmentService;

    @PostMapping
    public Mono<ResponseEntity<PurchaseOrderResponseDto>> order(@RequestBody Mono<PurchaseOrderRequestDto> requestDtoMono) {

        return this.orderFulfillmentService.processOrder(requestDtoMono)
                    .map(ResponseEntity::ok)
                    .onErrorReturn(WebClientResponseException.class, ResponseEntity.badRequest().build())
                    .onErrorReturn(WebClientRequestException.class, ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build());
    }

    @GetMapping("/user/{userId}")
    public Flux<PurchaseOrderResponseDto> getOrderByUserId(@PathVariable Integer userId) {
        return this.queryService.getProductByUserId(userId);
    }
}
