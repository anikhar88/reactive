package com.anxistars.orderservice.dto;

public class PurchaseOrderResponseDto {
   
    private Integer orderId;
    private Integer userId;
    private String productId;
    private Integer amount;
    private OrderStatus orderStatus;

    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    @Override
    public String toString() {
        return "PurchaseOrderResponseDto [amount=" + amount + ", orderId=" + orderId + ", orderStatus=" + orderStatus
                + ", productId=" + productId + ", userId=" + userId + "]";
    }
   
}
