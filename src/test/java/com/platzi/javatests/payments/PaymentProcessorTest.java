package com.platzi.javatests.payments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.platzi.javatests.payments.PaymentResponse.PaymentStatus.ERROR;
import static com.platzi.javatests.payments.PaymentResponse.PaymentStatus.OK;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PaymentProcessorTest {

    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    @BeforeEach
    void setUp() {
        paymentGateway = mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    void payment_is_correct() {
        when(paymentGateway.requestPayment(any())).thenReturn(new PaymentResponse(OK));

        assertTrue(paymentProcessor.makePayment(1000));
    }

    @Test
    void payment_is_wrong() {
        when(paymentGateway.requestPayment(any())).thenReturn(new PaymentResponse(ERROR));

        assertFalse(paymentProcessor.makePayment(1000));
    }
}