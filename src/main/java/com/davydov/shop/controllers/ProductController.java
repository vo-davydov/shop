package com.davydov.shop.controllers;

import java.util.List;
import com.davydov.shop.dto.ProductDto;
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
@RequestMapping("/api/v1/products")
public class ProductController {
  private ProductService productService;

  @GetMapping
  public List<ProductDto> findAllProducts() {
    return productService.findAll();
  }

  @GetMapping("/{id}")
  public ProductDto findById(@PathVariable Long id) {  //todo exceptions
    return productService.findProductDtoById(id).orElseThrow(() -> new RuntimeException("Not found!!!"));
  }

  @PostMapping
  public Product createNewProduct(@RequestBody Product product) {
    product.setId(null);

    return productService.save(product);
  }

  @PutMapping
  public Product updateProduct(@RequestBody Product product) {
    return productService.save(product);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    productService.deleteById(id);
  }
}
