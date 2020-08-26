package com.metao.dp.lsp;

interface PaymentInstrumentValidator {
  void validate() throws PaymentInstrumentInvalidException;
}