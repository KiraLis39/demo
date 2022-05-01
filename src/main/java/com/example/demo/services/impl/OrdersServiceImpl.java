package com.example.demo.services.impl;

import com.example.demo.repositories.OrdersRepository;
import com.example.demo.repositories.entities.Order;
import com.example.demo.services.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис заказов (ордеров)
 */
@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;

    @Override
    public Optional<Order> findById(Long id) {
        return ordersRepository.findById(id);
    }

    @Override
    public Page<Order> findAll(int pageIndex, int pageSize) {
        return ordersRepository.findAll(PageRequest.of(pageIndex, pageSize));
    }

    @Override
    public void save(Order order) {
        ordersRepository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        ordersRepository.deleteById(id);
    }
}
