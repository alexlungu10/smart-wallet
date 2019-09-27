package com.smartinside.SmartWallet;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class CalculationServiceImpl implements CalculationService {
  // TODO save it in repo when done
  // TODO CurrencyConvertor
  @Override
  public double getBalanceFromItemDTOList(List<ItemDTO> itemList) {
    final List<FunctionalItem> functionalItemList =
        itemList.stream().map(item -> FunctionalItem.of(item)).collect(Collectors.toList());

    final Optional<FunctionalItem> totalFunction =
        functionalItemList.stream().reduce((t, u) -> u.composeFunctionalItem(t));

    return totalFunction.orElse((i) -> i).apply(0d);
  }
}
