package com.online_milk_store.payment_microservice.service;

import java.sql.Timestamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online_milk_store.payment_microservice.bean.UPIPaymentTransactionBean;
import com.online_milk_store.payment_microservice.bean.UpiPaymentInfoBean;
import com.online_milk_store.payment_microservice.entity.UPIPaymentTransactionEntity;
import com.online_milk_store.payment_microservice.repository.PaymentTransactionRepository;

@Service
@Transactional
public class PaymentService {
	static final private Logger LOGGER = LogManager.getLogger(PaymentService.class);

	@Autowired
	private PaymentTransactionRepository paymentTransactionRepository;

	public UpiPaymentInfoBean createUPIPaymentData(UPIPaymentTransactionBean upiPaymentTransactionBean) {
		LOGGER.debug("PaymentService.processUPIPayment() --- START");
		LOGGER.info("PaymentService.processUPIPayment() --- upiPaymentTransactionBean: " + upiPaymentTransactionBean);
		UpiPaymentInfoBean upiPaymentInfoBean = savePayment(upiPaymentTransactionBean, upiPaymentTransactionBean.getUpiAddress());
		LOGGER.debug("PaymentService.processUPIPayment() --- END");
		return upiPaymentInfoBean;
	}

	private UpiPaymentInfoBean savePayment(UPIPaymentTransactionBean upiPaymentTransactionBean, String upiAddress) {
		LOGGER.debug("PaymentService.savePayment() --- START");
		UPIPaymentTransactionEntity upiPaymentTransactionEntity = UPIPaymentTransactionEntity.builder()
				.orderNumber(upiPaymentTransactionBean.getOrderNumber())
				.paymentMethod(upiPaymentTransactionBean.getUpiPaymentMethod())
				.paymentStatus(upiPaymentTransactionBean.getUpiPaymentStatus())
				.upiAddress(upiAddress)
				.paymentAmount(upiPaymentTransactionBean.getUpiPaymentAmount())
				.upiPaymentRemark(upiPaymentTransactionBean.getUpiPaymentRemark())
				.createdAt(new Timestamp(System.currentTimeMillis()))
				.build();
		LOGGER.info("PaymentService.savePayment() --- before save - upiPaymentTransactionEntity: " + upiPaymentTransactionEntity);
		UPIPaymentTransactionEntity upiPaymentTransactionEntitySaved = paymentTransactionRepository.save(upiPaymentTransactionEntity);
		LOGGER.info("PaymentService.savePayment() --- after save - upiPaymentTransactionEntitySaved: " + upiPaymentTransactionEntitySaved);
		UpiPaymentInfoBean upiPaymentInfoBean = UpiPaymentInfoBean.builder()
				.upiAddress(upiPaymentTransactionEntitySaved.getUpiAddress())
				.amount(upiPaymentTransactionBean.getUpiPaymentAmount())
				.payerTransactionTimestamp(upiPaymentTransactionEntitySaved.getCreatedAt().toString())
				.payerTransactionId(upiPaymentTransactionEntity.getTransactionId())
				.build();
		LOGGER.debug("PaymentService.savePayment() --- END");
		return upiPaymentInfoBean;
	}
}
