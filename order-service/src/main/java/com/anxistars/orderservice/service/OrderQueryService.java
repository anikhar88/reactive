package com.anxistars.orderservice.service;

import com.anxistars.orderservice.dto.PurchaseOrderResponseDto;
import com.anxistars.orderservice.repository.PurchaseOrderRepository;
import com.anxistars.orderservice.util.EntityDtoUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
public class OrderQueryService {
    
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    public Flux<PurchaseOrderResponseDto> getProductByUserId(int userId){
    
       return Flux.fromStream(() -> this.purchaseOrderRepository.findByUserId(userId).stream())
        .map(EntityDtoUtil::getPurchaseOrderResponseDto)
        .subscribeOn(Schedulers.boundedElastic());
        
    }
}
