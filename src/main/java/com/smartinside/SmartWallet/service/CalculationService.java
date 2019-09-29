package com.smartinside.SmartWallet;

import java.util.List;

@org.springframework.stereotype.Service
public interface CalculationService {
  public double getBalanceFromItemDTOList( List<ItemDTO> item);
}
