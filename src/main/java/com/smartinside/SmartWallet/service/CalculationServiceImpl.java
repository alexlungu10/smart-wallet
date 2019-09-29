package com.smartinside.SmartWallet.service;

import com.smartinside.SmartWallet.FunctionalItem;
import com.smartinside.SmartWallet.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.smartinside.SmartWallet.Constants.*;

@org.springframework.stereotype.Service
public class CalculationServiceImpl implements CalculationService {
    ConvertorService convertorService;

  @Autowired
  public CalculationServiceImpl(ConvertorService convertorService) {
    this.convertorService = convertorService;
  }

  // TODO save it in repo when done
  // TODO CurrencyConvertor
  @Override
  public double getBalanceFromItemDTOList(List<ItemDTO> itemList) {
    final List<FunctionalItem> functionalItemList =
        itemList.stream().map(item -> FunctionalItem.of(item)).collect(Collectors.toList());

    final Optional<FunctionalItem> totalFunction =
        functionalItemList.stream().reduce((t, u) -> u.composeFunctionalItem(t));

      final Double totalAmountFromClient = totalFunction.orElse((i) -> i).apply(0d);
      //TODO take Currency from transaction DTO, or state that all the transactions are made in same currency
      return convertorService.getAmountInEuro( totalAmountFromClient, itemList.get(0).getCurrency());
  }
}
