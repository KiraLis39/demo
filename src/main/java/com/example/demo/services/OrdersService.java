package com.example.demo.services;

import com.example.demo.repositories.entities.Order;
import org.springframework.data.domain.Page;
import java.util.Optional;

public interface OrdersService {
    Optional<Order> findById(Long id);
    Page<Order> findAll(int pageIndex, int pageSize);
    void save(Order order);
    void deleteById(Long id);
}
