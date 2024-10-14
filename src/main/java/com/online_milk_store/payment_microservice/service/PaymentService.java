package com.online_milk_store.payment_microservice.service;

import java.sql.Timestamp;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online_milk_store.payment_microservice.bean.UPIPaymentTransactionBean;
import com.online_milk_store.payment_microservice.entity.UPIDetailsEntity;
import com.online_milk_store.payment_microservice.entity.UPIPaymentTransactionEntity;
import com.online_milk_store.payment_microservice.repository.PaymentTransactionRepository;
import com.online_milk_store.payment_microservice.repository.UPIDetailRepository;

@Service
@Transactional
public class PaymentService {
	static final private Logger LOGGER = LogManager.getLogger(PaymentService.class);

	@Autowired
	private UPIDetailRepository upiDetailRepository;

	@Autowired
	private PaymentTransactionRepository paymentTransactionRepository;

	public void processUPIPayment(UPIPaymentTransactionBean upiPaymentTransactionBean) {
		LOGGER.debug("PaymentService.processUPIPayment() --- START");
		LOGGER.info("PaymentService.processUPIPayment() --- upiPaymentTransactionBean: " + upiPaymentTransactionBean);
		UPIDetailsEntity upiDetailsEntitySaved = getOrSaveUPIDetailsEntity(upiPaymentTransactionBean.getUpiId());
		savePayment(upiPaymentTransactionBean, upiDetailsEntitySaved);
		LOGGER.debug("PaymentService.processUPIPayment() --- END");
	}

	private void savePayment(UPIPaymentTransactionBean upiPaymentTransactionBean, UPIDetailsEntity upiDetailsEntitySaved) {
		LOGGER.debug("PaymentService.savePayment() --- START");
		UPIPaymentTransactionEntity upiPaymentTransactionEntity = UPIPaymentTransactionEntity.builder()
				.orderNumber(upiPaymentTransactionBean.getOrderNumber())
				.paymentMethod(upiPaymentTransactionBean.getUpiPaymentMethod())
				.paymentStatus(upiPaymentTransactionBean.getUpiPaymentStatus())
				.upiDetailsEntity(upiDetailsEntitySaved)
				.paymentAmount(upiPaymentTransactionBean.getUpiPaymentAmount())
				.upiPaymentRemark(upiPaymentTransactionBean.getUpiPaymentRemark())
				.createdAt(new Timestamp(System.currentTimeMillis()))
				.build();
		LOGGER.info("PaymentService.savePayment() --- before save - upiPaymentTransactionEntity: " + upiPaymentTransactionEntity);
		UPIPaymentTransactionEntity upiPaymentTransactionEntitySaved = paymentTransactionRepository.save(upiPaymentTransactionEntity);
		LOGGER.info("PaymentService.savePayment() --- after save - upiPaymentTransactionEntitySaved: " + upiPaymentTransactionEntitySaved);
		LOGGER.debug("PaymentService.savePayment() --- END");
	}

	private UPIDetailsEntity getOrSaveUPIDetailsEntity(String upiId) {
		LOGGER.debug("PaymentService.getOrSaveUPIDetailsEntity() --- START");
		Optional<UPIDetailsEntity> optionalUPIDetailsEntity = upiDetailRepository.findByUpiId(upiId);
		UPIDetailsEntity upiDetailsEntitySaved = optionalUPIDetailsEntity.orElseGet(() -> upiDetailRepository
				.save(UPIDetailsEntity.builder()
					.upiId(upiId)
					.build()));
		LOGGER.debug("PaymentService.getOrSaveUPIDetailsEntity() --- END");
		return upiDetailsEntitySaved;
	}
}
