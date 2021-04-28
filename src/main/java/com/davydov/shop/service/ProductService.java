package com.davydov.shop.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.davydov.shop.dto.ProductDto;
import com.davydov.shop.entity.Product;
import com.davydov.shop.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
  private ProductRepository productRepository;

  public Optional<Product> findProductById(Long id) {
    return productRepository.findById(id);
  }

  public Optional<ProductDto> findProductDtoById(Long id) {
    return productRepository.findById(id).map(ProductDto::new);
  }

  public List<ProductDto> findAll() {
    return productRepository.findAll().stream().map(ProductDto::new).collect(Collectors.toList());
  }

  public Product save(Product product) {
    return productRepository.save(product);
  }

  public void deleteById(Long id) {
    productRepository.deleteById(id);
  }
}
