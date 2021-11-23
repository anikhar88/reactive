package com.anxistars.orderservice.service;

import java.time.Duration;

import com.anxistars.orderservice.client.ProductClient;
import com.anxistars.orderservice.client.UserClient;
import com.anxistars.orderservice.dto.PurchaseOrderRequestDto;
import com.anxistars.orderservice.dto.PurchaseOrderResponseDto;
import com.anxistars.orderservice.dto.RequestContext;
import com.anxistars.orderservice.repository.PurchaseOrderRepository;
import com.anxistars.orderservice.util.EntityDtoUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.retry.Retry;

@Service
public class OrderFulfillmentService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private UserClient userClientl;

    public Mono<PurchaseOrderResponseDto> processOrder(Mono<PurchaseOrderRequestDto> requestDto) {

       return requestDto.map(RequestContext::new)
                    .flatMap(this::productRequestResponse)
                    .doOnNext(EntityDtoUtil::setTransactionRequestDto)
                    .flatMap(this::userRequestResponse)
                    .map(EntityDtoUtil::getPurchaseOrder)
                    .map(this.purchaseOrderRepository::save)
                    .map(EntityDtoUtil::getPurchaseOrderResponseDto)
                    .subscribeOn(Schedulers.boundedElastic());

    }

    private Mono<RequestContext> productRequestResponse(RequestContext requestContext) {
      return  this.productClient.getProductById(requestContext.getPurchaseOrderRequestDto().getProductId())
                    .doOnNext(requestContext::setProductDto)
                    .retryWhen(Retry.fixedDelay(5, Duration.ofSeconds(1)))
                    .thenReturn(requestContext);
    }

    private Mono<RequestContext> userRequestResponse(RequestContext requestContext) {
       return this.userClientl.authorizeTransaction(requestContext.getTransactionRequestDto())
                    .doOnNext(requestContext::setTransactionResponseDto)
                    .thenReturn(requestContext);
    }

    
}
