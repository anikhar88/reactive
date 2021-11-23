package com.anxistars.orderservice.repository;

import java.util.List;

import com.anxistars.orderservice.entity.PurchaseOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {

    List<PurchaseOrder> findByUserId(int userId);

}
