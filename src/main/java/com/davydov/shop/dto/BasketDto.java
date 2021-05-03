package com.davydov.shop.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BasketDto {
  private Long clientId;
  private List<Long> productIds;

}
