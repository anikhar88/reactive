package com.anxistars.orderservice.dto;

public class RequestContext {

    private PurchaseOrderRequestDto purchaseOrderRequestDto;

    private PurchaseOrderResponseDto purchaseOrderResponseDto;

    private ProductDto productDto;

    private TransactionRequestDto transactionRequestDto;

    private TransactionResponseDto transactionResponseDto;

    public RequestContext(PurchaseOrderRequestDto purchaseOrderRequestDto) {
        this.purchaseOrderRequestDto = purchaseOrderRequestDto;
    }

    public PurchaseOrderRequestDto getPurchaseOrderRequestDto() {
        return purchaseOrderRequestDto;
    }

    public void setPurchaseOrderRequestDto(PurchaseOrderRequestDto purchaseOrderRequestDto) {
        this.purchaseOrderRequestDto = purchaseOrderRequestDto;
    }

    public PurchaseOrderResponseDto getPurchaseOrderResponseDto() {
        return purchaseOrderResponseDto;
    }

    public void setPurchaseOrderResponseDto(PurchaseOrderResponseDto purchaseOrderResponseDto) {
        this.purchaseOrderResponseDto = purchaseOrderResponseDto;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public TransactionRequestDto getTransactionRequestDto() {
        return transactionRequestDto;
    }

    public void setTransactionRequestDto(TransactionRequestDto transactionRequestDto) {
        this.transactionRequestDto = transactionRequestDto;
    }

    public TransactionResponseDto getTransactionResponseDto() {
        return transactionResponseDto;
    }

    public void setTransactionResponseDto(TransactionResponseDto transactionResponseDto) {
        this.transactionResponseDto = transactionResponseDto;
    }

}
