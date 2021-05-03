package com.davydov.shop.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.davydov.shop.beans.Basket;
import com.davydov.shop.dto.BasketDto;
import com.davydov.shop.entity.Product;
import com.davydov.shop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/basket")
public class BasketController {

  private Basket basket;
  private ProductService productService;

  @GetMapping
  public Map<Long, List<Long>> getAllBasket() {
    return basket.getBasket();
  }

  @GetMapping("/{id}")
  public List<Product> getProductsById(@PathVariable Long id) {
    List<Product> products = new ArrayList<>();
    basket.getBasket().get(id).forEach(p -> products.add(productService.findProductById(p).get()));
    return products;
  }

  @PostMapping
  public void createBasket(@RequestBody BasketDto basketDto) {
    basket.getBasket().put(basketDto.getClientId(), basketDto.getProductIds());
  }

  @PutMapping("/{id}")
  public List<Product> putNewProduct(@PathVariable Long id,
                                     @RequestBody List<Long> productIds) {
    basket.getBasket().get(id).addAll(productIds);
    List<Product> products = new ArrayList<>();
    basket.getBasket().get(id).forEach(p -> products.add(productService.findProductById(p).get()));
    return products;
  }

  @DeleteMapping("/{id}")
  public List<Product> deleteProduct(@PathVariable Long id,
                                     @RequestBody List<Long> productIds) {
    basket.getBasket().get(id).removeAll(productIds);
    List<Product> products = new ArrayList<>();
    basket.getBasket().get(id).forEach(p -> products.add(productService.findProductById(p).get()));
    return products;
  }
}
