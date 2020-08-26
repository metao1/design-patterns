package com.metao.dp.lsp;

import java.util.Date;

public class PaymentGatewayService implements PaymentGatewayHandler {
    String name;
    String cardNumber;
    String verificationCode;
    Date expiryDate;
    PaymentGateway gateway = new PaymentGateway();

    public PaymentGatewayService(String name, String cardNumber, String verificationCode, Date expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.verificationCode = verificationCode;
        this.expiryDate = expiryDate;
    }

    @Override
    public PaymentGatewayResponse handlePayment() throws PaymentFailedException {
        // send details to payment gateway (PG) and save the fingerprint
        // received from PG
        System.out.println("Sending details to payment gateway");
        String fingerprint = gateway.process(name, cardNumber, verificationCode, expiryDate);
        PaymentGatewayResponse pgResponse = new PaymentGatewayResponse();
        pgResponse.setFingerprint(fingerprint);
        System.out.println("Payment gateway response received");

        return pgResponse;
    }

}
