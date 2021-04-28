package com.davydov.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "sys_order")
public class OrderEntity extends AbstractEntity {
  @OneToMany(mappedBy = "order")
  private List<OrderItem> orderItems;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private User owner;

  @Column(name = "address")
  private String address;

  @Column(name = "price")
  private Integer price;

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
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

    OrderEntity that = (OrderEntity) o;

    if (orderItems != null ? !orderItems.equals(that.orderItems) : that.orderItems != null) {
      return false;
    }
    if (owner != null ? !owner.equals(that.owner) : that.owner != null) {
      return false;
    }
    if (address != null ? !address.equals(that.address) : that.address != null) {
      return false;
    }
    return price != null ? price.equals(that.price) : that.price == null;
  }

  @Override
  public int hashCode() {
    int result = orderItems != null ? orderItems.hashCode() : 0;
    result = 31 * result + (owner != null ? owner.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "OrderEntity{" +
      "orderItems=" + orderItems +
      ", owner=" + owner +
      ", address='" + address + '\'' +
      ", price=" + price +
      '}';
  }
}
