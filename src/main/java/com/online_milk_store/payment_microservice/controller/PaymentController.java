package com.online_milk_store.payment_microservice.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online_milk_store.payment_microservice.bean.UPIPaymentTransactionBean;
import com.online_milk_store.payment_microservice.service.PaymentService;

@RestController
@RequestMapping(path = "/payment-service")
public class PaymentController {

	static final private Logger LOGGER = LogManager.getLogger(PaymentController.class);

	@Autowired
	private PaymentService paymentService;

	@PostMapping(path = "/upi-payment")
	public ResponseEntity<Void> processUPIPayment(@RequestBody UPIPaymentTransactionBean upiPaymentTransactionBean) {
		LOGGER.debug("PaymentController.processUPIPayment() --- START");
		LOGGER.info("PaymentController.processUPIPayment() --- upiPaymentTransactionBean: " + upiPaymentTransactionBean);
		paymentService.processUPIPayment(upiPaymentTransactionBean);
		LOGGER.debug("PaymentController.processUPIPayment() --- END");
		return null;
	}
}
