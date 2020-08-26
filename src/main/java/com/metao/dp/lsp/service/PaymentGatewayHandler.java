package com.metao.dp.lsp.service;

import com.metao.dp.lsp.exception.PaymentFailedException;
import com.metao.dp.lsp.model.PaymentGatewayResponse;

public interface PaymentGatewayHandler {
    PaymentGatewayResponse handlePayment() throws PaymentFailedException;
}