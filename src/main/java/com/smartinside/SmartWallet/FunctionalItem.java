package com.smartinside.SmartWallet;

import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

public interface FunctionalItem extends Function<Double, Double> {

  static FunctionalItem of(ItemDTO item) {
    if (Constants.PLUS_OPERATION.equalsIgnoreCase(item.getOperation())) {
      return (x) -> x + parseNumberFromImage(item);
    }
    return (x) -> x - parseNumberFromImage(item);
  }

    static Double parseNumberFromImage(ItemDTO item) {
        final RestTemplate restTemplate = new RestTemplate();
        final String stringNumber = restTemplate.getForObject("http://127.0.0.1:5000/getNumberFromImage/"+item.getImageName(), String.class);
        System.out.println(String.format("Parsed Number from Python microservice: %s",stringNumber));
        return Double.valueOf(stringNumber);
    }

//  static Double parseNumberFromImage(ItemDTO item) {
//    // TODO call Python Image Recognition endpoint
//    switch (item.getImageName()) {
//      case "one.jpg":
//        return 1d;
//      case "two.jpg":
//        return 2d;
//      case "three.jpg":
//        return 3d;
//      case "four.jpg":
//        return 4d;
//      case "seven.jpg":
//        return 7d;
//      default:
//        return 0d;
//    }
  //}//

  default FunctionalItem composeFunctionalItem(FunctionalItem other) {
    return (x) -> apply(other.apply(x));
  }
}
