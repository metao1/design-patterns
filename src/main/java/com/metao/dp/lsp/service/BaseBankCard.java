package com.metao.dp.lsp.service;

import com.metao.dp.lsp.exception.FraudDetectedException;
import com.metao.dp.lsp.exception.PaymentFailedException;
import com.metao.dp.lsp.exception.PaymentInstrumentInvalidException;
import com.metao.dp.lsp.model.PaymentGatewayResponse;
import com.metao.dp.lsp.model.PaymentResponse;
import com.metao.dp.lsp.service.validator.PaymentInstrumentValidator;

import java.util.Date;

public abstract class BaseBankCard implements PaymentInstrument {
  String name;
  String cardNumber;
  String verificationCode;
  Date expiryDate;
  protected FraudChecker fraudChecker;
  protected PaymentGatewayHandler gatewayHandler;
  protected PaymentInstrumentValidator basicValidator;

  public BaseBankCard(String name,
                      String cardNumber,
                      String verificationCode,
                      Date expiryDate,
                      PaymentInstrumentValidator basicValidator,
                      FraudChecker fraudChecker,
                      PaymentGatewayHandler gatewayHandler) {
    this.name = name;
    this.cardNumber = cardNumber;
    this.verificationCode = verificationCode;
    this.expiryDate = expiryDate;
    this.basicValidator = basicValidator;
    this.fraudChecker = fraudChecker;
    this.gatewayHandler = gatewayHandler;
  }

  @Override
  public void validate() throws PaymentInstrumentInvalidException {
    basicValidator.validate();
  }

  @Override
  public PaymentResponse collectPayment() throws PaymentFailedException {
    PaymentResponse response = new PaymentResponse();
    try {
      fraudChecker.runChecks();
      PaymentGatewayResponse pgResponse = gatewayHandler.handlePayment();
      response.setIdentifier(pgResponse.getFingerprint());
    } catch (FraudDetectedException e) {
      e.printStackTrace();
    }
    return response;
  }
}