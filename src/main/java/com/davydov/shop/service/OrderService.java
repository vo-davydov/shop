package com.davydov.shop.service;

import java.util.List;
import java.util.Optional;
import com.davydov.shop.entity.OrderEntity;
import com.davydov.shop.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
  private UserService userService;
  private OrderRepository orderRepository;


  public Optional<OrderEntity> findById(Long id) {
    return orderRepository.findById(id);
  }

  public List<OrderEntity> findAllByOwner(String username) {
    return orderRepository.findAllByOwnerUsername(username);
  }
}
