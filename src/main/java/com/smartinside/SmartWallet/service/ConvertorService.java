package com.smartinside.SmartWallet.service;

public interface ConvertorService {

  public double convertUSDToEuro(double amount);

  public double convertBTCToEuro(double amount);

  public double convertGBPToEuro(double amount);

    double getAmountInEuro(Double totalAmountFromClient, String currency);
}
