package com.example.demo.controllers;

import com.example.demo.dto.OrderDTO;
import com.example.demo.exceptions.OperationFailedException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.entities.Client;
import com.example.demo.repositories.entities.Order;
import com.example.demo.services.impl.ClientsServiceImpl;
import com.example.demo.services.impl.OrdersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersServiceImpl ordersService;
    private final ClientsServiceImpl clientsService;

    /**
     * Список всех заказов.
     */
    @GetMapping("/data")
    @ResponseBody
    public Page<OrderDTO> findAll(@RequestParam(defaultValue = "0", name = "p") int pageIndex) {
        return ordersService.findAll(pageIndex, 10).map(OrderDTO::new);
    }

    @GetMapping("/data/{id}")
    @ResponseBody
    public OrderDTO findById(@PathVariable Long id) {
        return new OrderDTO(ordersService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found order by id = " + id)));
    }

    /**
     * Сохраняем новый заказ.
     */
    @PostMapping
    @ResponseBody
    public void save(@RequestBody Order order) {
        ordersService.save(order);
    }

    @PutMapping
    @ResponseBody
    public OrderDTO update(@RequestBody OrderDTO orderDTO) {
        Optional<Order> orderOp = ordersService.findById(orderDTO.getId());
        if (orderOp.isPresent()) {
            Order order = orderOp.get();
            Optional<Client> clientOp = clientsService.findById(orderDTO.getClientId());
            if (clientOp.isPresent()) {
                order.setClient(clientOp.get());
                ordersService.save(order);
                return new OrderDTO(order);
            }
        }
        throw new OperationFailedException("Operation was failed!");
    }

    /**
     * Удаление заказа
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Order order) {
        ordersService.deleteById(order.getId());
    }

    /**
     * Модификация данных клиента в заказе:
     * смена id клиента в заказе.
     */
    @PutMapping("/update")
    @ResponseBody
    public OrderDTO updateClientId(@RequestBody OrderDTO orderDTO) {
        Order order = ordersService.findById(orderDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Order not found by id = " + orderDTO.getId()));
        Client newClient = clientsService.findById(orderDTO.getClientId()).orElseThrow(() -> new ResourceNotFoundException("Client not found by id = " + orderDTO.getClientId()));

        order.setClient(newClient);
        ordersService.save(order);
        return new OrderDTO(order);
    }
}
