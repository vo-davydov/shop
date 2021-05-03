package com.davydov.shop.entity;

import javax.persistence.Enumerated;
import static javax.persistence.EnumType.STRING;

public enum ProductStatus {

  OUT_OF_STOCK("out_of_stock"),
  IN_STOCK("in_stock"),
  RUNNING_LOW("running_low");

  private String status;

  ProductStatus(String status) {
    this.status = status;
  }

  @Enumerated(STRING)
  public String getStatus() {
    return status;
  }

}
