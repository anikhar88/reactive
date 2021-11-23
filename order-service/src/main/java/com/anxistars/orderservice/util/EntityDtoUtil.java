package com.anxistars.orderservice.util;

import com.anxistars.orderservice.dto.OrderStatus;
import com.anxistars.orderservice.dto.PurchaseOrderResponseDto;
import com.anxistars.orderservice.dto.RequestContext;
import com.anxistars.orderservice.dto.TransactionRequestDto;
import com.anxistars.orderservice.dto.TransactionStatus;
import com.anxistars.orderservice.entity.PurchaseOrder;

import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {
    public static void setTransactionRequestDto(RequestContext requestContext) {
        TransactionRequestDto dto = new TransactionRequestDto();
        dto.setUserId(requestContext.getPurchaseOrderRequestDto().getUserId());
        dto.setAmount(requestContext.getProductDto().getPrice());
        requestContext.setTransactionRequestDto(dto);
    }

    public static PurchaseOrder getPurchaseOrder(RequestContext requestContext) {
        PurchaseOrder po = new PurchaseOrder();
        po.setUserId(requestContext.getPurchaseOrderRequestDto().getUserId());
        po.setProductId(requestContext.getPurchaseOrderRequestDto().getProductId());
        po.setAmount(requestContext.getProductDto().getPrice());

        TransactionStatus transactionStatus = requestContext.getTransactionResponseDto().getTransactionStatus();
        OrderStatus orderStatus = TransactionStatus.APPROVED.equals(transactionStatus) ? OrderStatus.COMPLETED
                : OrderStatus.FAILED;

        po.setOrderStatus(orderStatus);

        return po;
    }

    public static PurchaseOrderResponseDto getPurchaseOrderResponseDto(PurchaseOrder purchaseOrder) {
        PurchaseOrderResponseDto responseDtoDto = new PurchaseOrderResponseDto();
        BeanUtils.copyProperties(purchaseOrder, responseDtoDto);
        responseDtoDto.setOrderId(purchaseOrder.getId());
        return responseDtoDto;
    }
}
