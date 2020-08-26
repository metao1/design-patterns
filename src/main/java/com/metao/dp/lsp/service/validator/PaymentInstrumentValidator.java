package com.metao.dp.lsp.service.validator;

import com.metao.dp.lsp.exception.PaymentInstrumentInvalidException;

public interface PaymentInstrumentValidator {
  public void validate() throws PaymentInstrumentInvalidException;
}