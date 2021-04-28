package com.davydov.shop.dto;

import java.math.BigDecimal;
import com.davydov.shop.entity.Product;

public class ProductDto {
  private Long id;
  private String title;
  private BigDecimal price;

  public ProductDto(Product product) {
    this.id = product.getId();
    this.title = product.getTitle();
    this.price = product.getPrice();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ProductDto that = (ProductDto) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }
    if (title != null ? !title.equals(that.title) : that.title != null) {
      return false;
    }
    return price != null ? price.equals(that.price) : that.price == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ProductDto{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", price=" + price +
      '}';
  }
}
