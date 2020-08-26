package com.metao.dp.lsp.service;

import com.metao.dp.lsp.exception.PaymentInstrumentInvalidException;
import com.metao.dp.lsp.model.PaymentResponse;
import com.metao.dp.lsp.exception.PaymentFailedException;

public interface PaymentInstrument {
    void validate() throws PaymentInstrumentInvalidException;

    PaymentResponse collectPayment() throws PaymentFailedException;
}
