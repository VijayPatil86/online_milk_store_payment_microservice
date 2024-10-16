package com.online_milk_store.payment_microservice.feign_client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.online_milk_store.payment_microservice.bean.UpiPaymentInfoBean;

@FeignClient(name = "upi-npcl-service", url = "http://localhost:9051/upi")
public interface UpiNPCLServiceClient {
	@PostMapping("/payment-request")
	ResponseEntity<Void> requestPaymentUpiNPCL(@RequestBody UpiPaymentInfoBean upiPaymentInfoBean);
}
