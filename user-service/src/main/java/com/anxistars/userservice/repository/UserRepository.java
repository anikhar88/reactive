package com.anxistars.userservice.repository;

import com.anxistars.userservice.entity.User;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
    
    @Modifying
    @Query(
            " update users  SET" +
            " balance = balance - :amount " +
            " where id  = :userId " + 
            " and balance >= :amount "
    )
    public Mono<Boolean> updateUserBalance(Integer userId, Integer amount);

}
