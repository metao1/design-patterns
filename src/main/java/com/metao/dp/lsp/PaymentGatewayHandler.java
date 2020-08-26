package com.metao.dp.lsp;

interface PaymentGatewayHandler {
    PaymentGatewayResponse handlePayment() throws PaymentFailedException;
}