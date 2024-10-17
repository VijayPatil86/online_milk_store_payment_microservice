package com.online_milk_store.payment_microservice.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @ToString
public class UPIPaymentTransactionBean {
	private String orderNumber;
	private String upiAddress;
	private String upiPaymentMethod;
	private float upiPaymentAmount;
	private String upiPaymentStatus;
	private String upiPaymentRemark;
}
