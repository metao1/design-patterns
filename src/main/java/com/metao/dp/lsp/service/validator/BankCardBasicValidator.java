package com.metao.dp.lsp.service.validator;

import com.metao.dp.lsp.exception.PaymentInstrumentInvalidException;

import java.util.Date;

public class BankCardBasicValidator implements PaymentInstrumentValidator {
  String name;
  String cardNumber;
  String verificationCode;
  Date expiryDate;

  public BankCardBasicValidator(String name, String cardNumber, String verificationCode, Date expiryDate) {
    this.name = name;
    this.cardNumber = cardNumber;
    this.verificationCode = verificationCode;
    this.expiryDate = expiryDate;
  }

  @Override
  public void validate() throws PaymentInstrumentInvalidException {
    // basic validation on name, expiryDate etc.
    if (name == null || name.isEmpty()) {
      throw new PaymentInstrumentInvalidException("Name is invalid");
    }
    // other basic validations
  }
}
