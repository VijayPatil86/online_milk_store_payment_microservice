package com.online_milk_store.payment_microservice.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class PaymentDetails {
	private double amount;
	PaymentMethod paymentMethod;

	@Override
	public String toString() {
		return "PaymentDetails [amount=" + amount + ", paymentMethod=" + paymentMethod + "]";
	}
}
