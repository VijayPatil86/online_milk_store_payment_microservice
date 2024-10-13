package com.online_milk_store.payment_microservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name = "UPI_DETAILS")
public class UPIDetailsEntity {
	@Column(name = "UPI_RECORD_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int upiRecordId;

	@Column(name = "UPI_ID")
	private String upiId;
}
