package com.mrinmoy.ninjacart.service;

import com.mrinmoy.ninjacart.model.PendingPayment;
import com.mrinmoy.ninjacart.model.SuccessfulPayment;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.UUID;

@Component
public class PaymentService {

    public static List<SuccessfulPayment> makePayment(List<PendingPayment> pendingPaymentList, List<Double> payment) {
        List<SuccessfulPayment> successfulPayments = new ArrayList<>();
        double total = 0d;
        for(double x : payment){total += x;}
        PriorityQueue<PendingPayment> payments = new PriorityQueue<>(pendingPaymentList);
        while (!payments.isEmpty() && total > 0d) {
            PendingPayment pendingPayment = payments.poll();
            SuccessfulPayment successfulPayment = new SuccessfulPayment();
            successfulPayment.setId(UUID.randomUUID().toString());
            successfulPayment.setPaymentDate(LocalDate.now());
            successfulPayment.setDueDate(pendingPayment.getDueDate());
            successfulPayment.setType(pendingPayment.getType());
            successfulPayment.setPaymentId(pendingPayment.getId());
            if (pendingPayment.getAmount() > total) {
                successfulPayment.setAmount(total);
                total = 0d;
            }else  {
                successfulPayment.setAmount(pendingPayment.getAmount());
                total -= pendingPayment.getAmount();
            }
            successfulPayments.add(successfulPayment);
            pendingPaymentList.remove(pendingPayment);
        }

        if(total > 0){
            System.out.println("Extra payment : "+ total);
        }
        return successfulPayments;
    }
}
