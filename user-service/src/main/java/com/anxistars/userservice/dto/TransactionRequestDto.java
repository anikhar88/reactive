package com.anxistars.userservice.dto;

public class TransactionRequestDto {
    
    private Integer userId;
    private Integer amount;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionRequestDto [amount=" + amount + ", userId=" + userId + "]";
    }

    
}
