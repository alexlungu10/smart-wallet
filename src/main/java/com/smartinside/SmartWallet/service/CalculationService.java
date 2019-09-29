package com.smartinside.SmartWallet.service;

import com.smartinside.SmartWallet.ItemDTO;

import java.util.List;

@org.springframework.stereotype.Service
public interface CalculationService {
  public double getBalanceFromItemDTOList( List<ItemDTO> item);
}
