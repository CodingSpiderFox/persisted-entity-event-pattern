package com.example.persistedentityeventpattern.application.orders.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor()
@Builder()
 public class CreateOrderRequestDto {

    @Getter
    @Setter
    private String email;
}