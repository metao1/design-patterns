package com.metao.dp.lsp;

import java.util.Date;

public class CreditCard extends BaseBankCard {

  public CreditCard(String name,
                    String cardNumber,
                    String verificationCode,
                    Date expiryDate,
                    PaymentInstrumentValidator basicValidator,
                    FraudChecker fraudChecker,
                    PaymentGatewayHandler gatewayHandler) {
    super(name, cardNumber, verificationCode, expiryDate, basicValidator, fraudChecker, gatewayHandler);
  }

  @Override
  public void validate() throws PaymentInstrumentInvalidException {
    basicValidator.validate();
    // additional validations for credit cards
  }

}