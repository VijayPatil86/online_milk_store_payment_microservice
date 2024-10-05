package com.online_milk_store.payment_microservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online_milk_store.payment_microservice.bean.PaymentDetails;

@CrossOrigin
@RestController
@RequestMapping("/payment-service/payment")
public class PaymentController {

	static final private Logger LOGGER = LogManager.getLogger(PaymentController.class);

	@PostMapping
	public ResponseEntity<Void> processPayment(@RequestBody PaymentDetails paymentDetails) {
		LOGGER.debug("PaymentController.processPayment() --- START");
		LOGGER.info("PaymentController.processPayment() --- paymentDetails: " + paymentDetails);
		LOGGER.debug("PaymentController.processPayment() --- END");
		return null;
	}
}
