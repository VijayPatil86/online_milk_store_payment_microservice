package com.online_milk_store.payment_microservice.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class UPIPaymentMethod extends PaymentMethod {
	private String upiID;
	String paymentDescription;

	@Override
	public String toString() {
		return "UPIPaymentMethod [upiID=" + upiID + ", paymentDescription=" + paymentDescription + "]";
	}
}
