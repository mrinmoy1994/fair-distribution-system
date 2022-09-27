package com.mrinmoy.ninjacart;

import com.mrinmoy.ninjacart.model.PendingPayment;
import com.mrinmoy.ninjacart.service.PaymentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class NinjacartApplication {

	public static void main(String[] args) {
		SpringApplication.run(NinjacartApplication.class, args);

		List<PendingPayment> pendingPaymentList = new ArrayList<>();
		List<Double> paymentList = Stream.of(2d, 3d, 5d, 6d, 8d).collect(Collectors.toList());
		for(int i = 0; i < 100; i++){
			PendingPayment pendingPayment = new PendingPayment();
			pendingPayment.setAmount(1000d * (i+1));
			pendingPayment.setId(UUID.randomUUID().toString());
			pendingPayment.setType("LOAN");
			pendingPayment.setDueDate(LocalDate.now().plusDays(i));
			pendingPaymentList.add(pendingPayment);
		}
		System.out.println(PaymentService.makePayment(pendingPaymentList, paymentList));
	}

}
