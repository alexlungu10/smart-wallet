package com.smartinside.SmartWallet;

import com.smartinside.SmartWallet.service.CalculationService;
import com.smartinside.SmartWallet.service.CalculationServiceImpl;
import com.smartinside.SmartWallet.service.ConvertorServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.smartinside.SmartWallet.Constants.GBP_CURRENCY;

@RunWith(SpringRunner.class)
public class CalculationServiceTest {

    public static final String PLUS = "plus";
    public static final String MINUS = "minus";

    @Test
  public void test() {
    CalculationService calculationService = new CalculationServiceImpl(new ConvertorServiceImpl());
    final double balanceFromItemDTOList =
        calculationService.getBalanceFromItemDTOList(
            Arrays.asList(
                ItemDTO.builder().imageName(Constants.ONE_JPG).operation(PLUS).currency(GBP_CURRENCY).build(),
                ItemDTO.builder().imageName(Constants.TWO_JPG).operation(PLUS).currency(GBP_CURRENCY).build(),
                ItemDTO.builder().imageName(Constants.THREE_JPG).operation(PLUS).currency(GBP_CURRENCY).build(),
                ItemDTO.builder().imageName(Constants.FOUR_JPG).operation(PLUS).currency(GBP_CURRENCY).build(),
                ItemDTO.builder().imageName(Constants.SEVEN_JPG).operation(MINUS).currency(GBP_CURRENCY).build()));

    // 10-7=3
    Assert.assertEquals(3, balanceFromItemDTOList, 0);

  }
  @Test
    public void test2(){
      final ItemDTO itemDTO = ItemDTO.builder().imageName("aaa").build();
      Function<ItemDTO,String> f=(ItemDTO i)->{
          i.setImageName("bbb");
          return "dsad";
      };
      System.out.println(f.apply(itemDTO));
      System.out.println(String.format("new object getImageName: %s", itemDTO.getImageName()));
      Map<Integer, List<Product>> collectorMapOfLists = productList.stream()
              .collect(Collectors.groupingBy(Product::getPrice));
  }
}
