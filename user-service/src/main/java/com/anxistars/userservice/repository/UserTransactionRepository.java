package com.anxistars.userservice.repository;

import com.anxistars.userservice.entity.UserTransaction;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface UserTransactionRepository extends ReactiveCrudRepository<UserTransaction, Integer> {
    
    Flux<UserTransaction> findByUserId(int userId);
    
}
