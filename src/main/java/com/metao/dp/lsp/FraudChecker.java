package com.metao.dp.lsp;

interface FraudChecker {
  void runChecks() throws FraudDetectedException;
}