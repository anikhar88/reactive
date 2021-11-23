package com.anxistars.userservice.service;

import com.anxistars.userservice.dto.TransactionRequestDto;
import com.anxistars.userservice.dto.TransactionResponseDto;
import com.anxistars.userservice.dto.TransactionStatus;
import com.anxistars.userservice.entity.UserTransaction;
import com.anxistars.userservice.repository.UserRepository;
import com.anxistars.userservice.repository.UserTransactionRepository;
import com.anxistars.userservice.util.EntityDtoUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTransactionRepository userTransactionRepository;

    public Mono<TransactionResponseDto> createTransaction(final TransactionRequestDto transactionRequestDto) {
        return this.userRepository
                .updateUserBalance(transactionRequestDto.getUserId(), transactionRequestDto.getAmount())
                .filter(Boolean::booleanValue).map(b -> EntityDtoUtil.toEntity(transactionRequestDto))
                .flatMap(this.userTransactionRepository::save)
                .map(ut -> EntityDtoUtil.toDto(transactionRequestDto, TransactionStatus.APPROVED))
                .defaultIfEmpty(EntityDtoUtil.toDto(transactionRequestDto, TransactionStatus.DECLIEND));
    }

    public Flux<UserTransaction> getByUserId(int userId) {
        return this.userTransactionRepository.findByUserId(userId);
    }

}
