package com.platzi.javatests.payments;

public class PaymentResponse {

    enum PaymentStatus {
        OK,
        ERROR
    }

    public PaymentResponse(PaymentStatus status) {
        this.status = status;
    }

    private PaymentStatus status;

    public PaymentStatus getStatus() {
        return status;
    }
}
