package com.anxistars.userservice.util;

import java.time.LocalDateTime;

import com.anxistars.userservice.dto.TransactionRequestDto;
import com.anxistars.userservice.dto.TransactionResponseDto;
import com.anxistars.userservice.dto.TransactionStatus;
import com.anxistars.userservice.dto.UserDto;
import com.anxistars.userservice.entity.User;
import com.anxistars.userservice.entity.UserTransaction;

import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

    public static UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    public static User toEntity(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }

    public static UserTransaction toEntity(TransactionRequestDto transactionRequestDto) {
        
        UserTransaction userTransaction = new UserTransaction();
        
        userTransaction.setUserId(transactionRequestDto.getUserId());
        userTransaction.setAmount(transactionRequestDto.getAmount());
        userTransaction.setTransactionDate(LocalDateTime.now());

        return userTransaction;
    }

    public static TransactionResponseDto toDto(TransactionRequestDto transactionRequestDto,
                                                 TransactionStatus transactionStatus) {
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto();

        transactionResponseDto.setUserId(transactionRequestDto.getUserId());
        transactionResponseDto.setAmount(transactionRequestDto.getAmount());
        transactionResponseDto.setTransactionStatus(transactionStatus);
        return transactionResponseDto;
    }

}
