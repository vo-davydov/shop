package com.davydov.shop.dto;

import java.math.BigDecimal;
import com.davydov.shop.entity.OrderItem;

public class OrderItemDto {
  private Long productId;
  private String productTitle;
  private BigDecimal pricePerProduct;
  private BigDecimal price;
  private Integer quantity;

  public OrderItemDto(OrderItem orderItem) {
    this.productId = orderItem.getProduct().getId();
    this.productTitle = orderItem.getTitle();
    this.pricePerProduct = orderItem.getPricePerProduct();
    this.price = orderItem.getPrice();
    this.quantity = orderItem.getQuantity();
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public String getProductTitle() {
    return productTitle;
  }

  public void setProductTitle(String productTitle) {
    this.productTitle = productTitle;
  }

  public BigDecimal getPricePerProduct() {
    return pricePerProduct;
  }

  public void setPricePerProduct(BigDecimal pricePerProduct) {
    this.pricePerProduct = pricePerProduct;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    OrderItemDto that = (OrderItemDto) o;

    if (productId != null ? !productId.equals(that.productId) : that.productId != null) {
      return false;
    }
    if (productTitle != null ? !productTitle.equals(that.productTitle) : that.productTitle != null) {
      return false;
    }
    if (pricePerProduct != null ? !pricePerProduct.equals(that.pricePerProduct) : that.pricePerProduct != null) {
      return false;
    }
    if (price != null ? !price.equals(that.price) : that.price != null) {
      return false;
    }
    return quantity != null ? quantity.equals(that.quantity) : that.quantity == null;
  }

  @Override
  public int hashCode() {
    int result = productId != null ? productId.hashCode() : 0;
    result = 31 * result + (productTitle != null ? productTitle.hashCode() : 0);
    result = 31 * result + (pricePerProduct != null ? pricePerProduct.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
    result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "OrderItemDto{" +
      "productId=" + productId +
      ", productTitle='" + productTitle + '\'' +
      ", pricePerProduct=" + pricePerProduct +
      ", price=" + price +
      ", quantity=" + quantity +
      '}';
  }
}
