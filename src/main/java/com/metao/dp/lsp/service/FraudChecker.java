package com.metao.dp.lsp.service;

import com.metao.dp.lsp.exception.FraudDetectedException;

public interface FraudChecker {
  void runChecks() throws FraudDetectedException;
}