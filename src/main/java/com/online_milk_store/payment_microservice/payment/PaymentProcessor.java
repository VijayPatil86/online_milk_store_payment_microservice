package com.online_milk_store.payment_microservice.payment;

import com.online_milk_store.payment_microservice.bean.PaymentDetails;

public interface PaymentProcessor {
	void processPayment(PaymentDetails paymentDetails);
}
