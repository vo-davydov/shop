package com.davydov.shop.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class Basket {
  private Map<Long, List<Long>> baskets;

  public Basket() {
    baskets = new HashMap<>();
  }

  public Map<Long, List<Long>> getBasket() {
    return baskets;
  }

}
