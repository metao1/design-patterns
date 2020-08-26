package com.metao.dp.lsp;

import java.util.Date;

public class DebitCard extends BaseBankCard {

    public DebitCard(String name,
                     String cardNumber,
                     String verificationCode,
                     Date expiryDate,
                     PaymentInstrumentValidator basicValidator,
                     FraudChecker fraudChecker,
                     PaymentGatewayHandler gatewayHandler) {
        super(name, cardNumber, verificationCode, expiryDate, basicValidator, fraudChecker, gatewayHandler);
    }
}
