package com.online_milk_store.payment_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_milk_store.payment_microservice.entity.UPIPaymentTransactionEntity;

public interface PaymentTransactionRepository extends JpaRepository<UPIPaymentTransactionEntity, Integer> {

}
