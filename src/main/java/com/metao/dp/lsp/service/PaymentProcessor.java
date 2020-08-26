package com.metao.dp.lsp.service;

import com.metao.dp.lsp.exception.PaymentInstrumentInvalidException;
import com.metao.dp.lsp.model.PaymentResponse;
import com.metao.dp.lsp.exception.PaymentFailedException;
import com.metao.dp.lsp.model.OrderDetails;

public class PaymentProcessor {
  public void process(OrderDetails orderDetails, PaymentInstrument paymentInstrument) {
    try {
      paymentInstrument.validate();
      PaymentResponse response = paymentInstrument.collectPayment();
      saveToDatabase(orderDetails, response.getIdentifier());
    } catch (PaymentInstrumentInvalidException | PaymentFailedException e) {
      // exception handling
    }
  }

  void saveToDatabase(OrderDetails orderDetails, String identifier) {
    // save the identifier and order details in DB
  }
}