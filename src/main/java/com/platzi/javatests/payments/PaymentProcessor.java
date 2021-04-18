package com.platzi.javatests.payments;

public class PaymentProcessor {

    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount) {
        PaymentResponse paymentResponse = paymentGateway.requestPayment(new PaymentRequest(amount));
        if (paymentResponse.getStatus() == PaymentResponse.PaymentStatus.ERROR) {
            return false;
        }

        return true;
    }
}
