package com.davydov.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "sys_product")
public class Product extends AbstractEntity {

  @Column(name = "title")
  private String title;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "status")
  private ProductStatus status;

  @ManyToMany
  @JoinTable(name = "product_categories",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
  private Collection<Category> categories;

  public Product() {

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

  public Collection<Category> getCategories() {
    return categories;
  }

  public void setCategories(Collection<Category> categories) {
    this.categories = categories;
  }

  public ProductStatus getStatus() {
    return status;
  }

  public void setStatus(ProductStatus status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Product product = (Product) o;

    if (title != null ? !title.equals(product.title) : product.title != null) {
      return false;
    }
    if (price != null ? !price.equals(product.price) : product.price != null) {
      return false;
    }
    return categories != null ? categories.equals(product.categories) : product.categories == null;
  }

  @Override
  public int hashCode() {
    int result = title != null ? title.hashCode() : 0;
    result = 31 * result + (price != null ? price.hashCode() : 0);
    result = 31 * result + (categories != null ? categories.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Product{" +
      "id='" + super.getId() + '\'' +
      "title='" + title + '\'' +
      ", price=" + price +
      ", categories=" + categories +
      '}';
  }
}
