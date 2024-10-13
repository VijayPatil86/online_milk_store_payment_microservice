package com.online_milk_store.payment_microservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_milk_store.payment_microservice.entity.UPIDetailsEntity;

public interface UPIDetailRepository extends JpaRepository<UPIDetailsEntity, Integer> {
	Optional<UPIDetailsEntity> findByUpiId(String upiId);
}
