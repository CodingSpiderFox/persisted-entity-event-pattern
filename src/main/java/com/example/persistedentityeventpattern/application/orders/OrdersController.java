package com.example.persistedentityeventpattern.application.orders;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistedentityeventpattern.application.orders.dtos.CreateOrderRequestDto;
import com.example.persistedentityeventpattern.application.orders.dtos.CreateOrderResponseDto;
import com.example.persistedentityeventpattern.domain.orders.Order;
import com.example.persistedentityeventpattern.domain.orders.OrdersService;

@RestController
class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("/orders")
    public CreateOrderResponseDto createOrder(@RequestBody CreateOrderRequestDto dto) {

        Order order = Order.builder().createdAt(Instant.now()).email(dto.getEmail()).build();

        order = ordersService.processOrder(order);

        return CreateOrderResponseDto.builder().email(order.getEmail()).id(order.getId()).createdAt(order.getCreatedAt()).build();
    }

}