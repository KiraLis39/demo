package com.example.demo.dto;

import com.example.demo.repositories.entities.Order;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDTO {
    Long id;
    Long clientId;
    String clientName;
    Double price;
    Date createDate;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.clientId = order.getClient().getId();
        this.clientName = order.getClient().getName();
        this.price = order.getPrice();
        this.createDate = order.getCreateDate();
    }
}
