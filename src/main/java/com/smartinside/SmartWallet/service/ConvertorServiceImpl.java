package com.smartinside.SmartWallet.service;

import com.smartinside.SmartWallet.Constants;
import com.smartinside.SmartWallet.Currency;

import static com.smartinside.SmartWallet.Constants.*;

public class ConvertorServiceImpl implements ConvertorService {

  public double convertUSDToEuro(double amount) {
    return amount * getConversionRatesRepo(Constants.USD_CURRENCY);
  }

  public double convertBTCToEuro(double amount) {
    return amount * getConversionRatesRepo(Constants.BTC_CURRENCY);
  }

  public double convertGBPToEuro(double amount) {
    return amount * getConversionRatesRepo(GBP_CURRENCY);
  }

  @Override
  public double getAmountInEuro(Double totalAmountFromClient, String currency) {
    if (GBP_CURRENCY.equalsIgnoreCase(currency)) {
      return Currency.GBP_TO_EURO.getOperation().apply(this, totalAmountFromClient);
    }
    if (USD_CURRENCY.equalsIgnoreCase(currency)) {
      return Currency.USD_TO_EURO.getOperation().apply(this, totalAmountFromClient);
    }
    if (BTC_CURRENCY.equalsIgnoreCase(currency)) {
      return Currency.BTC_TO_EURO.getOperation().apply(this, totalAmountFromClient);
    }
    return 0;
  }

  // TODO create Repo here
  double getConversionRatesRepo(String fromCurrency) {
    return 1;
  }
}
