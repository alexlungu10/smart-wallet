package com.smartinside.SmartWallet;

import com.smartinside.SmartWallet.service.ConvertorService;

import java.util.function.BiFunction;

public enum Currency {
  GBP_TO_EURO(
      (ConvertorService convertorService, Double amount) ->
          convertorService.convertGBPToEuro(amount)),
  USD_TO_EURO(
      (ConvertorService convertorService, Double amount) ->
          convertorService.convertUSDToEuro(amount)),

  BTC_TO_EURO(
      (ConvertorService convertorService, Double amount) ->
          convertorService.convertBTCToEuro(amount));

  private BiFunction<ConvertorService, Double, Double> operation;

  Currency(BiFunction<ConvertorService, Double, Double> operation) {
    this.operation = operation;
  }

  public BiFunction<ConvertorService, Double, Double> getOperation() {
    return this.operation;
  }
}
