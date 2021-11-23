package com.anxistars.orderservice.dto;

public class TransactionResponseDto {
    
    private Integer userId;
    private Integer amount;
    private TransactionStatus transactionStatus;

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
    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Override
    public String toString() {
        return "TransactionResponseDto [amount=" + amount + ", transactionStatus=" + transactionStatus + ", userId="
                + userId + "]";
    }
    
}
