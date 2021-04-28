package com.davydov.shop.repositories;

import java.util.List;
import com.davydov.shop.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
  List<OrderEntity> findAllByOwnerUsername(String ownerUsername);
}
