package com.smartinside.SmartWallet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
public class CalculationServiceTest {

    @Test
  public void test() {
    CalculationService calculationService = new CalculationServiceImpl();
    final double balanceFromItemDTOList =
        calculationService.getBalanceFromItemDTOList(
            Arrays.asList(
                ItemDTO.builder().imageName(Constants.ONE_JPG).operation("plus").build(),
                ItemDTO.builder().imageName(Constants.TWO_JPG).operation("plus").build(),
                ItemDTO.builder().imageName(Constants.THREE_JPG).operation("plus").build(),
                ItemDTO.builder().imageName(Constants.FOUR_JPG).operation("plus").build(),
                ItemDTO.builder().imageName(Constants.SEVEN_JPG).operation("minus").build()));
    Assert.assertEquals(3, balanceFromItemDTOList, 0);
  }
}
