package com.davydov.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
public class OrderItem extends AbstractEntity {
  @ManyToOne
  @JoinColumn(name = "order_id")
  private OrderEntity order;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @Column(name = "title")
  private String title;

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "price_per_product")
  private BigDecimal pricePerProduct;

  @Column(name = "price")
  private BigDecimal price;

  public OrderEntity getOrder() {
    return order;
  }

  public void setOrder(OrderEntity order) {
    this.order = order;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    OrderItem orderItem = (OrderItem) o;

    if (order != null ? !order.equals(orderItem.order) : orderItem.order != null) {
      return false;
    }
    if (product != null ? !product.equals(orderItem.product) : orderItem.product != null) {
      return false;
    }
    if (title != null ? !title.equals(orderItem.title) : orderItem.title != null) {
      return false;
    }
    if (quantity != null ? !quantity.equals(orderItem.quantity) : orderItem.quantity != null) {
      return false;
    }
    if (pricePerProduct != null ? !pricePerProduct.equals(orderItem.pricePerProduct) : orderItem.pricePerProduct != null) {
      return false;
    }
    return price != null ? price.equals(orderItem.price) : orderItem.price == null;
  }

  @Override
  public int hashCode() {
    int result = order != null ? order.hashCode() : 0;
    result = 31 * result + (product != null ? product.hashCode() : 0);
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
    result = 31 * result + (pricePerProduct != null ? pricePerProduct.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "OrderItem{" +
      "order=" + order +
      ", product=" + product +
      ", title='" + title + '\'' +
      ", quantity=" + quantity +
      ", pricePerProduct=" + pricePerProduct +
      ", price=" + price +
      '}';
  }
}
